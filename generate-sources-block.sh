#!/bin/bash

echo "        <executions>"

for file in src/main/resources/*.xsd; do
    [ -e "$file" ] || continue  # skip if no .xsd files
    filename=$(basename -- "$file")
    name="${filename%.*}"  # remove extension
    id=$(echo "$name" | tr '[:upper:]' '[:lower:]' | tr -c 'a-z0-9' '-')  # e.g., crs-neg-v2
    pkgname=$(echo "$name" | tr '[:upper:]' '[:lower:]' | tr -cd '[:alnum:]' | sed 's/^/tn.bz.schema./')

    echo "            <execution>"
    echo "                <id>generate-${id}</id>"
    echo "                <phase>generate-sources</phase>"
    echo "                <goals>"
    echo "                    <goal>xjc</goal>"
    echo "                </goals>"
    echo "                <configuration>"
    echo "                    <sources>"
    echo "                        <source>${file}</source>"
    echo "                    </sources>"
    echo "                    <outputDirectory>\${project.basedir}/src/main/java</outputDirectory>"
    echo "                    <packageName>${pkgname}</packageName>"
    echo "                    <clearOutputDir>false</clearOutputDir>"
    echo "                </configuration>"
    echo "            </execution>"
    echo
done

echo "        </executions>"
