package tn.bz.schemabinding.service;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import io.github.classgraph.ClassInfo;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SchemaService {

    private static final String BASE_PACKAGE = "tn.bz.schema";
    private static final Set<String> EXCLUDED_SIMPLE_NAMES = Set.of("TMontant", "Adapter1", "ObjectFactory");



    public Set<String> listAvailableClasses() {
        try (ScanResult scanResult = new ClassGraph()
                .acceptPackages(BASE_PACKAGE)
                .enableClassInfo()
                .scan()) {

            return scanResult.getAllClasses().stream()
                    .map(ClassInfo::loadClass)
                    .filter(name -> name.getPackageName().startsWith(BASE_PACKAGE))
                    .filter(name -> !name.getName().contains("$"))
                    .filter(name -> !EXCLUDED_SIMPLE_NAMES.contains(name.getSimpleName())) // Exclude unwanted
                    .map(Class::getName)
                    .collect(Collectors.toSet());
        }
    }

    public Class<?> getClassByName(String fullyQualifiedName) throws ClassNotFoundException {
        return Class.forName(fullyQualifiedName);
    }
}
