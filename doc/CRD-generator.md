# CRD generation

## Quick start

TBD

with Maven:

```xml
TBD
```

with Gradle:

```groovy
TBD
```

Now you can define a `class` that extends `io.fabric8.kubernetes.client.CustomResource`
and the corresponding CRD is generated in the folder: `target/classes/META-INF/fabric8`

For example, for code similar to:

```java
@Group("org.example")
@Version("v1alpha1")
@ShortNames("ex")
public class Example extends CustomResource<ExampleSpec, ExampleStatus> implements Namespaced {}

public class ExampleSpec {
  int someValue;
}

public class ExampleStatus {
  boolean error;
  String message;
}
```

Running the `compile` task will generate 2 files:

- `target/classes/META-INF/fabric8/examples.org.example-v1.yml`
- `target/classes/META-INF/fabric8/examples.org.example-v1beta1.yml`

The schema `<plural>.<group>-<CRD spec version>.yml` is used to calculate the file names.

The content of the `examples.org.example-v1.yml` looks similar to:

```yaml
apiVersion: apiextensions.k8s.io/v1
kind: CustomResourceDefinition
metadata:
  name: examples.org.example
spec:
  group: org.example
  names:
    kind: Example
    plural: examples
    shortNames:
    - ex
    singular: example
  scope: Namespaced
  versions:
  - name: v1alpha1
    schema:
      openAPIV3Schema:
        properties:
          spec:
            properties:
              someValue:
                type: integer
            type: object
          status:
            properties:
              error:
                type: boolean
              message:
                type: string
            type: object
        type: object
    served: true
    storage: true
    subresources:
      status: {}
```

## Features

### Deterministic Output

The CRDs are generated in a deterministic way: 
Properties and lists of the schema are ordered, so that it is possible to check the resulting CRDs into source-control without cluttering the history.

### com.fasterxml.jackson.annotation.JsonProperty

If a field or one of its accessors is annotated with `com.fasterxml.jackson.annotation.JsonProperty`

```java
public class ExampleSpec {
  @JsonProperty("myValue")
  int someValue;
}
```

The generated field in the CRD will be named after the value provided in the annotation instead of using the default name derived from the field name, such as:

```yaml
          spec:
            properties:
              myValue:
                type: integer
            type: object
```

### com.fasterxml.jackson.annotation.JsonPropertyDescription

If a field or one of its accessors is annotated with `com.fasterxml.jackson.annotation.JsonPropertyDescription`

```java
public class ExampleSpec {
  @JsonPropertyDescription("This is some value")
  int someValue;
}
```

The generated field in the CRD will preserve the provided description, such as:

```yaml
          spec:
            properties:
              someValue:
                description: This is some value
                type: integer
            type: object
```

### com.fasterxml.jackson.annotation.JsonIgnore

If a field or one of its accessors is annotated with `com.fasterxml.jackson.annotation.JsonIgnore`

```java
public class ExampleSpec {
  @JsonIgnore
  int someValue;
}
```

The field will be skipped in the generated CRD and will not appear in the schema for this type, such as:

```yaml
          spec:
            type: object
```

### io.fabric8.generator.annotation.Default

If a field or one of its accessors is annotated with `io.fabric8.generator.annotation.Default`

```java
public class ExampleSpec {
  @Default("foo")
  String someValue;
}
```

The field will have the `default` property in the generated CRD, such as:

```yaml
          spec:
            properties:
              someValue:
                default: foo
                type: string
            required:
            - someValue
            type: object
```

### io.fabric8.generator.annotation.Min

If a field or one of its accessors is annotated with `io.fabric8.generator.annotation.Min`

```java
public class ExampleSpec {
  @Min(-1)
  int someValue;
}
```

The field will have the `minimum` property in the generated CRD, such as:

```yaml
          spec:
            properties:
              someValue:
                minimum: -1.0
                type: integer
            required:
            - someValue
            type: object
```

### io.fabric8.generator.annotation.Max

If a field or one of its accessors is annotated with `io.fabric8.generator.annotation.Max`

```java
public class ExampleSpec {
  @Max(1)
  int someValue;
}
```

The field will have the `maximum` property in the generated CRD, such as:

```yaml
          spec:
            properties:
              someValue:
                maximum: 1.0
                type: integer
            required:
            - someValue
            type: object
```

### io.fabric8.generator.annotation.Pattern

If a field or one of its accessors is annotated with `io.fabric8.generator.annotation.Pattern`

```java
public class ExampleSpec {
  @Pattern("\\b[1-9]\\b")
  String someValue;
}
```

The field will have the `pattern` property in the generated CRD, such as:

```yaml
          spec:
            properties:
              someValue:
                pattern: "\\b[1-9]\\b"
                type: string
            required:
            - someValue
            type: object
```

### io.fabric8.generator.annotation.Nullable

If a field or one of its accessors is annotated with `io.fabric8.generator.annotation.Nullable`

```java
public class ExampleSpec {
  @Nullable
  String someValue;
}
```

The field will have the `nullable` property in the generated CRD, such as:

