# CRD-Generator - Maven Plugin

Maven plugin for the CRD-Generator: Generate CRDs from Java model during Maven builds.

## Usage

### Scan project for Custom Resource classes

By default, the `target/classes` (`${project.build.outputDirectory}`) directory will be scanned for Custom Resource classes and the resulting CRDs will be emitted
below `target/classes/META-INF/fabric8/` (`${project.build.outputDirectory}/META-INF/fabric8/`):

```xml
<plugin>
  <groupId>io.fabric8</groupId>
  <artifactId>crd-generator-maven-plugin</artifactId>
  <executions>
    <execution>
      <goals>
        <goal>generate</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

### Explicit Custom Resource classes

The involved Custom Resource classes can also be configured explicitly. In this case, scanning is skipped and only the
provided classes are used.

```xml
<plugin>
  <groupId>io.fabric8</groupId>
  <artifactId>crd-generator-maven-plugin</artifactId>
  <executions>
    <execution>
      <goals>
        <goal>generate</goal>
      </goals>
      <configuration>
        <customResourceClasses>
          <customResourceClass>io.fabric8.crd.maven.example.v1.MyCustomResource</customResourceClass>
          <customResourceClass>io.fabric8.crd.maven.example.v2.MyCustomResource</customResourceClass>
        </customResourceClasses>
      </configuration>
    </execution>
  </executions>
</plugin>
```

### Scan a dependency for Custom Resource classes

If CRDs for a Java model of an external project or another module should be generated, the dependency to be scanned must
be specified and added to the classpath.

```xml
<dependencies>
  <dependency>
    <groupId>io.fabric8.crd-generator.maven.example</groupId>
    <artifactId>custom-resources</artifactId>
  </dependency>
</dependencies>
<plugins>
<plugin>
  <groupId>io.fabric8</groupId>
  <artifactId>crd-generator-maven-plugin</artifactId>
  <executions>
    <execution>
      <goals>
        <goal>generate</goal>
      </goals>
      <configuration>
        <dependenciesToScan>
          <dependency>
            <groupId>io.fabric8.crd-generator.maven.example</groupId>
            <artifactId>custom-resources</artifactId>
          </dependency>
        </dependenciesToScan>
      </configuration>
    </execution>
  </executions>
</plugin>
</plugins>
```

### Restricting the classpath

By default, the plugin considers all classes of the current project and all runtime dependencies of
the project. This can be changed by setting `classpath` to one of the following values:

- `PROJECT_ONLY`: Only classes of the project
- `WITH_COMPILE_DEPENDENCIES`: Classes from the project and any compile time dependencies.
- `WITH_RUNTIME_DEPENDENCIES`: Classes from the project and any runtime dependencies. (default)
- `WITH_ALL_DEPENDENCIES`: Classes from the project, compile time and runtime dependencies.
- `WITH_ALL_DEPENDENCIES_AND_TESTS:`: Classes from the project (including tests), compile time, runtime and test
  dependencies.

### Filtering

The Custom Resource classes which should be used by the CRD Generator can be filtered package.
Either by including or excluding:

```xml
<dependencies>
  <dependency>
    <groupId>io.fabric8.crd-generator.maven.example</groupId>
    <artifactId>custom-resources</artifactId>
  </dependency>
</dependencies>
<plugins>
<plugin>
  <groupId>io.fabric8</groupId>
  <artifactId>crd-generator-maven-plugin</artifactId>
  <executions>
    <execution>
      <goals>
        <goal>generate</goal>
      </goals>
      <configuration>
        <exclusions>
          <packages>
            <package>io.fabric8.crd.maven.example.api.v1</package>
          </packages>
        </exclusions>
        <dependenciesToScan>
          <dependency>
            <groupId>io.fabric8.crd-generator.maven.example</groupId>
            <artifactId>custom-resources</artifactId>
          </dependency>
        </dependenciesToScan>
      </configuration>
    </execution>
  </executions>
</plugin>
</plugins>
```

### More Configuration Parameters

| Parameter                       | Description                                                                                                                                                                                    |
|---------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `outputDirectory`               | The output directory where the CRDs are emitted.<br>Default: `${project.build.outputDirectory}/META-INF/fabric8/`                                                                              |
| `forceIndex`                    | If `true`, a Jandex index will be created even if the directory or JAR file contains an existing index. See [Using existing indices](#using-existing-indices) for details.<br>Default: `false` |
| `forceScan`                     | If `true`, directories and JAR files are scanned even if Custom Resource classes are given.<br>Default: `false`                                                                                |
| `implicitPreserveUnknownFields` | If `true`, `x-kubernetes-preserve-unknown-fields: true` will be added to objects which contain an any-setter or any-getter.<br>Default: `false`                                                |
| `parallel`                      | If `true`, the CRDs will be generated in parallel.<br>Default: `true`                                                                                                                          |
| `skip`                          | If `true`, execution will be skipped.<br>Default: `false`                                                                                                                                      |

## Jandex

The CRD-Generator Maven plugin uses [jandex](https://github.com/smallrye/jandex) under the hood to
find Custom Resource classes.

Jandex allows to collect and aggregate metadata of compiled Java classes into an index, which can be used afterward to
search for classes which implement an interface, extend a class and/or are annotated by annotations.

The CRD-Generator Maven plugin creates the necessary index automatically and searches for 
Custom Resource classes in this index by using the following criteria:

- The class must implement the interface `HasMetadata`
- The class must be annotated by `@Group` and `@Version`

> [!NOTE]  
> The abstract class `CustomResource` implements `HasMetadata`.  
> As such a class which extends `CustomResource` will be found, too. 

> [!IMPORTANT]  
> If your Custom Resource class extends an own abstract class or own interface, so that `HasMetadata` is only
> implemented indirect, then ensure that this intermediate class is included in the scan / index.

### Using existing indices

If the project or the dependency to scan already contains a serialized Jandex index,
this pre-existing index will be used instead of generating an own index and will result in a small performance gain.

To always create an own index, set `forceIndex` to `true`.


