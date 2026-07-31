---
title: "Mock Server Testing"
description: "Unit test Kubernetes code with the built-in mock server"
weight: 1
---

# Mock Server Testing

The `kubernetes-server-mock` module provides a mock Kubernetes API server for unit tests. It supports two modes: **CRUD mode** (automatic resource storage) and **Expectations mode** (precise HTTP control).

## Setup

Add the test dependency:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-server-mock</artifactId>
    <version>${kubernetes-client.version}</version>
    <scope>test</scope>
</dependency>
```

## CRUD Mode (Recommended)

Automatically stores and retrieves resources — ideal for most tests:

```java
@EnableKubernetesMockClient(https = false, crud = true)
class DeploymentTest {

    KubernetesMockServer server;
    KubernetesClient client;

    @Test
    void shouldCreateAndRetrieveDeployment() {
        Deployment dep = new DeploymentBuilder()
            .withNewMetadata().withName("my-app").endMetadata()
            .withNewSpec().withReplicas(3).endSpec()
            .build();

        client.apps().deployments().inNamespace("default").resource(dep).create();

        Deployment result = client.apps().deployments()
            .inNamespace("default")
            .withName("my-app")
            .get();

        assertThat(result).isNotNull();
        assertThat(result.getSpec().getReplicas()).isEqualTo(3);
    }
}
```

## Expectations Mode

For precise control over HTTP responses:

```java
@EnableKubernetesMockClient(https = false)
class PodTest {

    KubernetesMockServer server;
    KubernetesClient client;

    @Test
    void shouldHandleNotFound() {
        server.expect()
            .get()
            .withPath("/api/v1/namespaces/default/pods/missing")
            .andReturn(404, new StatusBuilder()
                .withCode(404)
                .withMessage("not found")
                .build())
            .once();

        Pod pod = client.pods().inNamespace("default").withName("missing").get();
        assertThat(pod).isNull();
    }
}
```

## JUnit 5 Integration

For full JUnit 5 lifecycle integration:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-junit-jupiter</artifactId>
    <version>${kubernetes-client.version}</version>
    <scope>test</scope>
</dependency>
```
