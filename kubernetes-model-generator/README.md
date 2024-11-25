# Kubernetes and OpenShift model type generation

This project uses [OpenAPI](https://www.openapis.org/) schemas to generate the Java types that represent the Kubernetes and OpenShift API resources. 

The OpenAPI schemas used in the project come from different sources:
- Publicly available OpenAPI schemas from the Kubernetes and OpenShift projects.
- Self-generated OpenAPI schemas from the original Go structs using reflection, kube-openapi, and other methods.

To generate the Java types you can run the `make generate-model` command from the repository root.

## Available packages and projects

The [`openapi`](./openapi) directory contains several packages that are used to generate the Java types from the OpenAPI schemas.

### Golang OpenAPI generator

`github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator`

Golang project that generates the OpenAPI schemas for OpenShift and several Kubernetes extensions.

The generated schemas are stored and persisted in the [`openapi/schemas`](./openapi/schemas) directory.

### OpenAPI Model Generator Maven Plugin

A Maven plugin that generates the Java types from the OpenAPI schemas.

The plugin is used in the Kubernetes model modules to generate the applicable Java model types.

### Kubernetes Model Validator

Java library to validate Kubernetes and OpenShift resources against a global OpenAPI schema.
The library contains the `openshift-generated.json` OpenAPI schema file which has definitions for all of the Kubernetes resources and most of the OpenShift resources.
