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
  _Shared component to find compiled Custom Resource classes in directories and Jar files._
- **CRD Generator Maven Plugin** - `io.fabric8:crd-generator-maven-plugin`   
  _Maven plugin that generates CRDs during the build process._
- **CRD Generator CLI** - `io.fabric8:crd-generator-cli`    
  _CLI tool that generates CRDs when executed._

## API Compatibility

CRD Generator v1 and v2 are using **the same set of annotations**.  
This means you can keep your code as is and replace just the CRD Generator
annotation processor with [your tool of choice](#new-tooling).

The API itself is not compatible but very similar.

## New Tooling

To replace the CRD Generator annotation processor you can use the following tools:

- [CRD Generator Maven Plugin](../crd-generator/maven-plugin/README.md)
- [CRD Generator CLI tool](../crd-generator/cli/README.md)

The tools use the same core implementation, which means they should generate the same CRDs if the similar configuration
parameter are used. One of the enhancements of the new tooling is that they can be configured easily.
Please read the README of the tool for details on usage and configuration.

## New annotations since 7.0.0

Several new annotations have been introduced since 7.0.0. They will be used only by the CRD Generator v2 implementation
since CRD Generator v1 won't get new features from now on.

