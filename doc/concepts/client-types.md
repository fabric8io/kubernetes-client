---
title: "Client Types"
description: "KubernetesClient, OpenShiftClient, and the Adapter pattern"
weight: 1
---

# Client Types

## KubernetesClient

The primary entry point for all Kubernetes operations. Provides access to all standard Kubernetes API groups:

```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    client.pods();                         // Core v1
    client.services();                     // Core v1
    client.apps().deployments();           // apps/v1
    client.batch().v1().jobs();            // batch/v1
    client.network().networkPolicies();    // networking.k8s.io/v1
    client.storage().storageClasses();     // storage.k8s.io/v1
    client.rbac().roles();                 // rbac.authorization.k8s.io/v1
}
```

## OpenShiftClient

Extends `KubernetesClient` with OpenShift-specific resources. Use the **Adapter pattern** to convert:

```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    if (client.isAdaptable(OpenShiftClient.class)) {
        OpenShiftClient osClient = client.adapt(OpenShiftClient.class);
        osClient.routes().list();
        osClient.builds().list();
        osClient.deploymentConfigs().list();
    }
}
```

## NamespacedKubernetesClient

When you know you'll always work within a specific namespace:

```java
NamespacedKubernetesClient client = new KubernetesClientBuilder()
    .withConfig(new ConfigBuilder().withNamespace("my-ns").build())
    .build();
```

## Client Lifecycle

The client implements `Closeable`. Always close it when done to release HTTP connections:

```java
// Try-with-resources (recommended)
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    // operations
}

// Or close manually
KubernetesClient client = new KubernetesClientBuilder().build();
try {
    // operations
} finally {
    client.close();
}
```
