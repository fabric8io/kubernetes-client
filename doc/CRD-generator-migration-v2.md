# Migration from CRD Generator v1 to CRD Generator v2

## Overview

### CRD Generator v1
_Deprecated since 7.0.0_

- **CRD Generator API v1** - `io.fabric8:crd-generator-api`  
  _Core implementation of the old generator, based on sundrio_
- **CRD Generator annotation processing tool (APT)** - `io.fabric8:crd-generator-apt`  
  _Annotation processor which hooks into the build process_

### CRD Generator v2
_GA since 7.0.0_

- **CRD Generator API v2** - `io.fabric8:crd-generator-api-v2`  
  _Core implementation of the generator, based on Jackson/JSON-Schema._
- **CRD Generator Collector** - `io.fabric8:crd-generator-collector`  
  _Shared component to find compiled Custom Resource classes in directories and Jar files._
- **CRD Generator Maven Plugin** - `io.fabric8:crd-generator-maven-plugin`   
  _Maven plugin that generates CRDs during the build process._
- **CRD Generator CLI** - `io.fabric8:crd-generator-cli`    
  _CLI tool that generates CRDs when executed._


