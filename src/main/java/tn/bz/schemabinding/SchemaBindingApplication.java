package tn.bz.schemabinding;

import com.fasterxml.jackson.databind.ObjectMapper;
import tn.bz.schema.crsnegv2.Document;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import tn.bz.schema.crsnegv2.ObjectFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

@SpringBootApplication
public class SchemaBindingApplication {

    public static void main(String[] args) throws Exception {
        Map<String, Object> structure = new LinkedHashMap<>();
        structure.put("Document", buildJsonStructure(Document.class));

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("src/main/resources/json_output/document_structure.json"), structure);

        System.out.println("Formatted structure written to document_structure.json");


    }

    public static Object buildJsonStructure(Class<?> clazz) {
        if (isPrimitiveOrWrapper(clazz) || clazz == String.class || clazz.isEnum()) {
            return "";
        }

        if (Collection.class.isAssignableFrom(clazz)) {
            return List.of();
        }

        // 👇 Check for wrapper class with single List field
        Field[] fields = clazz.getDeclaredFields();
        List<Field> relevantFields = Arrays.stream(fields)
                .filter(f -> !Modifier.isStatic(f.getModifiers()) &&
                        !Modifier.isFinal(f.getModifiers()) &&
                        !f.getName().equals("serialVersionUID"))
                .toList();

        if (relevantFields.size() == 1) {
            Field soleField = relevantFields.get(0);
            Class<?> soleFieldType = soleField.getType();
            if (Collection.class.isAssignableFrom(soleFieldType)) {
                // Unwrap the wrapper class
                Type genericType = soleField.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    Type[] args = ((ParameterizedType) genericType).getActualTypeArguments();
                    if (args.length == 1 && args[0] instanceof Class<?>) {
                        Class<?> listElementType = (Class<?>) args[0];
                        String singular = listElementType.getSimpleName();
                        Map<String, Object> wrapped = new LinkedHashMap<>();
                        wrapped.put(singular, buildJsonStructure(listElementType));
                        return List.of(wrapped);
                    }
                }
            }
        }

        // 👇 Default behavior
        Map<String, Object> result = new LinkedHashMap<>();
        for (Field field : relevantFields) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            String jsonKey = capitalize(field.getName());

            if (Collection.class.isAssignableFrom(fieldType)) {
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    Type[] args = ((ParameterizedType) genericType).getActualTypeArguments();
                    if (args.length == 1 && args[0] instanceof Class<?>) {
                        Class<?> listElementType = (Class<?>) args[0];
                        String singular = listElementType.getSimpleName();
                        Map<String, Object> wrapped = new LinkedHashMap<>();
                        wrapped.put(singular, buildJsonStructure(listElementType));
                        result.put(jsonKey, List.of(wrapped));
                    } else {
                        result.put(jsonKey, List.of());
                    }
                } else {
                    result.put(jsonKey, List.of());
                }
            } else if (isJaxbComplexType(fieldType)) {
                result.put(jsonKey, buildJsonStructure(fieldType));
            } else {
                result.put(jsonKey, null);
            }
        }

        return result;
    }




    private static boolean isPrimitiveOrWrapper(Class<?> type) {
        return type.isPrimitive() ||
                type == Boolean.class || type == Byte.class || type == Character.class ||
                type == Short.class || type == Integer.class || type == Long.class ||
                type == Float.class || type == Double.class;
    }

    private static boolean isJaxbComplexType(Class<?> clazz) {
        return clazz.getPackageName().startsWith("tn.bz.schema") &&
                !clazz.isEnum() &&
                !clazz.isPrimitive() &&
                !clazz.getName().startsWith("java.");
    }


    private static String capitalize(String name) {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }




}




