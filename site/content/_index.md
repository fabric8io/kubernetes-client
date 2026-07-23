---
title: "Fabric8 Kubernetes Client"
type: docs
---

# Fabric8 Kubernetes Client

A Java client library providing access to the full Kubernetes and OpenShift REST APIs via a fluent DSL.

## Quick Start

```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    // List pods
    PodList pods = client.pods().inNamespace("default").list();

    // Create a deployment
    client.apps().deployments().inNamespace("default").resource(deployment).create();

    // Watch for changes
    client.pods().watch(new Watcher<Pod>() {
        @Override
        public void eventReceived(Action action, Pod pod) {
            System.out.println(action + ": " + pod.getMetadata().getName());
        }
        @Override
        public void onClose(WatcherException e) {}
    });
}
```

## Documentation

{{% columns %}}

- ### Getting Started
  - [Installation]({{< relref "/docs/getting-started/installation" >}})
  - [Quick Start]({{< relref "/docs/getting-started/quick-start" >}})
  - [Client Configuration]({{< relref "/docs/getting-started/configuration" >}})

- ### Concepts
  - [Client Types]({{< relref "/docs/concepts/client-types" >}})
  - [Working with Resources]({{< relref "/docs/concepts/resources" >}})
  - [Watching and Informers]({{< relref "/docs/concepts/watching" >}})
  - [HTTP Client Backends]({{< relref "/docs/concepts/http-clients" >}})

- ### Guides
  - [Deployments]({{< relref "/docs/guides/deployments" >}})
  - [Services and Ingress]({{< relref "/docs/guides/services-and-ingress" >}})
  - [Jobs and CronJobs]({{< relref "/docs/guides/jobs-and-cronjobs" >}})
  - [Storage]({{< relref "/docs/guides/storage" >}})
  - [RBAC]({{< relref "/docs/guides/rbac" >}})
  - [...and more]({{< relref "/docs/guides" >}})

{{% /columns %}}

{{% columns %}}

- ### Code Generation
  - [CRD Generator]({{< relref "/docs/CRD-generator" >}})
  - [Java from CRD]({{< relref "/docs/java-generation-from-CRD" >}})

- ### Advanced
  - [Custom Resources]({{< relref "/docs/advanced/custom-resources" >}})
  - [Building Controllers]({{< relref "/docs/advanced/controllers" >}})
  - [Extensions]({{< relref "/docs/advanced/extensions" >}})

- ### Reference
  - [Cheat Sheet]({{< relref "/docs/CHEATSHEET" >}})
  - [FAQ]({{< relref "/docs/FAQ" >}})
  - [Migration Guide v7]({{< relref "/docs/MIGRATION-v7" >}})

{{% /columns %}}

## Links

- [GitHub Repository](https://github.com/fabric8io/kubernetes-client)
- [Maven Central](https://search.maven.org/search?q=g:io.fabric8%20AND%20a:kubernetes-client)
