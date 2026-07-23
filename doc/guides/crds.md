---
title: "Managing CRDs"
description: "Create, list, and delete CustomResourceDefinition objects"
weight: 20
---

# Managing CRDs

This guide covers managing **CustomResourceDefinition objects themselves** (the schema definitions). For working with instances of custom resources, see [Custom Resources]({{< relref "/docs/advanced/custom-resources" >}}).

## Listing CRDs

```java
CustomResourceDefinitionList crdList = client.apiextensions().v1()
    .customResourceDefinitions()
    .list();

for (CustomResourceDefinition crd : crdList.getItems()) {
    System.out.printf("CRD %s (%s)%n",
        crd.getMetadata().getName(),
        crd.getSpec().getGroup());
}
```

## Creating a CRD

```java
CustomResourceDefinition crd = new CustomResourceDefinitionBuilder()
    .withNewMetadata()
        .withName("crontabs.stable.example.com")
    .endMetadata()
    .withNewSpec()
        .withGroup("stable.example.com")
        .withNewNames()
            .withKind("CronTab")
            .withPlural("crontabs")
            .withSingular("crontab")
            .withShortNames("ct")
        .endNames()
        .withScope("Namespaced")
        .addNewVersion()
            .withName("v1")
            .withServed(true)
            .withStorage(true)
            .withNewSchema()
                .withNewOpenAPIV3Schema()
                    .withType("object")
                    .addToProperties("spec", new JSONSchemaPropsBuilder()
                        .withType("object")
                        .addToProperties("cronSpec", new JSONSchemaPropsBuilder()
                            .withType("string").build())
                        .addToProperties("image", new JSONSchemaPropsBuilder()
                            .withType("string").build())
                        .addToProperties("replicas", new JSONSchemaPropsBuilder()
                            .withType("integer").build())
                        .build())
                .endOpenAPIV3Schema()
            .endSchema()
        .endVersion()
    .endSpec()
    .build();

client.apiextensions().v1().customResourceDefinitions().resource(crd).create();
```

## Loading a CRD from YAML

```java
CustomResourceDefinition crd = client.apiextensions().v1()
    .customResourceDefinitions()
    .load(new FileInputStream("crontab-crd.yaml"))
    .item();

client.apiextensions().v1().customResourceDefinitions().resource(crd).create();
```

## Deleting a CRD

```java
client.apiextensions().v1()
    .customResourceDefinitions()
    .withName("crontabs.stable.example.com")
    .delete();
```

## Checking If a CRD Exists

```java
boolean exists = client.supports("stable.example.com/v1", "CronTab");
```