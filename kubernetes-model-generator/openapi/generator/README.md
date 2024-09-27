# Go OpenAPI generator

Generates OpenAPI 3.0 specification from Go code.

Intended for those types that have incomplete custom resource definition (CRD) files and types that are not exposed by the Kubernetes API server.

Many of these types are used for WebHooks.

## Generated Schemas

| Schema                 | Description                                                                                |
|------------------------|--------------------------------------------------------------------------------------------|
| kubernetes-config      | Types used in the Kubernetes configuration file (`.kube/config`)                           |
| api-machinery-extra    | Required types not exposed in the OpenAPI spec                                             |
| admission-registration | Additional types required for the admission registration API                               |
| apiextensions          | Additional types required for the apiextension API                                         |
| gateway-api            | https://github.com/kubernetes-sigs/gateway-api (should qualify as an extension instead)    |
| kustomize              | https://github.com/kubernetes-sigs/kustomize (should qualify as an extension instead)      |
| metrics-server         | https://github.com/kubernetes-sigs/metrics-server (should qualify as an extension instead) |


## Usage

```shell
./generator reflection $pathToTargetDirectory
```

## Additional notes and resources

- [OpenAPI definition for AdmissionReview](https://github.com/kubernetes/kubernetes/issues/84081)
