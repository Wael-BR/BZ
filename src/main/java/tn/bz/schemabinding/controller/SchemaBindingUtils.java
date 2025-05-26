package tn.bz.schemabinding.controller;

import java.lang.reflect.*;
import java.util.*;

public class SchemaBindingUtils {

    public static Object buildJsonStructure(Class<?> clazz) {
        if (isPrimitiveOrWrapper(clazz) || clazz == String.class || clazz.isEnum()) {
            return "";
        }

        if (Collection.class.isAssignableFrom(clazz)) {
            return List.of();
        }

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
