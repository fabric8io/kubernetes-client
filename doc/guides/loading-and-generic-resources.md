---
title: "Loading YAML and Generic Resources"
description: "Load resources from YAML/JSON and work with untyped resources"
weight: 16
---

# Loading YAML and Generic Resources

## Loading from YAML

```java
// Load a single resource
Pod pod = client.pods().load(new FileInputStream("pod.yaml")).item();

// Load and create
client.pods().inNamespace("default")
    .load(new FileInputStream("pod.yaml"))
    .create();

// Load a list of resources from a multi-document YAML
List<HasMetadata> resources = client.load(new FileInputStream("manifests.yaml")).items();
for (HasMetadata resource : resources) {
    System.out.printf("%s/%s%n", resource.getKind(), resource.getMetadata().getName());
}

// Load and create all resources at once
client.resourceList(resources).inNamespace("default").create();
```

## Working with Resources by String

```java
String yaml = """
    apiVersion: v1
    kind: ConfigMap
    metadata:
      name: my-config
    data:
      key: value
    """;

HasMetadata resource = client.resource(yaml).inNamespace("default").create();
```

## Generic (Untyped) Resources

When you don't have typed Java classes for a CRD, use `genericKubernetesResources`:

```java
// By API version and kind
var resources = client.genericKubernetesResources("stable.example.com/v1", "CronTab");

// List
GenericKubernetesResourceList list = resources.inNamespace("default").list();
for (GenericKubernetesResource item : list.getItems()) {
    System.out.println(item.getMetadata().getName());
    // Access arbitrary fields
    Map<String, Object> spec = (Map<String, Object>) item.getAdditionalProperties().get("spec");
}

// Create from YAML
GenericKubernetesResource cr = client.genericKubernetesResources("stable.example.com/v1", "CronTab")
    .load(new FileInputStream("crontab.yaml"))
    .item();
resources.inNamespace("default").resource(cr).create();
```

## Server API Discovery

```java
// Check if a resource type is supported
boolean hasCronTab = client.supports("stable.example.com/v1", "CronTab");

// List available API groups
List<APIGroup> groups = client.getApiGroups().getGroups();

// List resources in a group
APIResourceList apiResources = client.getApiResources("apps/v1");
for (APIResource r : apiResources.getResources()) {
    System.out.printf("%s (namespaced=%s)%n", r.getName(), r.getNamespaced());
}
```
