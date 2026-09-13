---
title: "Pod Operations"
description: "Exec, attach, logs, port-forward, file transfer, eviction, and ephemeral containers"
weight: 4
---

# Pod Operations

## Reading Logs

```java
// Get current logs
String logs = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .getLog();

// Stream logs
try (LogWatch logWatch = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .watchLog(System.out)) {
    Thread.sleep(10_000); // watch for 10 seconds
}

// Logs from a specific container
String containerLogs = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .inContainer("sidecar")
    .getLog();

// Previous container logs
String prevLogs = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .terminated()
    .getLog();
```

## Executing Commands

```java
ExecWatch exec = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .redirectingInput()
    .redirectingOutput()
    .redirectingError()
    .exec("sh", "-c", "ls -la /app");
```

## File Upload and Download

```java
// Upload a file to a pod
client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .file("/tmp/data.txt")
    .upload(Paths.get("/local/data.txt"));

// Download a file from a pod
client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .file("/app/config.yaml")
    .copy(Paths.get("/local/config.yaml"));
```

## Port Forwarding

```java
try (LocalPortForward portForward = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .portForward(8080, 8080)) {

    System.out.println("Forwarding on port: " + portForward.getLocalPort());
    // Access http://localhost:8080
    Thread.sleep(60_000);
}
```

## Attaching to a Running Process

Attach to the main process of a container (stdin/stdout/stderr):

```java
ExecWatch attach = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .redirectingInput()
    .redirectingOutput()
    .redirectingError()
    .attach();
```

## Evicting a Pod

Evict a pod while respecting PodDisruptionBudgets:

```java
// Simple eviction
client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .evict();

// Eviction with custom options
Eviction eviction = new EvictionBuilder()
    .withNewMetadata()
        .withName("my-pod")
        .withNamespace("default")
    .endMetadata()
    .withNewDeleteOptions()
        .withGracePeriodSeconds(30L)
    .endDeleteOptions()
    .build();

client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .evict(eviction);
```

## Ephemeral Containers

Add debug containers to a running pod without restarting it:

```java
Pod pod = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .ephemeralContainers()
    .edit(p -> new PodBuilder(p)
        .editSpec()
            .addNewEphemeralContainer()
                .withName("debugger")
                .withImage("busybox")
                .withCommand("sh")
                .withStdin(true)
                .withTty(true)
            .endEphemeralContainer()
        .endSpec()
        .build());

// Exec into the ephemeral container
client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .inContainer("debugger")
    .redirectingInput()
    .redirectingOutput()
    .exec("sh");
```

## Waiting for a Pod

```java
// Wait until ready
client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .waitUntilReady(2, TimeUnit.MINUTES);

// Wait for a custom condition
client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .waitUntilCondition(
        pod -> pod.getStatus() != null
            && "Succeeded".equals(pod.getStatus().getPhase()),
        5, TimeUnit.MINUTES);
```