```yaml
          spec:
            properties:
              someValue:
                nullable: true
                type: string
            required:
            - someValue
            type: object
```

### io.fabric8.generator.annotation.Required

If a field or one of its accessors is annotated with `io.fabric8.generator.annotation.Required`

```java
public class ExampleSpec {
  @Required
  int someValue;
}
```

The field will be marked as `required` in the generated CRD, such as:

```yaml
          spec:
            properties:
              someValue:
                type: integer
            required:
            - someValue
            type: object
```

### io.fabric8.generator.annotation.ValidationRule

If a field or one of its accessors is annotated with `io.fabric8.generator.annotation.ValidationRule`

```java
public class ExampleSpec {
  @ValidationRule("self.startsWith('start-')")
  String someValue;
}
```

The field will have the `x-kubernetes-validations` property in the generated CRD, such as:

```yaml
          spec:
            properties:
              someValue:
                type: string
                x-kubernetes-validations:
                  - rule: self.startsWith('start-')
            type: object
```

If a class is annotated with  `io.fabric8.generator.annotation.ValidationRule`:

```java
@ValidationRule(value="self.someValue.startsWith('start-')")
public class ExampleSpec {
  String someValue;
}
```

The object will have the `x-kubernetes-validations` property in the generated CRD, such as:

```yaml
          spec:
            properties:
              someValue:
                type: string
            type: object
            x-kubernetes-validations:
              - rule: self.someValue.startsWith('start-')
```

Note that all occurences will end up in the resulting list if multiple `ValidationRule` annotations are defined on the same field and/or class.
The annotation can also be used on the CustomResource class itself, which allows to define CEL rules on the root-level.
Please look at the [example](crd-generator/api/src/test/java/io/fabric8/crd/example/k8svalidation/K8sValidation.java) and the resulting [CRD](crd-generator/api/src/test/resources/k8svalidations.samples.fabric8.io-v1.yml) to explore all features.

### io.fabric8.crd.generator.annotation.PrinterColumn

If a field or one of its accessors is annotated with `io.fabric8.crd.generator.annotation.PrinterColumn`

```java
public class ExampleSpec { 
  @PrinterColumn(name = "SOME_VALUE", priority = 1)
  int someValue;
}
```

The CRD generator will customize columns shown by the `kubectl get` command. Above example adds the `SOME_VALUE` column.

```yaml
          - additionalPrinterColumns:
            - jsonPath: .spec.someValue
              name: SOME_VALUE
              type: int
              priority: 1
```

### io.fabric8.crd.generator.annotation.SchemaFrom

If a field or one of its accessors is annotated with `io.fabric8.crd.generator.annotation.SchemaFrom`

```java
public class ExampleSpec {
  @SchemaFrom(ExampleStatus.class)
  int someValue;
}
```

The CRD generator will substitute the default type inferred from the field and replace it by the computed schema associated with the Java class provided as a value of the `SchemaFrom` annotation, as seen below, where `ExampleStatus` is the class defined in the example above:

```yaml
          spec:
            properties:
              someValue:
                properties:
                  error:
                    type: boolean
                  message:
                    type: string
                type: object
            type: object
```

### io.fabric8.crd.generator.annotation.SchemaSwap

If a class is annotated with `io.fabric8.crd.generator.annotation.SchemaSwap`

```java
@SchemaSwap(originalType = ExampleSpec.class, fieldName = "someValue", targetType = ExampleStatus.class)
public class Example extends CustomResource<ExampleSpec, ExampleStatus> implements Namespaced {}
```

The CRD generator will perform the same substitution as a `SchemaFrom` annotation with `value` equal to `targetType` was placed on the field named `fieldName` in the `originalType` class:

```yaml
          spec:
            properties:
              someValue:
                properties:
                  error:
                    type: boolean
                  message:
                    type: string
                type: object
            type: object
```

The name of the field is restricted to the original `fieldName` and should be backed by a matching concrete field of the matching class. Getters, setters, and constructors are not taken into consideration.

SchemaSwaps cannot currently be nested - if a more deeply nested class contains a swap for the same class and field, an exception will be thrown.

The `SchemaSwap` annotation has an optional `depth` property, which is for advanced scenarios involving cyclic references.  Since CRDs cannot directly represent cycles, the `depth` property may be used to control an unrolling of the representation in your CRD.  A `depth` of `0`, the default, performs the swap on the field without the `originalType` appearing in your CRD.  A `depth` of n will allow the `originalType` to appear in the CRD up to a nesting depth of `n`, with the specified field at the nth level terminated by the `targetType`.

### Generating `x-kubernetes-preserve-unknown-fields: true`

If a field or one of its accessors is annotated with
`com.fasterxml.jackson.annotation.JsonAnyGetter`/`com.fasterxml.jackson.annotation.JsonAnySetter`
or the field type is `com.fasterxml.jackson.databind.JsonNode`

```java
public class ExampleSpec {
  JsonNode someValue;

  @JsonAnyGetter
  JsonNode getSomeValue() {
    return someValue;
  }

  @JsonAnySetter
  void setSomeValue(JsonNode value) {
    this.someValue = value;
  }
}
```

