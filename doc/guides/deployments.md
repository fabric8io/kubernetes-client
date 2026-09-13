---
title: "Managing Deployments"
description: "Create, update, scale, and roll back Deployments"
weight: 1
---

# Managing Deployments

## Creating a Deployment

```java
Deployment deployment = new DeploymentBuilder()
    .withNewMetadata()
        .withName("nginx-deployment")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withReplicas(3)
        .withNewSelector()
            .addToMatchLabels("app", "nginx")
        .endSelector()
        .withNewTemplate()
            .withNewMetadata()
                .addToLabels("app", "nginx")
            .endMetadata()
            .withNewSpec()
                .addNewContainer()
                    .withName("nginx")
                    .withImage("nginx:1.25")
                    .addNewPort()
                        .withContainerPort(80)
                    .endPort()
                .endContainer()
            .endSpec()
        .endTemplate()
    .endSpec()
    .build();

client.apps().deployments().inNamespace("default").resource(deployment).create();
```

## Scaling

```java
// Scale to 5 replicas
client.apps().deployments()
    .inNamespace("default")
    .withName("nginx-deployment")
    .scale(5);
```

## Rolling Update

```java
// Update the image
client.apps().deployments()
    .inNamespace("default")
    .withName("nginx-deployment")
    .rolling()
    .updateImage("nginx:1.26");
```

## Rolling Restart

```java
client.apps().deployments()
    .inNamespace("default")
    .withName("nginx-deployment")
    .rolling()
    .restart();
```

## Pause a Rollout

```java
client.apps().deployments()
    .inNamespace("default")
    .withName("nginx-deployment")
    .rolling()
    .pause();
```

## Resume a Rollout

```java
client.apps().deployments()
    .inNamespace("default")
    .withName("nginx-deployment")
    .rolling()
    .resume();
```

## Rollback (Undo)

```java
client.apps().deployments()
    .inNamespace("default")
    .withName("nginx-deployment")
    .rolling()
    .undo();
```

## Checking Rollout Status

```java
Deployment dep = client.apps().deployments()
    .inNamespace("default")
    .withName("nginx-deployment")
    .get();

DeploymentStatus status = dep.getStatus();
System.out.println("Available replicas: " + status.getAvailableReplicas());
System.out.println("Ready replicas: " + status.getReadyReplicas());
```
