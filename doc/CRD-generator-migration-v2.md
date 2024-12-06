# Migration from CRD Generator v1 to CRD Generator v2

## Overview

### CRD Generator v1

_Deprecated since 7.0.0_

- **CRD Generator API v1** - `io.fabric8:crd-generator-api`  
  _Core implementation of the old generator, based on [sundrio](https://github.com/sundrio/sundrio)._
- **CRD Generator annotation processing tool (APT)** - `io.fabric8:crd-generator-apt`  
  _Annotation processor which hooks into the build process to generate CRDs._

### CRD Generator v2

_GA since 7.0.0_

- **CRD Generator API v2** - `io.fabric8:crd-generator-api-v2`  
  _Core implementation of the new generator, based on [Jackson/jsonSchema](https://github.com/FasterXML/jackson-module-jsonSchema)._
- **CRD Generator Collector** - `io.fabric8:crd-generator-collector`  
  _Shared component to find and load compiled Custom Resource classes in directories and Jar files._
- **CRD Generator Maven Plugin** - `io.fabric8:crd-generator-maven-plugin`   
  _Maven plugin that generates CRDs during the build process._
- **CRD Generator CLI** - `io.fabric8:crd-generator-cli`    
  _CLI tool that generates CRDs when executed._

## API Compatibility

CRD Generator v1 and v2 are using **the same set of annotations**.  
This means you can keep your code as is and replace just the CRD Generator
annotation processor with your [tool of choice](#new-tooling).

The API itself is not compatible but very similar.

## Breaking Changes

### New restrictions on annotations

With CRD Generator v2 the following annotations are restricted to certain field types:

- `@Min` and `@Max` are restricted to numeric fields
- `@Pattern` is restricted to string fields

### Migrating from v6

In case you are migrating directly from fabric8/kubernetes-client v6, the following change affects you:

The type of `format` in `@PrinterColumn` has changed from string to enum `PrinterColumnFormat`.

## New Tooling

To replace the [CRD Generator annotation processor](../crd-generator/apt/README.md) you can use the following tools:

- [CRD Generator Maven Plugin](../crd-generator/maven-plugin/README.md)
- [CRD Generator CLI tool](../crd-generator/cli/README.md)

The tools use the same base, which means they should generate the same CRDs if similar configuration
parameter are used. One of the enhancements of the new tooling is that they can be configured easily.
Please read the README of the tool for details on usage and configuration.

## New annotations

Several new annotations have been introduced since 7.0.0. They will be used by the **CRD Generator v2 implementation only**
since CRD Generator v1 won't get new features from now on.

- `@Categories`
- `@AdditionalPrinterColumn`
- `@SelectableField`
- `@AdditionalSelectableField`
- `@Size`

Read the Javadoc of the annotations and the [CRD Generator documentation](CRD-generator.md) to get details.

## `@Min` / `@Max` inclusiveness

The `@Min` and `@Max` annotations have been extended with a second argument to define the inclusiveness.
By default, the value in the annotation is meant to be inclusive like before.

## Annotated Types

`@Pattern`, `@Min`, `@Max` will be detected if they are used to annotate the type of a List or a Map.

Example:
```java
List<@Pattern("(a|b)") String> myList;
Map<String, @Pattern("(a|b)") String> myMap;
```
Result:
```yaml
myList:
  items:
    pattern: "(a|b)+"
    type: "string"
  type: "array"
myMap:
  additionalProperties:
    pattern: "(a|b)+"
    type: "string"
  type: "object"
```

## Default values for CRD fields can be numeric or boolean

Previously default values defined by `@Default` could only be used on string fields. 
With CRD Generator v2 defaults can be set on numeric and boolean fields, too.
In the same way is `@JsonProperty(defaultValue)` now working.

