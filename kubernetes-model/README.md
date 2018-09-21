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

## Update dependency API's

To update OpenShift/Kubernetes dependencies, run:
```
make vendoring
```
