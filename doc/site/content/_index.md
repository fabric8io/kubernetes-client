---
title: "Fabric8 Kubernetes Client"
type: docs
---

# Fabric8 Kubernetes Client

A Java client library providing access to the full Kubernetes and OpenShift REST APIs via a fluent DSL.

## Quick Start

```java
KubernetesClient client = new KubernetesClientBuilder().build();

// List pods
PodList pods = client.pods().inNamespace("default").list();

// Create a deployment
client.apps().deployments().inNamespace("default").create(deployment);

// Watch for changes
client.pods().watch(new Watcher<Pod>() {
    @Override
    public void eventReceived(Action action, Pod pod) {
        System.out.println(action + ": " + pod.getMetadata().getName());
    }
    @Override
    public void onClose(WatcherException e) {}
});
```

## Documentation

Browse the sidebar to explore:

- **[Cheat Sheet]({{< relref "/docs/CHEATSHEET" >}})** - kubectl to Java equivalents
- **[FAQ]({{< relref "/docs/FAQ" >}})** - Frequently asked questions
- **[CRD Generator]({{< relref "/docs/CRD-generator" >}})** - Generate CRDs from Java
- **[Java Generator]({{< relref "/docs/java-generation-from-CRD" >}})** - Generate Java from CRDs
- **[Migration Guide v7]({{< relref "/docs/MIGRATION-v7" >}})** - Upgrade to v7

## Links

- [GitHub Repository](https://github.com/fabric8io/kubernetes-client)
- [Maven Central](https://search.maven.org/search?q=g:io.fabric8%20AND%20a:kubernetes-client)