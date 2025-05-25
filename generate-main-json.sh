#!/bin/bash

# Directory containing generated JAXB packages
JAVA_SRC_DIR="src/main/java"
OUTPUT_DIR="src/main/java/tn/bz/schemabinding/generated"
JSON_OUTPUT_DIR="src/main/resources/json_output"

# Clean previous files
mkdir -p "$OUTPUT_DIR"
mkdir -p "$JSON_OUTPUT_DIR"
rm -f "$OUTPUT_DIR"/*.java

# Loop through each ObjectFactory.java to determine JAXB root packages
find "$JAVA_SRC_DIR" -name "ObjectFactory.java" | while read -r factory_file; do
    PACKAGE_LINE=$(grep "^package" "$factory_file")
    PACKAGE_NAME=$(echo "$PACKAGE_LINE" | sed 's/package //;s/;//')
    PACKAGE_PATH=$(echo "$PACKAGE_NAME" | tr '.' '/')
    PACKAGE_LAST=$(basename "$PACKAGE_PATH")

    ROOT_CLASS="Document"  # Assuming root is always Document
    MAIN_CLASS_NAME="JsonGen_${PACKAGE_LAST^}"  # Capitalize first letter

    echo "Generating main for package: $PACKAGE_NAME"

    # Write Java file
    cat > "$OUTPUT_DIR/${MAIN_CLASS_NAME}.java" <<EOF
package tn.bz.schemabinding.generated;

import com.fasterxml.jackson.databind.ObjectMapper;
import $PACKAGE_NAME.ObjectFactory;
import $PACKAGE_NAME.$ROOT_CLASS;

public class ${MAIN_CLASS_NAME} {
    public static void main(String[] args) throws Exception {
        ObjectFactory factory = new ObjectFactory();
        $ROOT_CLASS document = factory.create$ROOT_CLASS();

        // TODO: Optionally populate fields here if needed

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);
        System.out.println(json);

        java.io.File output = new java.io.File("src/main/resources/json_output/${PACKAGE_LAST}.json");
        output.getParentFile().mkdirs();
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, document);
        System.out.println("✅ JSON written to " + output.getPath());
    }
}
EOF

done

echo "✅ Main classes generated in: $OUTPUT_DIR"
