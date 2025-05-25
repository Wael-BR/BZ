#!/bin/bash

echo "================ JAXB <executions> Block ================"
echo "                <executions>"

for file in src/main/resources/*.xsd; do
    [ -e "$file" ] || continue
    filename=$(basename "$file")
    base="${filename%.*}"
    id=$(echo "$base" | tr '[:upper:]' '[:lower:]' | tr -c 'a-z0-9' '-')
    pkg=$(echo "$base" | tr '[:upper:]' '[:lower:]' | tr -cd '[:alnum:]' | sed 's/^/tn.bz.schema./')

    echo "                    <execution>"
    echo "                        <id>generate-${id}</id>"
    echo "                        <phase>generate-sources</phase>"
    echo "                        <goals>"
    echo "                            <goal>xjc</goal>"
    echo "                        </goals>"
    echo "                        <configuration>"
    echo "                            <sources>"
    echo "                                <source>src/main/resources/${filename}</source>"
    echo "                            </sources>"
    echo "                            <outputDirectory>\${project.basedir}/src/main/java</outputDirectory>"
    echo "                            <packageName>${pkg}</packageName>"
    echo "                            <clearOutputDir>false</clearOutputDir>"
    echo "                        </configuration>"
    echo "                    </execution>"
done

echo "                </executions>"

echo
echo "================ build-helper-maven-plugin Block ================"
echo "                                <sources>"

for file in src/main/resources/*.xsd; do
    [ -e "$file" ] || continue
    filename=$(basename "$file")
    base="${filename%.*}"
    id=$(echo "$base" | tr '[:upper:]' '[:lower:]' | tr -c 'a-z0-9' '-')

    echo "                                    <source>\${project.build.directory}/generated-sources/jaxb/${id}</source>"
done

echo "                                </sources>"
