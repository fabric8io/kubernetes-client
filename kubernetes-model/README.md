# JSON Schema Generator for OpenShift v3 Origin API Objects

Uses [Go reflection](https://blog.golang.org/laws-of-reflection) to generate a JSON schema that describes one or more
API resources in OpenShift Origin.

## Prerequisites

- Install [Go](https://golang.org/doc/install)
- Install [Glide](https://github.com/Masterminds/glide#install)


## Getting the code

  ```
  git clone https://github.com/fabric8io/kubernetes-model $GOPATH/src/github.com/fabric8io/kubernetes-model
  ```


## Building

- Navigate into the cloned repo:

  ```
  cd $GOPATH/src/github.com/fabric8io/kubernetes-model
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
If you face any conflicts with the currect `vendor/` directory, you can simple remove it and next `make` would rebuild it.

If everything works well, you would have model upgraded to specified Kubernetes/Openshift models.
