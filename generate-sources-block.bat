@echo off
setlocal EnableDelayedExpansion

:: === Prepare dynamic content ===
set "executionsBlock="
set "helperSourcesBlock="

:: JAXB <executions> block
set "executionsBlock=                <executions>"
for %%f in (src\main\resources\*.xsd) do (
    set "filename=%%~nxf"
    set "basename=%%~nf"
    set "id=!basename:_=-!"
    set "pkg=tn.bz.schema.!basename:_=!"

    set "executionsBlock=!executionsBlock!¶                    <execution>"
    set "executionsBlock=!executionsBlock!¶                        <id>generate-!id!</id>"
    set "executionsBlock=!executionsBlock!¶                        <phase>generate-sources</phase>"
    set "executionsBlock=!executionsBlock!¶                        <goals>"
    set "executionsBlock=!executionsBlock!¶                            <goal>xjc</goal>"
    set "executionsBlock=!executionsBlock!¶                        </goals>"
    set "executionsBlock=!executionsBlock!¶                        <configuration>"
    set "executionsBlock=!executionsBlock!¶                            <sources>"
    set "executionsBlock=!executionsBlock!¶                                <source>src/main/resources/!filename!</source>"
    set "executionsBlock=!executionsBlock!¶                            </sources>"
    set "executionsBlock=!executionsBlock!¶                            <outputDirectory>${project.basedir}/src/main/java</outputDirectory>"
    set "executionsBlock=!executionsBlock!¶                            <packageName>!pkg!</packageName>"
    set "executionsBlock=!executionsBlock!¶                            <clearOutputDir>false</clearOutputDir>"
    set "executionsBlock=!executionsBlock!¶                        </configuration>"
    set "executionsBlock=!executionsBlock!¶                    </execution>"
)
set "executionsBlock=!executionsBlock!¶                </executions>"

:: build-helper-maven-plugin <sources> block
set "helperSourcesBlock=                                        <sources>"
for %%f in (src\main\resources\*.xsd) do (
    set "basename=%%~nf"
    set "id=!basename:_=-!"
    set "helperSourcesBlock=!helperSourcesBlock!¶                                            <source>${project.build.directory}/generated-sources/jaxb/!id!</source>"
)
set "helperSourcesBlock=!helperSourcesBlock!¶                                        </sources>"

:: Replace ¶ with newlines using a for-loop workaround
set "pomFile=pom.xml"
break > "%pomFile%"

:: === Static header
>>"%pomFile%" echo ^<?xml version="1.0" encoding="UTF-8"?^>
>>"%pomFile%" echo ^<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd"^>
>>"%pomFile%" echo
>>"%pomFile%" echo     <modelVersion>4.0.0</modelVersion>
>>"%pomFile%" echo     <parent>
>>"%pomFile%" echo         <groupId>org.springframework.boot</groupId>
>>"%pomFile%" echo         <artifactId>spring-boot-starter-parent</artifactId>
>>"%pomFile%" echo         <version>3.5.0</version>
>>"%pomFile%" echo         <relativePath/>
>>"%pomFile%" echo     </parent>
>>"%pomFile%" echo
>>"%pomFile%" echo     <groupId>tn.BZ</groupId>
>>"%pomFile%" echo     <artifactId>schema-binding</artifactId>
>>"%pomFile%" echo     <version>0.0.1-SNAPSHOT</version>
>>"%pomFile%" echo     <name>schema-binding</name>
>>"%pomFile%" echo     <description>schema-binding</description>
>>"%pomFile%" echo
>>"%pomFile%" echo     <properties>
>>"%pomFile%" echo         <java.version>17</java.version>
>>"%pomFile%" echo     </properties>
>>"%pomFile%" echo
>>"%pomFile%" echo     <dependencies>
>>"%pomFile%" echo         <dependency>
>>"%pomFile%" echo             <groupId>org.springframework.boot</groupId>
>>"%pomFile%" echo             <artifactId>spring-boot-starter-web</artifactId>
>>"%pomFile%" echo         </dependency>
>>"%pomFile%" echo         <dependency>
>>"%pomFile%" echo             <groupId>org.springframework.boot</groupId>
>>"%pomFile%" echo             <artifactId>spring-boot-starter-test</artifactId>
>>"%pomFile%" echo             <scope>test</scope>
>>"%pomFile%" echo         </dependency>
>>"%pomFile%" echo         <dependency>
>>"%pomFile%" echo             <groupId>jakarta.xml.bind</groupId>
>>"%pomFile%" echo             <artifactId>jakarta.xml.bind-api</artifactId>
>>"%pomFile%" echo             <version>4.0.2</version>
>>"%pomFile%" echo         </dependency>
>>"%pomFile%" echo         <dependency>
>>"%pomFile%" echo             <groupId>io.github.classgraph</groupId>
>>"%pomFile%" echo             <artifactId>classgraph</artifactId>
>>"%pomFile%" echo             <version>4.8.162</version>
>>"%pomFile%" echo         </dependency>
>>"%pomFile%" echo         <dependency>
>>"%pomFile%" echo             <groupId>org.glassfish.jaxb</groupId>
>>"%pomFile%" echo             <artifactId>jaxb-runtime</artifactId>
>>"%pomFile%" echo             <version>4.0.4</version>
>>"%pomFile%" echo         </dependency>
>>"%pomFile%" echo         <dependency>
>>"%pomFile%" echo             <groupId>org.reflections</groupId>
>>"%pomFile%" echo             <artifactId>reflections</artifactId>
>>"%pomFile%" echo             <version>0.10.2</version>
>>"%pomFile%" echo         </dependency>
>>"%pomFile%" echo         <dependency>
>>"%pomFile%" echo             <groupId>com.fasterxml.jackson.module</groupId>
>>"%pomFile%" echo             <artifactId>jackson-module-jaxb-annotations</artifactId>
>>"%pomFile%" echo             <version>2.15.0</version>
>>"%pomFile%" echo         </dependency>
>>"%pomFile%" echo         <dependency>
>>"%pomFile%" echo             <groupId>javax.xml.bind</groupId>
>>"%pomFile%" echo             <artifactId>jaxb-api</artifactId>
>>"%pomFile%" echo             <version>2.3.1</version>
>>"%pomFile%" echo         </dependency>
>>"%pomFile%" echo     </dependencies>
>>"%pomFile%" echo
>>"%pomFile%" echo     <build>
>>"%pomFile%" echo         <plugins>
>>"%pomFile%" echo             <plugin>
>>"%pomFile%" echo                 <groupId>org.codehaus.mojo</groupId>
>>"%pomFile%" echo                 <artifactId>jaxb2-maven-plugin</artifactId>
>>"%pomFile%" echo                 <version>3.1.0</version>

