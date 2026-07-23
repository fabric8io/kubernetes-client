---
title: "Server-Side Content Negotiation"
description: "Use PartialObjectMetadata and Table representations for efficient API calls"
weight: 15
---

# Server-Side Content Negotiation

For full details, see the [reference page]({{< relref "/docs/server-side-content-negotiation" >}}).

Kubernetes supports server-side content negotiation via the HTTP `Accept` header. The Fabric8 client exposes two representations:

## PartialObjectMetadata

Retrieve only metadata (name, labels, annotations, etc.) without the full spec. Useful for listing many resources efficiently:

```java
PartialObjectMetadataList metadataList = client.pods()
    .inNamespace("default")
    .withLabelSelector(new LabelSelectorBuilder()
        .addToMatchLabels("app", "web")
        .build())
    .listAsPartialObjectMetadata();

for (PartialObjectMetadata item : metadataList.getItems()) {
    System.out.printf("Pod %s (uid=%s)%n",
        item.getMetadata().getName(),
        item.getMetadata().getUid());
}
```

## Table Representation

Retrieve resources in the same tabular format that `kubectl get` displays:

```java
Table table = client.pods()
    .inNamespace("default")
    .listAsTable();

// Print column headers
table.getColumnDefinitions().forEach(col ->
    System.out.printf("%-20s", col.getName()));
System.out.println();

// Print rows
for (TableRow row : table.getRows()) {
    row.getCells().forEach(cell ->
        System.out.printf("%-20s", cell));
    System.out.println();
}
```

## When to Use

- **PartialObjectMetadata** — When you only need names, labels, or annotations for a large number of resources. Reduces payload size and API server load.
- **Table** — When building CLI-like output or need the same human-readable columns as `kubectl`.
