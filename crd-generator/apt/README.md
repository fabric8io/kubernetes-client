# CRD Generator Annotation Processor
_Deprecated since 7.0.0_

Please follow our [CRD Generator v2 Migration Guide](../../doc/CRD-generator-migration-v2.md) to replace it.

## Usage

with Maven:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>crd-generator-apt</artifactId>
    <scope>provided</scope>
</dependency>
```

with Gradle:

```groovy
dependencies {
    annotationProcessor 'io.fabric8:crd-generator-apt:<version>'
}
```

### Experimental

#### Generate CRDs in parallel

It's possible to speed up the CRDs generation by using parallel computation.
Please note that this feature is experimental, and it may lead to unexpected results.

To enable it, you need to set the `io.fabric8.crd.generator.parallel` property to `true` in the processor.

with Maven:

```xml
<plugin>
  <artifactId>maven-compiler-plugin</artifactId>
  <configuration>
    <compilerArgs>
      <arg>-Aio.fabric8.crd.generator.parallel=true</arg>
    </compilerArgs>
  </configuration>
</plugin>
```

with Gradle:

```groovy
tasks.withType(JavaCompile) {
  options.compilerArgs += ["-Aio.fabric8.crd.generator.parallel=true"]
}
```
