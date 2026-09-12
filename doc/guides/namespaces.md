---
title: "Namespaces"
description: "Create, list, and manage Kubernetes Namespaces"
weight: 5
---

# Namespaces

## Listing Namespaces

```java
NamespaceList namespaces = client.namespaces().list();
for (Namespace ns : namespaces.getItems()) {
    System.out.println(ns.getMetadata().getName());
}
```

## Creating a Namespace

```java
Namespace ns = new NamespaceBuilder()
    .withNewMetadata()
        .withName("my-namespace")
        .addToLabels("env", "dev")
    .endMetadata()
    .build();

client.namespaces().resource(ns).create();
```

## Deleting a Namespace

```java
client.namespaces().withName("my-namespace").delete();
```

## Scoping Operations to a Namespace

```java
// All subsequent operations scoped to this namespace
PodList pods = client.pods().inNamespace("my-namespace").list();

// Operate across all namespaces
PodList allPods = client.pods().inAnyNamespace().list();
```