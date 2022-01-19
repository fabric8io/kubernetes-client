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

For example, code similar to:

```java
@Group("org.example")
@Version("v1alpha1")
@ShortNames("ex")
@Plural("examples")
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
the file name is calculated as `<plural>.<group>-<apiVersion>.yml`.

The content of the `v1` looks similar to follow:

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

### JsonProperty

If a field or one of its accessors is annotated with `JsonProperty`

```java
public class ExampleSpec {
  @JsonProperty("myValue")
  int someValue;
}
```

The generated field in the CRD will be named after the value provided in the annotation, such as:

```yaml
          spec:
            properties:
              myValue:
                type: integer
            type: object
```

### JsonPropertyDescription

If a field or one of its accessors is annotated with `JsonPropertyDescription`

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

### JsonIgnore

If a field or one of its accessors is annotated with `JsonIgnore`

```java
public class ExampleSpec {
  @JsonIgnore
  int someValue;
}
```

The field will be skipped in the generated CRD, such as:

```yaml
          spec:
            type: object
```

### NotNull

If a field or one of its accessors is annotated with `NotNull`

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

### SchemaFrom

If a field or one of its accessors is annotated with `SchemaFrom`

```java
public class ExampleSpec {
  @SchemaFrom(ExampleStatus.class)
  int someValue;
}
```

For all the purposes of the CRD generator the type of the field will be picked up from the `class` passed as a parameter, such as:

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

### Generating `x-kubernetes-preserve-unknown-fields: true`

If a field or one of its accessors is annotated with `JsonAnyGetter`/`JsonAnySetter` or the field type is `JsonNode`

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

## Features cheatsheet

| Annotation | Description |
|-----------------------------------------------------------|---------------------------------------------------------------------------------------|
| `com.fasterxml.jackson.annotation.JsonProperty`           | The field is named after the provided value instead of looking up the java field name |
| `com.fasterxml.jackson.annotation.JsonPropertyDescription`| The provided text is be embedded in the `description` of the field                    |
| `com.fasterxml.jackson.annotation.JsonIgnore`             | The field is ignored                                                                  |
| `com.fasterxml.jackson.annotation.JsonAnyGetter`          | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined    |
| `com.fasterxml.jackson.annotation.JsonAnySetter`          | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined    |
| `javax.validation.constraints.NotNull`                    | The field is marked as `required`                                                     |
| `io.fabric8.crd.generator.annotation.SchemaFrom`          | The field type for the generation is the one coming from the annotation               |

A field of type `com.fasterxml.jackson.databind.JsonNode` is encoded as an empty object with `x-kubernetes-preserve-unknown-fields: true` defined.
