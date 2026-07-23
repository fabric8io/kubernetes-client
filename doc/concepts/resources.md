---
title: "Working with Resources"
description: "CRUD operations, builders, and the fluent DSL"
weight: 2
---

# Working with Resources

## The Fluent DSL

All operations follow a consistent chain: **client → API group → resource type → namespace → name → operation**.

```java
// Get a specific pod
Pod pod = client.pods().inNamespace("default").withName("my-pod").get();

// List deployments with labels
DeploymentList deps = client.apps().deployments()
    .inNamespace("default")
    .withLabel("app", "frontend")
    .list();

// Delete a service
client.services().inNamespace("default").withName("my-svc").delete();
```

## Building Resources

Every Kubernetes resource has a corresponding Builder class:

```java
Pod pod = new PodBuilder()
    .withNewMetadata()
        .withName("my-pod")
        .withNamespace("default")
        .addToLabels("app", "demo")
    .endMetadata()
    .withNewSpec()
        .addNewContainer()
            .withName("app")
            .withImage("myapp:1.0")
            .addNewPort()
                .withContainerPort(8080)
            .endPort()
            .withNewResources()
                .addToRequests("cpu", new Quantity("100m"))
                .addToRequests("memory", new Quantity("128Mi"))
            .endResources()
        .endContainer()
    .endSpec()
    .build();
```

## CRUD Operations

```java
// Create
Pod created = client.pods().inNamespace("ns").resource(pod).create();

// Read
Pod fetched = client.pods().inNamespace("ns").withName("my-pod").get();

// Update
Pod updated = client.pods().inNamespace("ns").resource(modifiedPod).update();

// Delete
client.pods().inNamespace("ns").withName("my-pod").delete();

// Create or Replace
client.pods().inNamespace("ns").resource(pod).createOrReplace();

// Server-Side Apply
client.pods().inNamespace("ns").resource(pod).serverSideApply();
```

## Listing and Filtering

```java
// List all in namespace
PodList pods = client.pods().inNamespace("default").list();

// Filter by label
PodList filtered = client.pods()
    .inNamespace("default")
    .withLabel("app", "web")
    .withLabel("env", "prod")
    .list();

// Filter by field
PodList running = client.pods()
    .inNamespace("default")
    .withField("status.phase", "Running")
    .list();
```

## Editing Resources In-Place

```java
Pod edited = client.pods().inNamespace("ns").withName("my-pod")
    .edit(p -> new PodBuilder(p)
        .editMetadata()
            .addToLabels("version", "v2")
        .endMetadata()
        .build());
```

## Handling Resource Versions

For updates that require optimistic locking:

```java
Pod existing = client.pods().inNamespace("ns").withName("my-pod").get();
// Modify the existing object (preserves resourceVersion)
existing.getMetadata().getLabels().put("updated", "true");
client.pods().inNamespace("ns").resource(existing).update();
```
