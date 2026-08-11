---
title: "Scheduling"
description: "PriorityClasses, RuntimeClasses, and scheduling configuration"
weight: 22
---

# Scheduling

## PriorityClasses

Control pod scheduling priority — higher priority pods can preempt lower priority ones:

```java
PriorityClass highPriority = new PriorityClassBuilder()
    .withNewMetadata()
        .withName("high-priority")
    .endMetadata()
    .withValue(1000000)
    .withGlobalDefault(false)
    .withDescription("High priority for production workloads")
    .withPreemptionPolicy("PreemptLowerPriority")
    .build();

client.scheduling().v1().priorityClasses().resource(highPriority).create();
```

### Using a PriorityClass in a Pod

```java
Pod pod = new PodBuilder()
    .withNewMetadata().withName("important-pod").endMetadata()
    .withNewSpec()
        .withPriorityClassName("high-priority")
        .addNewContainer()
            .withName("app")
            .withImage("myapp:latest")
        .endContainer()
    .endSpec()
    .build();
```

### Listing PriorityClasses

```java
PriorityClassList pcList = client.scheduling().v1().priorityClasses().list();
for (PriorityClass pc : pcList.getItems()) {
    System.out.printf("PriorityClass %s: value=%d%n",
        pc.getMetadata().getName(), pc.getValue());
}
```

## RuntimeClasses

Define different container runtime configurations (e.g., gVisor, Kata Containers):

```java
RuntimeClass rc = new RuntimeClassBuilder()
    .withNewMetadata()
        .withName("gvisor")
    .endMetadata()
    .withHandler("runsc")
    .build();

client.runtimeClasses().resource(rc).create();
```

### Using a RuntimeClass in a Pod

```java
Pod pod = new PodBuilder()
    .withNewMetadata().withName("sandboxed-pod").endMetadata()
    .withNewSpec()
        .withRuntimeClassName("gvisor")
        .addNewContainer()
            .withName("app")
            .withImage("myapp:latest")
        .endContainer()
    .endSpec()
    .build();
```

### Listing RuntimeClasses

```java
RuntimeClassList rcList = client.runtimeClasses().list();
for (RuntimeClass r : rcList.getItems()) {
    System.out.printf("RuntimeClass %s: handler=%s%n",
        r.getMetadata().getName(), r.getHandler());
}
```