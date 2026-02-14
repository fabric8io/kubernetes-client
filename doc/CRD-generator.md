# CRD Generator

The [CRD Generator annotation processing tool (APT)](../crd-generator/apt/README.md) (`io.fabric8:crd-generator-apt`) and its API (`io.fabric8:crd-generator-api`) are being deprecated and will eventually be removed once we offer a complete replacement for all users.

As a replacement, we're currently providing a new version of the API in `io.fabric8:crd-generator-api-v2` and a few tools to be able to leverage it in your projects.

A migration guide can be found [here](CRD-generator-migration-v2.md). 

The following list contains the available tooling:
- [CRD Generator Maven Plugin](../crd-generator/maven-plugin/README.md): A Maven plugin that generates CRDs during the build process.
- [CRD Generator CLI tool](../crd-generator/cli/README.md): A CLI tool that generates CRDs when executed.

## Quick start

Add the CRD Generator plugin to your project or use the CLI tool:

with Maven:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>io.fabric8</groupId>
      <artifactId>crd-generator-maven-plugin</artifactId>
      <version>${fabric8.kubernetes-client.version}</version>
      <executions>
        <execution>
          <goals>
            <goal>generate</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

with Gradle:

> [!NOTE]
> The Gradle plugin is not available yet.  
> Meanwhile, Gradle users can use the [CRD Generator in a build script](../crd-generator/gradle/README.md).

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

### com.fasterxml.jackson.annotation.JsonClassDescription

If a class is annotated with `com.fasterxml.jackson.annotation.JsonClassDescription`, the provided text will be used as the `description` for that object type in the generated CRD schema.

This ensures the description is associated with the class itself in the resulting schema:

```java
@JsonClassDescription("Description for the Example resource")
public class Example extends CustomResource<ExampleSpec, ExampleStatus> implements Namespaced {}

@JsonClassDescription("Description for the spec object")
public class ExampleSpec {
  private String field;
}

```

The generated CRD will include these descriptions for each object type:

```yaml
    schema:
      openAPIV3Schema:
        description: "Description for the Example resource"
        type: object
        properties:
          spec:
            description: "Description for the spec object"
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
            type: object
```

By default, the minimum value is *inclusive*.

If the value should be *exclusive* use `@Min(value = -1, inclusive = false)`:

```yaml
          spec:
            properties:
              someValue:
                minimum: -1.0
                exclusiveMinimum: true
                type: integer
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
            type: object
```

By default, the maximum value is *inclusive*.

If the value should be *exclusive* use `@Max(value = 1, inclusive = false)`:

```yaml
          spec:
            properties:
              someValue:
                maximum: 1.0
                exclusiveMaximum: true
                type: integer
            type: object
```

### io.fabric8.generator.annotation.Size

If a field or one of its accessors is annotated with `io.fabric8.generator.annotation.Size`

```java
public class ExampleSpec {
  @Size(min = 1, max = 3)
  String stringValue;
  @Size(min = 1, max = 3)
  List<String> listValue;
  @Size(min = 1, max = 3)
  Map<String, String> mapValue;
}
```

The field will have the `minLength`/`maxLength`, `minItems`/`maxItems`, `minProperties`/`maxProperties` properties 
in the generated CRD depending on the type:

```yaml
          spec:
            properties:
              stringValue:
                maxLength: 3
                minLength: 1
                type: string
              listValue:
                items:
                  type: "string"
                  maxItems: 3
                  minItems: 1
                type: "array"
              mapValue:
                additionalProperties:
                  type: "string"
                  maxProperties: 3
                  minProperties: 1
                type: "object"
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

#### Marking the custom resource's spec and status fields as required

The abstract `CustomResource` class contains the field definitions for the `spec` and `status` fields with just the basic annotations.
In case you want to mark these fields as required in your CRD, you can override the field getters in your `CustomResource` subclass and annotate them with `@Required`.

```java
public class Example extends CustomResource<ExampleSpec, ExampleStatus> {
  
  @Override
  @Required
  public ExampleSpec getSpec() {
    return super.getSpec();
  }

  @Override
  @Required
  public ExampleStatus getStatus() {
    return super.getStatus();
  }
}
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

### io.fabric8.crd.generator.annotation.AdditionalPrinterColumn

_since kubernetes-client 7.0.0 (crd-generator/api-v2)_

If a custom resource class is annotated with `io.fabric8.crd.generator.annotation.AdditionalPrinterColumn`

```java
@AdditionalPrinterColumn(name = "Age", jsonPath = ".metadata.creationTimestamp", type = Type.DATE)
public class Example extends CustomResource<ExampleSpec, ExampleStatus> {}
```

The CRD generator will add `additionalPrinterColumns`:

```yaml
         - additionalPrinterColumns:
           - jsonPath: ".metadata.creationTimestamp"
             name: "Age"
             priority: 0
             type: "date"
```

### io.fabric8.crd.generator.annotation.SelectableField

