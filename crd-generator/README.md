# CRD Generator

## Modules

- **CRD Generator API v2** - `io.fabric8:crd-generator-api-v2`  
  _Core implementation of the generator, based on [victools jsonschema-generator](https://github.com/victools/jsonschema-generator)._
- **CRD Generator Collector** - `io.fabric8:crd-generator-collector`  
  _Shared component to find and load compiled Custom Resource classes in directories and Jar files._
- **CRD Generator Maven Plugin** - `io.fabric8:crd-generator-maven-plugin`   
  _Maven plugin that generates CRDs during the build process._
- **CRD Generator CLI** - `io.fabric8:crd-generator-cli`    
  _CLI tool that generates CRDs when executed._

### Utility Modules
_(not published)_

- **test** - `io.fabric8:crd-generator-test`  
  _Approval tests for CRD Generator_

## Usage

- [Introduction and Annotation usage](../doc/CRD-generator.md)
- [CRD Generator Maven Plugin](maven-plugin/README.md)
- [CRD Generator CLI tool](cli/README.md)
- [CRD Generator usage with Gradle in build script](gradle/README.md)
