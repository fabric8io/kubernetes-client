# CRD generation (preview release)

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

### Supported annotations

| Annotation | Description |
|-----------------------------------------------------------|---------------------------------------------------------------------------------------|
| `com.fasterxml.jackson.annotation.JsonProperty`           | The field is named after the provided value instead of looking up the java field name |
| `com.fasterxml.jackson.annotation.JsonPropertyDescription`| The provided text is be embedded in the `description` of the field                    |
| `com.fasterxml.jackson.annotation.JsonIgnore`             | The field is ignored                                                                  |
| `com.fasterxml.jackson.annotation.JsonAnyGetter`          | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined    |
| `com.fasterxml.jackson.annotation.JsonAnySetter`          | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined    |
| `javax.validation.constraints.NotNull`                    | The field is marked as `required`                                                     |
| `io.fabric8.crd.generator.annotation.SchemaFrom`          | The field type for the generation is the one coming from the annotation               |

### Additional features

A field of type `com.fasterxml.jackson.databind.JsonNode` is encoded as an empty object with `x-kubernetes-preserve-unknown-fields: true` defined.
