#!/bin/bash

# Target main class file
MAIN_CLASS="src/main/java/tn/bz/schemabinding/SchemaBindingApplication.java"
JSON_DIR="src/main/resources/json_output"
mkdir -p "$JSON_DIR"

# Start writing the Java class
cat > "$MAIN_CLASS" <<EOF
package tn.bz.schemabinding;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;

@SpringBootApplication
public class SchemaBindingApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SchemaBindingApplication.class, args);
        System.out.println("Schema Binding");

        ObjectMapper mapper = new ObjectMapper();
EOF

# Loop over each ObjectFactory to generate instantiation and JSON writing
find src/main/java -name "ObjectFactory.java" | while read -r FACTORY; do
    PACKAGE_LINE=$(grep "^package" "$FACTORY")
    PACKAGE_NAME=$(echo "$PACKAGE_LINE" | sed 's/package //;s/;//')
    PACKAGE_DIR=${PACKAGE_NAME//./\/}
    SCHEMA_ID=$(basename "$PACKAGE_DIR")
    ROOT_CLASS="Document"

    echo "Processing package: $PACKAGE_NAME"

    cat >> "$MAIN_CLASS" <<EOF

        {
            System.out.println("Processing $SCHEMA_ID...");
            $PACKAGE_NAME.ObjectFactory factory = new $PACKAGE_NAME.ObjectFactory();
            $PACKAGE_NAME.$ROOT_CLASS root = factory.create$ROOT_CLASS();
            // Optional: populate fields here

            File outFile = new File("$JSON_DIR/${SCHEMA_ID}.json");
            outFile.getParentFile().mkdirs();
            mapper.writerWithDefaultPrettyPrinter().writeValue(outFile, root);
            System.out.println("✅ Written: " + outFile.getPath());
        }
EOF
done

# Close class
cat >> "$MAIN_CLASS" <<EOF
    }
}
EOF

echo "✅ Java main class generated at: $MAIN_CLASS"
