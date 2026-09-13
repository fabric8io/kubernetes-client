---
title: "Dry Run and Server-Side Apply"
description: "Validate changes without persisting and manage field ownership"
weight: 21
---

# Dry Run and Server-Side Apply

## Dry Run

Dry run sends a request to the API server for validation without persisting the result:

```java
// Dry-run a create
Pod pod = new PodBuilder()
    .withNewMetadata().withName("test-pod").endMetadata()
    .withNewSpec()
        .addNewContainer()
            .withName("nginx")
            .withImage("nginx:latest")
        .endContainer()
    .endSpec()
    .build();

Pod result = client.pods()
    .inNamespace("default")
    .resource(pod)
    .dryRun()
    .create();

// result contains what the server would return, but nothing was persisted
System.out.println("Dry-run UID: " + result.getMetadata().getUid());
```

## Server-Side Apply

Server-Side Apply lets the API server manage field ownership. Multiple controllers can own different fields of the same resource without conflicts:

```java
// Apply with a field manager
Pod pod = new PodBuilder()
    .withNewMetadata()
        .withName("my-pod")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .addNewContainer()
            .withName("app")
            .withImage("myapp:2.0")
        .endContainer()
    .endSpec()
    .build();

Pod applied = client.pods()
    .inNamespace("default")
    .resource(pod)
    .serverSideApply();
```

### Force Conflicts

If another field manager owns a field you're trying to change:

```java
Pod applied = client.pods()
    .inNamespace("default")
    .resource(pod)
    .forceConflicts()
    .serverSideApply();
```

## Waiting for Conditions

Wait for a resource to reach a specific state:

```java
// Wait until ready (up to 2 minutes)
client.apps().deployments()
    .inNamespace("default")
    .withName("my-app")
    .waitUntilReady(2, TimeUnit.MINUTES);

// Wait for a custom condition
Pod completed = client.pods()
    .inNamespace("default")
    .withName("batch-pod")
    .waitUntilCondition(
        p -> p.getStatus() != null
            && "Succeeded".equals(p.getStatus().getPhase()),
        10, TimeUnit.MINUTES);
```