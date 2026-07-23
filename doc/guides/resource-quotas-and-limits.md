---
title: "Resource Quotas and Limit Ranges"
description: "Enforce resource constraints on namespaces"
weight: 14
---

# Resource Quotas and Limit Ranges

## Resource Quotas

### Creating a ResourceQuota

```java
ResourceQuota quota = new ResourceQuotaBuilder()
    .withNewMetadata()
        .withName("compute-quota")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .addToHard("requests.cpu", new Quantity("4"))
        .addToHard("requests.memory", new Quantity("8Gi"))
        .addToHard("limits.cpu", new Quantity("8"))
        .addToHard("limits.memory", new Quantity("16Gi"))
        .addToHard("pods", new Quantity("20"))
    .endSpec()
    .build();

client.resourceQuotas().inNamespace("default").resource(quota).create();
```

### Checking Quota Usage

```java
ResourceQuota rq = client.resourceQuotas()
    .inNamespace("default")
    .withName("compute-quota")
    .get();

System.out.println("CPU used: " + rq.getStatus().getUsed().get("requests.cpu"));
System.out.println("CPU hard: " + rq.getStatus().getHard().get("requests.cpu"));
```

## Limit Ranges

### Creating a LimitRange

```java
LimitRange limitRange = new LimitRangeBuilder()
    .withNewMetadata()
        .withName("default-limits")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .addNewLimit()
            .withType("Container")
            .addToDefault("cpu", new Quantity("500m"))
            .addToDefault("memory", new Quantity("256Mi"))
            .addToDefaultRequest("cpu", new Quantity("100m"))
            .addToDefaultRequest("memory", new Quantity("128Mi"))
            .addToMax("cpu", new Quantity("2"))
            .addToMax("memory", new Quantity("1Gi"))
        .endLimit()
    .endSpec()
    .build();

client.limitRanges().inNamespace("default").resource(limitRange).create();
```
