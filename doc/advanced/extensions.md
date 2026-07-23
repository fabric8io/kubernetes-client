---
title: "Extensions"
description: "Use extension modules for Knative, Tekton, Istio, and more"
weight: 3
---

# Extensions

Fabric8 provides extension modules for popular Kubernetes ecosystem projects. Each extension adds typed DSL support for that project's custom resources.

## Available Extensions

| Extension | Artifact | Description |
|-----------|----------|-------------|
| **Knative** | `knative-client` | Knative Serving and Eventing resources |
| **Tekton** | `tekton-client` | Tekton Pipelines, Tasks, and Triggers |
| **Istio** | `istio-client` | Istio service mesh resources |
| **Volcano** | `volcano-client` | Volcano batch scheduling resources |
| **Chaos Mesh** | `chaosmesh-client` | Chaos engineering resources |
| **Open Cluster Management** | `open-cluster-management-client` | Multi-cluster management |
| **Vertical Pod Autoscaler** | `verticalpodautoscaler-client` | VPA resources |
| **Cert Manager** | `certmanager-client` | Certificate management resources |

## Using an Extension

Add the extension dependency to your project:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>tekton-client</artifactId>
    <version>${kubernetes-client.version}</version>
</dependency>
```

Then adapt the client:

```java
try (TektonClient tekton = client.adapt(TektonClient.class)) {
    // List Tekton pipelines
    PipelineList pipelines = tekton.v1().pipelines()
        .inNamespace("default")
        .list();

    // Create a TaskRun
    tekton.v1().taskRuns()
        .inNamespace("default")
        .resource(taskRun)
        .create();
}
```

## Knative Example

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>knative-client</artifactId>
    <version>${kubernetes-client.version}</version>
</dependency>
```

```java
try (KnativeClient knative = client.adapt(KnativeClient.class)) {
    knative.services()
        .inNamespace("default")
        .list();
}
```

## Istio Example

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>istio-client</artifactId>
    <version>${kubernetes-client.version}</version>
</dependency>
```

```java
try (IstioClient istio = client.adapt(IstioClient.class)) {
    istio.v1beta1().virtualServices()
        .inNamespace("default")
        .list();
}
```