:: Insert JAXB executions
for %%L in (!executionsBlock!) do (
    set "line=%%L"
    echo !line:¶=^
!>>"%pomFile%"
)

>>"%pomFile%" echo                 <configuration>
>>"%pomFile%" echo                     <xjbSources>
>>"%pomFile%" echo                         <xjbSource>src/main/resources/global.xjb</xjbSource>
>>"%pomFile%" echo                     </xjbSources>
>>"%pomFile%" echo                     <outputDirectory>${project.basedir}/src/main/java</outputDirectory>
>>"%pomFile%" echo                     <clearOutputDir>false</clearOutputDir>
>>"%pomFile%" echo                 </configuration>
>>"%pomFile%" echo             </plugin>
>>"%pomFile%" echo             <plugin>
>>"%pomFile%" echo                 <artifactId>maven-compiler-plugin</artifactId>
>>"%pomFile%" echo                 <version>3.11.0</version>
>>"%pomFile%" echo                 <configuration>
>>"%pomFile%" echo                     <source>${java.version}</source>
>>"%pomFile%" echo                     <target>${java.version}</target>
>>"%pomFile%" echo                 </configuration>
>>"%pomFile%" echo             </plugin>
>>"%pomFile%" echo         </plugins>
>>"%pomFile%" echo     </build>
>>"%pomFile%" echo
>>"%pomFile%" echo     <profiles>
>>"%pomFile%" echo         <profile>
>>"%pomFile%" echo             <id>default</id>
>>"%pomFile%" echo             <build>
>>"%pomFile%" echo                 <resources>
>>"%pomFile%" echo                     <resource>
>>"%pomFile%" echo                         <directory>src/main/resources</directory>
>>"%pomFile%" echo                     </resource>
>>"%pomFile%" echo                 </resources>
>>"%pomFile%" echo                 <plugins>
>>"%pomFile%" echo                     <plugin>
>>"%pomFile%" echo                         <groupId>org.codehaus.mojo</groupId>
>>"%pomFile%" echo                         <artifactId>build-helper-maven-plugin</artifactId>
>>"%pomFile%" echo                         <version>3.4.0</version>
>>"%pomFile%" echo                         <executions>
>>"%pomFile%" echo                             <execution>
>>"%pomFile%" echo                                 <id>add-source</id>
>>"%pomFile%" echo                                 <phase>generate-sources</phase>
>>"%pomFile%" echo                                 <goals>
>>"%pomFile%" echo                                     <goal>add-source</goal>
>>"%pomFile%" echo                                 </goals>

:: Insert build-helper <sources>
for %%L in (!helperSourcesBlock!) do (
    set "line=%%L"
    echo !line:¶=^
!>>"%pomFile%"
)

>>"%pomFile%" echo                             </execution>
>>"%pomFile%" echo                         </executions>
>>"%pomFile%" echo                     </plugin>
>>"%pomFile%" echo                 </plugins>
>>"%pomFile%" echo             </build>
>>"%pomFile%" echo         </profile>
>>"%pomFile%" echo     </profiles>
>>"%pomFile%" echo </project>
>>"%pomFile%" echo <!-- ****************************************************** From pom.mustache template ****************************************************** -->
echo pom.xml has been regenerated successfully.
