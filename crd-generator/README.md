# CRD Generator

## Modules

### CRD Generator v1 (deprecated since 7.0.0)

- **CRD Generator API v1** - `io.fabric8:crd-generator-api`  
  _Core implementation of the old generator, based on [sundrio](https://github.com/sundrio/sundrio)._ 
- **CRD Generator annotation processing tool (APT)** - `io.fabric8:crd-generator-apt`  
  _Annotation processor which hooks into the build process to generate CRDs._

### CRD Generator v2
- **CRD Generator API v2** - `io.fabric8:crd-generator-api-v2`  
  _Core implementation of the new generator, based on [Jackson/jsonSchema](https://github.com/FasterXML/jackson-module-jsonSchema)._
- **CRD Generator Collector** - `io.fabric8:crd-generator-collector`  
  _Shared component to find and load compiled Custom Resource classes in directories and Jar files._
- **CRD Generator Maven Plugin** - `io.fabric8:crd-generator-maven-plugin`   
  _Maven plugin that generates CRDs during the build process._
- **CRD Generator CLI** - `io.fabric8:crd-generator-cli`    
  _CLI tool that generates CRDs when executed._

### Utility Modules
_(not published)_

- **test-apt** - `io.fabric8:crd-generator-test-apt`  
  _Integration tests for CRD Generator API v1 and the annotation processor tool_
- **test** - `io.fabric8:crd-generator-test`  
  _Approval tests for CRD Generator API v1 and v2_

## Usage

- [Introduction and Annotation usage](../doc/CRD-generator.md)
- [CRD Generator Maven Plugin](maven-plugin/README.md)
- [CRD Generator CLI tool](cli/README.md)
- [CRD Generator usage with Gradle in build script](gradle/README.md)

### Deprecated Tools

- [CRD Generator annotation processing tool (APT)](apt/README.md)
