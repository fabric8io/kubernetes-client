# Java generation from CRD (preview)

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
    ...
  </configuration>
</plugin>
```

## Usage

Provide a `source` referencing a file or a folder containing your CRDs definitions in `yaml` or `json` format and a `target` directory where the relevant Java code should be generated.

The full list of options of the CLI is (output of `--help`):

```
Usage: java-gen [-hV] [-add-extra-annotations] [-enum-uppercase] -s=<source>
                [-suffix-strategy=<suffixStrategy>] -t=<target>
      -add-extra-annotations, --add-extra-annotations
                          Add extra lombok and sundrio annotation to the
                            generated classes
      -enum-uppercase, --enum-uppercase
                          Uppercase the enum values
  -h, --help              Show this help message and exit.
  -s, --source=<source>   The source(file or folder) with the
                            CustomResourceDefinition(s) to use
      -suffix-strategy, --suffix-strategy=<suffixStrategy>
                          The suffix strategy to be used
  -t, --target=<target>   The folder to write the generated sources
  -V, --version           Print version information and exit.
```

And the corresponding configurations of the Maven plugin are (output of `mvn help:describe -DgroupId=io.fabric8 -DartifactId=java-generator-maven-plugin -Dversion=<version> -Ddetail`):

```
    enumUppercase
      User property: fabric8.java-generator.enum-uppercase

    extraAnnotations
      User property: fabric8.java-generator.extra-annotations

    source
      Required: true
      User property: fabric8.java-generator.source

    suffixStrategy
      User property: fabric8.java-generator.suffix-strategy

    target (Default: ${basedir}/target/generated-sources/java)
      User property: fabric8.java-generator.target
```

## Compiling the generated code

The generated code depends on a few dependencies to succesfully compile:

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
