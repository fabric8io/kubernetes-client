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
Usage: java-gen [-hV] [-add-extra-annotations] [-enum-uppercase]
                [-dt=<downloadTarget>] [-s=<source>]
                [-suffix-strategy=<suffixStrategy>] -t=<target>
                [-package-overrides=<String=String>]... [-u=<urls>]...
      -add-extra-annotations, --add-extra-annotations
                          Add extra lombok and sundrio annotation to the
                            generated classes
      -dt, --download-target=<downloadTarget>
                          The folder to be used as a target for the downloaded
                            crds
      -enum-uppercase, --enum-uppercase
                          Uppercase the enum values
      -files-suffixes, --files-suffixes=<filesSuffixes>
                          Filter the source files with the specific suffixes
  -h, --help              Show this help message and exit.
      -package-overrides, --package-overrides=<String=String>
                          Apply the overrides to the package names
  -s, --source=<source>   The source(file or folder) with the
                            CustomResourceDefinition(s) to use
  -t, --target=<target>   The folder to write the generated sources
  -u, --urls=<urls>       The source urls with the CustomResourceDefinition(s)
                            to use
  -V, --version           Print version information and exit.
```

And the corresponding configurations of the Maven plugin are (output of `mvn help:describe -DgroupId=io.fabric8 -DartifactId=java-generator-maven-plugin -Dversion=<version> -Ddetail`):

```

    downloadTarget (Default: ${basedir}/target/manifests)
      User property: fabric8.java-generator.download-target
      The Download target folder for CRDs downloaded from remote URLs

    enumUppercase
      User property: fabric8.java-generator.enum-uppercase
      Generate uppercase Enums

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