Corresponding `x-kubernetes-preserve-unknown-fields: true` will be generated in the output CRD, such as:

```yaml
          spec:
            properties:
              someValue:
                type: object
                x-kubernetes-preserve-unknown-fields: true
            type: object
            x-kubernetes-preserve-unknown-fields: true
```

You can also annotate a field with `io.fabric8.crd.generator.annotation.PreserveUnknownFields`:

```java
interface ExampleInterface {}

public class ExampleSpec {
    @PreserveUnknownFields
    ExampleInterface someValue;
}
```

will be generated as:

```yaml
          spec:
            properties:
              someValue:
                type: object
                x-kubernetes-preserve-unknown-fields: true
            type: object
```

### io.fabric8.crd.generator.annotation.Annotations

If a custom resource class is annotated with `io.fabric8.crd.generator.annotation.Annotations`

```java
@Annotations({ "one=1", "two=2" })
public class Example extends CustomResource<ExampleSpec, ExampleStatus> implements Namespaced {}
```

The CRD generator will add the additional `annotations`:

```yaml
          metadata:
            name: examples.org.example
            annotations:
              one: "1"
              two: "2"
          spec:
            ...
```

### io.fabric8.crd.generator.annotation.Labels

If a custom resource class is annotated with `io.fabric8.crd.generator.annotation.Labels`

```java
@Labels({ "three=3", "four=4" })
public class Example extends CustomResource<ExampleSpec, ExampleStatus> implements Namespaced {}
```

The CRD generator will add the additional `labels`:

```yaml
          metadata:
            name: examples.org.example
            labels:
              four: "4"
              three: "3"
          spec:
            ...
```

### Multiple Custom Resource Versions

The CRD Generator supports multiple versions of the same kind. In this case a schema for each version will be generated and merged into a single CRD. Keep in mind, that only one version can be marked as stored at the same time!

```java
package io.fabric8.crd.example.multiple.v2;

@Group("sample.fabric8.io")
@Version(value = "v2", storage = true, served = true)
public class Multiple extends CustomResource<MultipleSpec, Void> {}

// -------

package io.fabric8.crd.example.multiple.v1;

@Group("sample.fabric8.io")
@Version(value = "v1", storage = false, served = true, deprecated = true)
public class Multiple extends CustomResource<MultipleSpec, Void> {}
```

Result:

```yaml
apiVersion: apiextensions.k8s.io/v1
kind: CustomResourceDefinition
metadata:
  name: multiples.sample.fabric8.io
spec:
  group: sample.fabric8.io
  names:
    kind: Multiple
    plural: multiples
    singular: multiple
  versions:
  - name: v2
    storage: true
    served: true
    schema:
      openAPIV3Schema:
        [...]
  - name: v1
    storage: false
    served: true
    deprecated: true
    schema:
      openAPIV3Schema:
        [...]
```


## Features cheatsheet

| Annotation                                                  | Description                                                                           |
|-------------------------------------------------------------|---------------------------------------------------------------------------------------|
| `com.fasterxml.jackson.annotation.JsonProperty`             | The field is named after the provided value instead of looking up the java field name |
| `com.fasterxml.jackson.annotation.JsonPropertyDescription`  | The provided text is be embedded in the `description` of the field                    |
| `com.fasterxml.jackson.annotation.JsonIgnore`               | The field is ignored                                                                  |
| `io.fabric8.crd.generator.annotation.PreserveUnknownFields` | The field have `x-kubernetes-preserve-unknown-fields: true` defined                   |
| `com.fasterxml.jackson.annotation.JsonAnyGetter`            | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined    |
| `com.fasterxml.jackson.annotation.JsonAnySetter`            | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined    |
| `io.fabric8.generator.annotation.Min`                       | The field defines a validation `min`                                                  |
| `io.fabric8.generator.annotation.Max`                       | The field defines a validation `max`                                                  |
| `io.fabric8.generator.annotation.Pattern`                   | The field defines a validation `pattern`                                              |
| `io.fabric8.generator.annotation.Nullable`                  | The field is marked as `nullable`                                                     |
| `io.fabric8.generator.annotation.Required`                  | The field is marked as `required`                                                     |
| `io.fabric8.generator.annotation.ValidationRule`            | The field or object is validated by a CEL rule                                        |
| `io.fabric8.crd.generator.annotation.SchemaFrom`            | The field type for the generation is the one coming from the annotation               |
| `io.fabric8.crd.generator.annotation.SchemaSwap`            | Similar to SchemaFrom, but can be applied at any point in the class hierarchy         |
| `io.fabric8.crd.generator.annotation.Annotations`           | Additional `annotations` in `metadata`                                                |
| `io.fabric8.crd.generator.annotation.Labels`                | Additional `labels` in `metadata`                                                     |
| `io.fabric8.crd.generator.annotation.PrinterColumn`         | Customize columns shown by the `kubectl get` command                                  |


A field of type `com.fasterxml.jackson.databind.JsonNode` is encoded as an empty object with `x-kubernetes-preserve-unknown-fields: true` defined.

## Experimental

### Generate CRDs in parallel
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
