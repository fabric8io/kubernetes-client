# Java generation from CRD

This document shows how to generate java sources from CRD manifests.

## Quick start CLI

The Java generator CLI is available for download on Sonatype at the link:

```
https://oss.sonatype.org/content/repositories/releases/io/fabric8/java-generator-cli/<version>/java-generator-cli-<version>.sh
```

you can get it working locally with few lines:

```bash
export VERSION=$(wget -q -O - http://github.com/fabric8io/kubernetes-client/releases/latest --header "Accept: application/json" | jq -r '.tag_name' | cut -c 2-)
wget https://oss.sonatype.org/content/repositories/releases/io/fabric8/java-generator-cli/$VERSION/java-generator-cli-$VERSION.sh
chmod a+x java-generator-cli-$VERSION.sh
./java-generator-cli-$VERSION.sh --version
```

Alternatively, if you already have [jbang](https://www.jbang.dev/) installed, you can run the CLI using it:

```bash
jbang io.fabric8:java-generator-cli:<version>
```

## Quick start Maven

The Java generator Maven plugin can be used from your project `pom.xml` adding a section like:

```xml
  <dependencies>
    <dependency>
      <groupId>io.fabric8</groupId>
      <artifactId>kubernetes-client</artifactId>
      <version>${kubernetes-client.version}</version>
    </dependency>
    <dependency>
      <groupId>io.fabric8</groupId>
      <artifactId>generator-annotations</artifactId>
      <version>${kubernetes-client.version}</version>
    </dependency>

    <!-- extraAnnotations requires these additional dependencies -->
    <dependency>
      <groupId>io.sundr</groupId>
      <artifactId>builder-annotations</artifactId>
      <version>${sundrio.version}</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>${lombok.version}</version>
      <scope>provided</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>io.fabric8</groupId>
        <artifactId>java-generator-maven-plugin</artifactId>
        <version>${kubernetes-client.version}</version>
        <executions>
          <execution>
            <goals>
              <goal>generate</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <source>src/main/resources/kubernetes</source>
          <!-- .. .-->
        </configuration>
      </plugin>
    </plugins>
  </build>
```

## Quick start Gradle

In a similar way with respect to the Maven plugin, the Java generator Gradle plugin can be used from your project 
`build.gradle` adding a section like:

```groovy
plugins {
  // ...
  id 'io.fabric8.java-generator' version "${kubernetesClientVersion}"
}
// ...
javaGen {
  source = file('src/main/resources/kubernetes')
}
```

The properties that can be used in the `javaGen` closure are the one defined by the plugin extension, i.e.
`JavaGeneratorPluginExtension`.
The Gradle plugin defines a `crd2java` task (see `gradle tasks --all`), that can be applied or called directly, e.g.:

```shell
gradle crd2Java 
```

## Usage

Provide a `source` referencing a file or a folder containing your CRDs definitions in `yaml` or `json` format and a `target` directory where the relevant Java code should be generated.

The full list of options of the CLI is (output of `--help`):

```
Usage: java-gen [-hV] [-add-extra-annotations] [-always-preserve-unknown]
                [-enum-uppercase]
                [-deserialization-datetime-format=<deserializationDateTimeFormat
                >] [-dt=<downloadTarget>] [-s=<source>]
                [-serialization-datetime-format=<serializationDateTimeFormat>]
                -t=<target> [-existing-java-types=<String=String>]...
                [-files-suffixes=<filesSuffixes>]...
                [-package-overrides=<String=String>]... [-u=<urls>]...
      -add-extra-annotations, --add-extra-annotations
                          Add extra lombok and sundrio annotation to the
                            generated classes
      -always-preserve-unknown, --always-preserve-unknown
                          Always preserve unknown fields in the generated
                            classes by emitting an additionalProperties field
      -deserialization-datetime-format, 
        --deserialization-datetime-format=<deserializationDateTimeFormat>
                          DateTime format used for Deserialization of fields of
                            type `date-time`
      -dt, --download-target=<downloadTarget>
                          The folder to be used as a target for the downloaded
                            crds
      -enum-uppercase, --enum-uppercase
                          Uppercase the enum values
      -existing-java-types, --existing-java-types=<String=String>
                          Mapping from fully qualified generated type to fully
                            qualified existing Java type
      -files-suffixes, --files-suffixes=<filesSuffixes>
                          Filter the source files with the specific suffixes
  -h, --help              Show this help message and exit.
      -package-overrides, --package-overrides=<String=String>
                          Apply the overrides to the package names
  -s, --source=<source>   The source(file or folder) with the
                            CustomResourceDefinition(s) to use
      -serialization-datetime-format, 
        --serialization-datetime-format=<serializationDateTimeFormat>
                          DateTime format used for Serialization of fields of
                            type `date-time`
  -t, --target=<target>   The folder to write the generated sources
  -u, --urls=<urls>       The source urls with the CustomResourceDefinition(s)
                            to use
  -V, --version           Print version information and exit.
```

And the corresponding configurations of the Maven plugin are (output of `mvn help:describe -DgroupId=io.fabric8 -DartifactId=java-generator-maven-plugin -Dversion=<version> -Ddetail`):

```
    alwaysPreserveUnknown
      User property: fabric8.java-generator.always-preserve-unknown
      Always preserve unknown fields in the generated classes by emitting an
      additionalProperties field

    datetimeDeserializationFormat
      User property: fabric8.java-generator.datetime-deserialization-format
      DateTime format used for Deserialization of fields of type `date-time`

    datetimeSerializationFormat
      User property: fabric8.java-generator.datetime-serialization-format
      DateTime format used for Serialization of fields of type `date-time`

    downloadTarget (Default: ${basedir}/target/manifests)
      User property: fabric8.java-generator.download-target
      The Download target folder for CRDs downloaded from remote URLs

    enumUppercase
      User property: fabric8.java-generator.enum-uppercase
      Generate uppercase Enums

    existingJavaTypes
      User property: fabric8.java-generator.existing-java-types
      Mapping from fully qualified generated type to fully qualified existing
      Java type

    extraAnnotations
      User property: fabric8.java-generator.extra-annotations
      Generate Extra annotation for lombok and sundrio integration

    filesSuffixes
      User property: fabric8.java-generator.files-suffixes
      Files suffixes to be processed

    generatedAnnotations
      User property: fabric8.java-generator.generated-annotations
      *advanced* Emit the @javax.annotation.processing.Generated annotation on
      the generated sources

    packageOverrides
      User property: fabric8.java-generator.package-overrides
      Package names to be substituted

    project (Default: ${project})
      (no description available)

    source
      User property: fabric8.java-generator.source
      The input file or directory to be used for generating sources

    target (Default: ${basedir}/target/generated-sources/java)
      User property: fabric8.java-generator.target
      The target folder to generate the Java sources

    urls
      User property: fabric8.java-generator.urls
      The URLs to be used to download CRDs from remote locations
```

### Configuration Examples

Below are examples of how to configure common options for Maven, Gradle, and the CLI, along with snippets showing how they affect the generated Java code.

#### 1. Uppercase Enums

Force the generated Enum constants to be uppercase.

**Maven:**
```xml
<configuration>
  <enumUppercase>true</enumUppercase>
</configuration>
````

**Gradle:**

```groovy
javaGen {
  enumUppercase = true
}
```

**CLI:**

```bash
--enum-uppercase
```

**Generated Code:**

```java
public enum Material {
    @com.fasterxml.jackson.annotation.JsonProperty("plastic")
    PLASTIC("plastic"), // Uppercase constant
    @com.fasterxml.jackson.annotation.JsonProperty("wood")
    WOOD("wood"); // Uppercase constant
    // ...
}
```

#### 2\. Package Overrides

Override the default package name generated from the CRD group and version.

**Maven:**

```xml
<configuration>
  <packageOverrides>
    <!-- Key must match the generated package name exactly -->
    <com.example.v1>com.mycompany.custom</com.example.v1>
  </packageOverrides>
</configuration>
```

**Gradle:**

```groovy
javaGen {
  packageOverrides = [
    // Key must match the generated package name exactly
    "com.example.v1": "com.mycompany.custom"
  ]
}
```

**CLI:**

```bash
--package-overrides=com.example.v1=com.mycompany.custom
```

**Generated Code:**

```java
package com.mycompany.custom; // Overridden package name

public class ToySpec implements KubernetesResource {
    // ...
}
```

#### 3\. Always Preserve Unknown Fields

Ensure that unknown fields in the JSON/YAML are captured in a map instead of being ignored.

**Maven:**

```xml
<configuration>
  <alwaysPreserveUnknown>true</alwaysPreserveUnknown>
</configuration>
```

**Gradle:**

```groovy
javaGen {
  alwaysPreserveUnknown = true
}
```

**CLI:**

```bash
--always-preserve-unknown
```

**Generated Code:**

```java
public class ToySpec implements KubernetesResource {
    
    @com.fasterxml.jackson.annotation.JsonAnyGetter
    @com.fasterxml.jackson.annotation.JsonAnySetter
    private java.util.Map<java.lang.String, java.lang.Object> additionalProperties = new java.util.HashMap<>();

    // ...
}
```

#### 4\. Filter Source Files

Process only specific files from the source directory.

**Maven:**

```xml
<configuration>
  <filesSuffixes>
    <suffix>.yaml</suffix>
    <suffix>.yml</suffix>
  </filesSuffixes>
</configuration>
```

**Gradle:**

```groovy
javaGen {
  filesSuffixes = [".yaml", ".yml"]
}
```

**CLI:**

```bash
--files-suffixes=.yaml --files-suffixes=.yml
```

#### 5\. Existing Java Types

Map a specific CRD type to an existing Java class instead of generating a new one. This is useful when you want to reuse existing POJOs.

**Maven:**

```xml
<configuration>
  <existingJavaTypes>
    <com.example.v1.ToySpec>com.mycompany.shared.ExistingToySpec</com.example.v1.ToySpec>
  </existingJavaTypes>
</configuration>
```

**Gradle:**

```groovy
javaGen {
  existingJavaTypes = [
    "com.example.v1.ToySpec": "com.mycompany.shared.ExistingToySpec"
  ]
}
```

**CLI:**

```bash
--existing-java-types=com.example.v1.ToySpec=com.mycompany.shared.ExistingToySpec
```

**Generated Code:**

```java
// The generator will skip generating 'ToySpec' and will reference the existing class instead.
import com.mycompany.shared.ExistingToySpec;

public class Toy implements HasMetadata {
    // ...
    private ExistingToySpec spec;
    // ...
}
```


## Compiling the generated code

The generated code depends on a few dependencies to successfully compile:

```xml
<dependency>
  <groupId>io.fabric8</groupId>
  <artifactId>kubernetes-client</artifactId>
</dependency>
<dependency>
  <groupId>io.fabric8</groupId>
  <artifactId>generator-annotations</artifactId>
</dependency>
```

and, if `--add-extra-annotations`/`extraAnnotations` has been set, the following dependencies should be included as well:
```xml
<dependency> 
  <groupId>io.sundr</groupId> 
  <artifactId>builder-annotations</artifactId> 
  <scope>provided</scope> 
</dependency> 
<dependency> 
  <groupId>org.projectlombok</groupId> 
  <artifactId>lombok</artifactId> 
  <scope>provided</scope> 
</dependency>
```