_since kubernetes-client 7.0.0 (crd-generator/api-v2)_

If a field or one of its accessors is annotated with `io.fabric8.crd.generator.annotation.SelectableField`

```java
public class ExampleSpec { 
  @SelectableField
  String category;
}
```

The CRD generator will add `selectableFields`:

```yaml
          - selectableFields:
            - jsonPath: .spec.category
```

### io.fabric8.crd.generator.annotation.AdditionalSelectableField

_since kubernetes-client 7.0.0 (crd-generator/api-v2)_

If a custom resource class is annotated with `io.fabric8.crd.generator.annotation.AdditionalSelectableField`

```java
@AdditionalSelectableField(jsonPath = ".spec.category")
public class Example extends CustomResource<ExampleSpec, ExampleStatus> {}
```

The CRD generator will add `selectableFields`:

```yaml
        - selectableFields:
            - jsonPath: .spec.category
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

If a property has type JsonNode or ObjectNode this will automatically result in marking the property as `x-kubernetes-preserve-unknown-fields: true`. For example:

```java
public class ExampleSpec {
  JsonNode someValue;

  JsonNode getSomeValue() {
    return someValue;
  }

  void setSomeValue(JsonNode value) {
    this.someValue = value;
  }
}
```

Will generate:

```yaml
          spec:
            properties:
              someValue:
                x-kubernetes-preserve-unknown-fields: true
```

The usage of ObjectNode further restrict the property type to `object`.

If a field or one of its accessors is annotated with
`com.fasterxml.jackson.annotation.JsonAnyGetter`/`com.fasterxml.jackson.annotation.JsonAnySetter`

```java
public class ExampleSpec {
  @JsonIgnore
  Map<String, Object> values = new LinkedHashMap<>();

  @JsonAnyGetter
  @JsonIgnore
  Map<String, Object> getValues() {
    return values;
  }

  @JsonAnySetter
  void setValue(String key, Object value) {
    this.someValue = value;
  }
}
```

The Corresponding `x-kubernetes-preserve-unknown-fields: true` will be generated in the output CRD if the resolving context has implicitPreserveUnknownFields=true:

```yaml
          spec:
            type: object
            x-kubernetes-preserve-unknown-fields: true
```

Alternatively if implicitPreserveUnknownFields=false you may force `x-kubernetes-preserve-unknown-fields: true` with the `io.fabric8.crd.generator.annotation.PreserveUnknownFields` annotation:

```java
@PreserveUnknownFields
public class ExampleSpec {
  @JsonIgnore
  Map<String, Object> values = new LinkedHashMap<>();

  @JsonAnyGetter
  @JsonIgnore
  Map<String, Object> getValues() {
    return values;
  }

  @JsonAnySetter
  void setValue(String key, Object value) {
    this.someValue = value;
  }
}
```

You can also annotate a field with `io.fabric8.crd.generator.annotation.PreserveUnknownFields`:

```java
interface ExampleInterface {}

public class ExampleSpec {
    @PreserveUnknownFields
    ExampleInterface someValue;
}
```

which will be generated as:

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

### Subresources

#### Status

The [status subresource](https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#status-subresource) will be emitted, if a status type has been defined for the Custom Resource:

```java
@Version("v1")
@Group("sample.fabric8.io")
public class WithStatusSubresource extends CustomResource<ExampleSpec, ExampleStatus> {}
```
Result:

```yaml
    subresources:
      status: {}
```

#### Scale

The [scale subresource](https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#scale-subresource)
will be emitted, if at least one field is marked with either `@SpecReplicas`, `@StatusReplicas` or `@LabelSelector`.
If used, `@SpecReplicas` and `@StatusReplicas` are both required to produce a valid CRD. `@LabelSelector` is optional.
All three annotations can be used only once per Custom Resource. Further constraints are:

| Annotation        | Allowed in Spec | Allowed in Status | Required Field Type |
|-------------------|:---------------:|:-----------------:|---------------------|
| `@SpecReplicas`   |       Yes       |        No         | `integer`           |
| `@StatusReplicas` |       No        |        Yes        | `integer`           |
| `@LabelSelector`  |       Yes       |        Yes        | `string`            |

```java
@Version("v1")
@Group("sample.fabric8.io")
public class WithScaleSubresource extends CustomResource<ExampleSpec, ExampleStatus> {}

public class ExampleSpec {
  @SpecReplicas
  int replicas;
}

public class ExampleStatus {
  @StatusReplicas
  int replicas;
  
  @LabelSelector
  String labelSelector;
}
```

Result:

```yaml
kind: "CustomResourceDefinition"
metadata:
  name: "withscalesubresources.sample.fabric8.io"
