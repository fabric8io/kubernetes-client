# JSON Schema Generator for OpenShift v3 Origin API Objects

Uses [Go reflection](https://blog.golang.org/laws-of-reflection) to generate a JSON schema that describes one or more
API resources in Kubernetes and OpenShift.

## Prerequisites

- Install [Go](https://golang.org/doc/install)


## Getting the code

  ```
  git clone https://github.com/fabric8io/kubernetes-client $GOPATH/src/github.com/fabric8io/kubernetes-client
  ```


## Building

- Navigate into the cloned repo:

  ```
  cd $GOPATH/src/github.com/fabric8io/kubernetes-client/kubernetes-model
  ```

- Run:
  ```
  make
  ```

  You should now be able to view the generated schema in `kube-schema.json`

## Update dependency API's/ Updating Kubernetes/Openshift model

You need to modify `Gopkg.lock`/`Gopkg.toml` files. We fetch go sources from Kubernetes Github repos and make a
JSON schema from it, which is then fed to jsonschema2pojo maven plugin. In order to upgrade you need to update
tags/references from these repos:

- [Kubernetes API](https://github.com/kubernetes/api)
- [Kubernetes APIextensions](https://github.com/kubernetes/apiextensions-apiserver)
- [Kubernetes pkg/watch](https://github.com/kubernetes/kubernetes/tree/master/pkg/watch/json)
- [Kubernetes APIMachinery](https://github.com/kubernetes/apimachinery)
- [Openshift API](https://github.com/openshift/api)
- [Kubernetes Client Go](https://github.com/kubernetes/client-go)

After modifying just run:
```
make
```
If you face any conflicts with the current `vendor/` directory, you can simple remove it and next `make` would rebuild it.

If everything works well, you would have model upgraded to specified Kubernetes/Openshift models.

 ## Project Structure
 
 The project contains the following "modules":
 
 ### Go Schema Generator
 
 This is the module that must be run first to generate the schema files that will be consumed
 by Java (jsonschema2pojo and after sundr.io).
 
 - `cmd/generate/generate.go` contains the main entry point and the descriptor of the schema.
   Add new entries to the `Schema` struct and `schemagen.PackageDescriptor` to generate
   an entry for any additional Go structs.
 - `pkg/schenage` package contains the source files with the logic to generate the schema.
 
 ### Kubernetes-Model-Annotator
 
 Defines a `KubernetesTypeAnnotator` with the sundr.io configuration.
 
 jsonschema2pojo annotates all of the generated classes with this custom annotator
 that is consumed by sundr.io.
 
 ### Kubernetes-Model
 
 This is the main project, its generated artifacts will be consumed by the rest of the
 kubernetes-client modules.
 
 The pom.xml file contains the necessary configuration to process the Go generated
 schema and build the model with jsonschema2pojo and sundr.io.
