# Project Map

## Overview

Fabric8 Kubernetes Client is a Java client library that provides access to the
full Kubernetes and OpenShift REST APIs through a fluent DSL.

The project is a large multi-module Maven build targeting Java 11+. It has
pluggable HTTP client implementations and extension modules for Kubernetes
ecosystem projects such as Knative, Tekton, Istio, Volcano, and Chaos Mesh.

## Repository Layout

```text
kubernetes-client/                    # Root project
|-- kubernetes-client-api/            # Core API interfaces and abstractions
|-- kubernetes-client/                # Main client implementation
|-- kubernetes-model-generator/       # Generates model classes from K8s OpenAPI
|-- java-generator/                   # Generates Java from CRDs
|-- crd-generator/                    # CRD generator from Java classes
|-- generator-annotations/            # Annotations for code generation
|
|-- httpclient-jdk/                   # Java 11+ HTTP client implementation
|-- httpclient-okhttp/                # OkHttp3 implementation
|-- httpclient-jetty/                 # Jetty HTTP client
|-- httpclient-vertx/                 # Vert.x HTTP client, default
|
|-- kubernetes-tests/                 # Unit tests with mock server
|-- kubernetes-itests/                # Integration tests, require cluster
|
|-- junit/                            # Testing utilities
|   |-- kubernetes-server-mock/       # Mock Kubernetes server
|   |-- kubernetes-junit-jupiter/     # JUnit 5 integration
|   |-- mockwebserver/                # HTTP/WebSocket mock server
|   `-- kube-api-test/                # Real K8s API server testing
|
|-- extensions/                       # Additional API support
|   |-- knative/                      # Knative resources
|   |-- tekton/                       # Tekton CI/CD
|   |-- istio/                        # Istio service mesh
|   |-- volcano/                      # Volcano batch scheduling
|   |-- chaosmesh/                    # Chaos engineering
|   `-- ...
|
|-- openshift-client-api/             # OpenShift API interfaces
|-- openshift-client/                 # OpenShift implementation
|
|-- doc/                              # Documentation
|-- ide-config/                       # IDE configuration files
`-- kubernetes-examples/              # Usage examples
```

## Documentation Index

- `/doc/CHEATSHEET.md` - kubectl equivalents in Java.
- `/doc/FAQ.md` - frequently asked questions.
- `/doc/CRD-generator.md` - CRD generation from Java.
- `/doc/java-generation-from-CRD.md` - Java generation from CRDs.
- `/doc/kube-api-test.md` - testing with a real API server.
- `/doc/MIGRATION-v7.md` - migration guide for v7.
