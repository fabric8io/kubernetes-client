# CRD generation

## Quick start

Import the Annotation Processor into your build.

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
    ...
}
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

Running the `compile` task will generate 2 files
`target/classes/META-INF/fabric8/examples.org.example-v1.yml` and
`target/classes/META-INF/fabric8/examples.org.example-v1beta1.yml`,
the file name is calculated as `<plural>.<group>-<CRD spec version>.yml`.

The content of the `v1` looks similar to:

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
  @Min(1)
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
                maximum: "\\b[1-9]\\b"
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

__DEPRECATED:__ `javax.validation.constraints.NotNull`

If a field or one of its accessors is annotated with `io.fabric8.generator.annotation.Required`

```java
public class ExampleSpec {
  @NotNull
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

## Features cheatsheet

| Annotation                                                   | Description                                                                           |
|--------------------------------------------------------------|---------------------------------------------------------------------------------------|
| `com.fasterxml.jackson.annotation.JsonProperty`              | The field is named after the provided value instead of looking up the java field name |
| `com.fasterxml.jackson.annotation.JsonPropertyDescription`   | The provided text is be embedded in the `description` of the field                    |
| `com.fasterxml.jackson.annotation.JsonIgnore`                | The field is ignored                                                                  |
| `io.fabric8.crd.generator.annotation.PreserveUnknownFields`  | The field have `x-kubernetes-preserve-unknown-fields: true` defined                   |
| `com.fasterxml.jackson.annotation.JsonAnyGetter`             | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined    |
| `com.fasterxml.jackson.annotation.JsonAnySetter`             | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined    |
| `io.fabric8.generator.annotation.Min`                        | The field defines a validation `min`                                                  |
| `io.fabric8.generator.annotation.Max`                        | The field defines a validation `max`                                                  |
| `io.fabric8.generator.annotation.Pattern`                    | The field defines a validation `pattern`                                              |
| `io.fabric8.generator.annotation.Nullable`                   | The field is marked as `nullable`                                                     |
| `io.fabric8.generator.annotation.Required`                   | The field is marked as `required`                                                     |
| `io.fabric8.crd.generator.annotation.SchemaFrom`             | The field type for the generation is the one coming from the annotation               |
| `io.fabric8.crd.generator.annotation.SchemaSwap`             | Same as SchemaFrom, but can be applied at any point in the class hierarchy            |

A field of type `com.fasterxml.jackson.databind.JsonNode` is encoded as an empty object with `x-kubernetes-preserve-unknown-fields: true` defined.
