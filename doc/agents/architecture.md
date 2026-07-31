# Architecture

## Fluent DSL and Builder Pattern

The primary API design pattern is a fluent DSL:

```java
KubernetesClient client = new KubernetesClientBuilder().build();
client.pods().inNamespace("default").withName("mypod").get();
client.apps().deployments().inNamespace("ns").list();
```

All Kubernetes resources have builders:

```java
Pod pod = new PodBuilder()
    .withNewMetadata()
        .withName("mypod")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .addNewContainer()
            .withName("nginx")
            .withImage("nginx:latest")
        .endContainer()
    .endSpec()
    .build();
```

## Adapter Pattern

Use adapters to convert between client types:

```java
OpenShiftClient osClient = kubernetesClient.adapt(OpenShiftClient.class);
```

## API Group DSL

The DSL is organized by Kubernetes API group:

- `client.pods()` and `client.services()` for core v1.
- `client.apps().deployments()` for `apps/v1`.
- `client.batch().jobs()` for `batch/v1`.
- `client.network().networkPolicies()` for `networking.k8s.io/v1`.

## Pluggable HTTP Clients

HTTP clients are pluggable through SPI.

- Default: Vert.x.
- Alternatives: OkHttp, Jetty, and JDK HttpClient.
