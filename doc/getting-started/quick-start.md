---
title: "Quick Start"
description: "Your first program with Fabric8 Kubernetes Client"
weight: 2
---

# Quick Start

## Creating a Client

The simplest way to create a client that connects to your current kubeconfig context:

```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    // Use the client
}
```

The client auto-discovers configuration from:
1. `~/.kube/config` (kubeconfig file)
2. In-cluster service account (when running inside a pod)
3. Environment variables (`KUBERNETES_MASTER`, `KUBERNETES_NAMESPACE`, etc.)

## Listing Pods

```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    PodList pods = client.pods().inNamespace("default").list();
    for (Pod pod : pods.getItems()) {
        System.out.println(pod.getMetadata().getName());
    }
}
```

## Creating a Resource

```java
Pod pod = new PodBuilder()
    .withNewMetadata()
        .withName("my-pod")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .addNewContainer()
            .withName("nginx")
            .withImage("nginx:latest")
            .addNewPort()
                .withContainerPort(80)
            .endPort()
        .endContainer()
    .endSpec()
    .build();

client.pods().inNamespace("default").resource(pod).create();
```

## Watching Resources

```java
client.pods().inNamespace("default").watch(new Watcher<Pod>() {
    @Override
    public void eventReceived(Action action, Pod pod) {
        System.out.println(action + ": " + pod.getMetadata().getName());
    }

    @Override
    public void onClose(WatcherException e) {
        if (e != null) {
            e.printStackTrace();
        }
    }
});
```

## Next Steps

- See the [Cheat Sheet]({{< relref "/docs/CHEATSHEET" >}}) for kubectl-to-Java equivalents
- Learn about [Client Configuration]({{< relref "/docs/getting-started/configuration" >}})
- Explore [Working with Resources]({{< relref "/docs/concepts/resources" >}})