spec:
  group: "sample.fabric8.io"
  names:
    kind: "Replica"
    plural: "replicas"
    singular: "replica"
  scope: "Cluster"
  versions:
  - name: "v1"
    schema:
      openAPIV3Schema:
        properties:
          spec:
            properties:
              replicas:
                type: "integer"
            type: "object"
          status:
            properties:
              labelSelector:
                type: "string"
              replicas:
                type: "integer"
            type: "object"
        type: "object"
    served: true
    storage: true
    subresources:
      scale:
        labelSelectorPath: ".status.labelSelector"
        specReplicasPath: ".spec.replicas"
        statusReplicasPath: ".status.replicas"
      status: {}
```

### Multiple Custom Resource Versions

The CRD Generator supports multiple versions of the same kind. In this case a schema for each version will be generated and merged into a single CRD. Keep in mind, that only one version can be marked as stored at the same time!

```java
package io.fabric8.crd.example.multiple.v2;

@Group("sample.fabric8.io")
@Version(value = "v2", storage = true, served = true)
public class Multiple extends CustomResource<MultipleSpec, Void> {}
```

```java
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
        # [...]
  - name: v1
    storage: false
    served: true
    deprecated: true
    schema:
      openAPIV3Schema:
        # [...]
```

### Schema Customization

In some instances the built-in set of annotations and logic may not produce the desired CRD output. There is a mechanism
included in the crd-generator-api-v2 module for this. See the `io.fabric8.crdv2.generator.v1.SchemaCustomizer` annotation
for directly manipulating the JSONSchemaProps of the annotated resource. This annotation is applied last, after all of the other annotations are processed.

## Features cheatsheet

| Annotation                                                      | Description                                                                                         |
|-----------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| `com.fasterxml.jackson.annotation.JsonProperty`                 | The field is named after the provided value instead of looking up the java field name               |
| `com.fasterxml.jackson.annotation.JsonClassDescription`         | The provided text is embedded in the `description` of the class                                     |
| `com.fasterxml.jackson.annotation.JsonPropertyDescription`      | The provided text is embedded in the `description` of the field                                     |
| `com.fasterxml.jackson.annotation.JsonIgnore`                   | The field is ignored                                                                                |
| `io.fabric8.crd.generator.annotation.PreserveUnknownFields`     | The field have `x-kubernetes-preserve-unknown-fields: true` defined                                 |
| `com.fasterxml.jackson.annotation.JsonAnyGetter`                | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined                  |
| `com.fasterxml.jackson.annotation.JsonAnySetter`                | The corresponding object have `x-kubernetes-preserve-unknown-fields: true` defined                  |
| `io.fabric8.generator.annotation.Min`                           | The field's `minimum` value                                                                         |
| `io.fabric8.generator.annotation.Max`                           | The field's `maximum` value                                                                         |
| `io.fabric8.generator.annotation.Size`                          | The field (string, list/array, map) has size limits (`minLength`, `minItems`, `minProperties`, ...) |
| `io.fabric8.generator.annotation.Pattern`                       | The field defines a validation `pattern`                                                            |
| `io.fabric8.generator.annotation.Nullable`                      | The field is marked as `nullable`                                                                   |
| `io.fabric8.generator.annotation.Required`                      | The field is marked as `required`                                                                   |
| `io.fabric8.generator.annotation.ValidationRule`                | The field or object is validated by a CEL rule                                                      |
| `io.fabric8.crd.generator.annotation.SchemaFrom`                | The field type for the generation is the one coming from the annotation                             |
| `io.fabric8.crd.generator.annotation.SchemaSwap`                | Similar to SchemaFrom, but can be applied at any point in the class hierarchy                       |
| `io.fabric8.crd.generator.annotation.Annotations`               | Additional `annotations` in `metadata`                                                              |
| `io.fabric8.crd.generator.annotation.Labels`                    | Additional `labels` in `metadata`                                                                   |
| `io.fabric8.crd.generator.annotation.PrinterColumn`             | Define the field as PrinterColumn, so that it will be shown by the `kubectl get` command.           |
| `io.fabric8.crd.generator.annotation.AdditionalPrinterColumn`   | Define a PrinterColumn by JSON path, so that it will be shown by the `kubectl get` command.         |
| `io.fabric8.crd.generator.annotation.SelectableField`           | Define the field as selectable, so that it can be used for filtering.                               |
| `io.fabric8.crd.generator.annotation.AdditionalSelectableField` | Define a SelectableField by JSON path, so that it can be used for filtering.                        |
| `io.fabric8.kubernetes.model.annotation.SpecReplicas`           | The field is used in scale subresource as `specReplicaPath`                                         |
| `io.fabric8.kubernetes.model.annotation.StatusReplicas`         | The field is used in scale subresource as `statusReplicaPath`                                       |
| `io.fabric8.kubernetes.model.annotation.LabelSelector`          | The field is used in scale subresource as `labelSelectorPath`                                       |
| `io.fabric8.crdv2.generator.v1.SchemaCustomizer`                | Advanced: Allows direct manipulation of the `JSONSchemaProps` via a custom `Customizer` class       |


A field of type `com.fasterxml.jackson.databind.JsonNode` is encoded as an empty object with `x-kubernetes-preserve-unknown-fields: true` defined.

