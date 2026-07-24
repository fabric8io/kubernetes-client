---
title: "Nodes"
description: "List, inspect, and manage cluster nodes"
weight: 13
---

# Nodes

## Listing Nodes

```java
NodeList nodes = client.nodes().list();
for (Node node : nodes.getItems()) {
    System.out.printf("Node %s: %s%n",
        node.getMetadata().getName(),
        node.getStatus().getConditions().stream()
            .filter(c -> "Ready".equals(c.getType()))
            .findFirst()
            .map(NodeCondition::getStatus)
            .orElse("Unknown"));
}
```

## Getting Node Details

```java
Node node = client.nodes().withName("worker-1").get();

// Node capacity
Map<String, Quantity> capacity = node.getStatus().getCapacity();
System.out.println("CPU: " + capacity.get("cpu"));
System.out.println("Memory: " + capacity.get("memory"));

// Node labels
Map<String, String> labels = node.getMetadata().getLabels();
```

## Adding Labels to a Node

```java
client.nodes().withName("worker-1")
    .edit(n -> new NodeBuilder(n)
        .editMetadata()
            .addToLabels("disk", "ssd")
        .endMetadata()
        .build());
```

## Cordoning and Uncordoning

```java
// Cordon (mark unschedulable)
client.nodes().withName("worker-1")
    .edit(n -> new NodeBuilder(n)
        .editSpec()
            .withUnschedulable(true)
        .endSpec()
        .build());

// Uncordon
client.nodes().withName("worker-1")
    .edit(n -> new NodeBuilder(n)
        .editSpec()
            .withUnschedulable(false)
        .endSpec()
        .build());
```

## Tainting a Node

```java
client.nodes().withName("worker-1")
    .edit(n -> new NodeBuilder(n)
        .editSpec()
            .addNewTaint()
                .withKey("dedicated")
                .withValue("gpu")
                .withEffect("NoSchedule")
            .endTaint()
        .endSpec()
        .build());
```
