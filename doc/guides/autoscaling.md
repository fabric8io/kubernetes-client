---
title: "Autoscaling"
description: "HorizontalPodAutoscaler and Pod Disruption Budgets"
weight: 10
---

# Autoscaling

## HorizontalPodAutoscaler (HPA)

### Creating an HPA (autoscaling/v2)

```java
HorizontalPodAutoscaler hpa = new HorizontalPodAutoscalerBuilder()
    .withNewMetadata()
        .withName("web-hpa")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withNewScaleTargetRef()
            .withApiVersion("apps/v1")
            .withKind("Deployment")
            .withName("web")
        .endScaleTargetRef()
        .withMinReplicas(2)
        .withMaxReplicas(10)
        .addNewMetric()
            .withType("Resource")
            .withNewResource()
                .withName("cpu")
                .withNewTarget()
                    .withType("Utilization")
                    .withAverageUtilization(70)
                .endTarget()
            .endResource()
        .endMetric()
    .endSpec()
    .build();

client.autoscaling().v2().horizontalPodAutoscalers()
    .inNamespace("default")
    .resource(hpa)
    .create();
```

### Listing HPAs

```java
HorizontalPodAutoscalerList hpaList = client.autoscaling().v2()
    .horizontalPodAutoscalers()
    .inNamespace("default")
    .list();

for (HorizontalPodAutoscaler h : hpaList.getItems()) {
    System.out.printf("HPA %s: min=%d, max=%d, current=%d%n",
        h.getMetadata().getName(),
        h.getSpec().getMinReplicas(),
        h.getSpec().getMaxReplicas(),
        h.getStatus().getCurrentReplicas());
}
```

## Pod Disruption Budgets (PDB)

```java
PodDisruptionBudget pdb = new PodDisruptionBudgetBuilder()
    .withNewMetadata()
        .withName("web-pdb")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withMinAvailable(new IntOrString("50%"))
        .withNewSelector()
            .addToMatchLabels("app", "web")
        .endSelector()
    .endSpec()
    .build();

client.policy().v1().podDisruptionBudget()
    .inNamespace("default")
    .resource(pdb)
    .create();
```

## Metrics (top)

```java
// Node metrics
NodeMetricsList nodeMetrics = client.top().nodes().metrics();
for (NodeMetrics nm : nodeMetrics.getItems()) {
    System.out.printf("Node %s: cpu=%s, memory=%s%n",
        nm.getMetadata().getName(),
        nm.getUsage().get("cpu"),
        nm.getUsage().get("memory"));
}

// Pod metrics
PodMetricsList podMetrics = client.top().pods().metrics("default");
for (PodMetrics pm : podMetrics.getItems()) {
    System.out.printf("Pod %s: %s%n",
        pm.getMetadata().getName(), pm.getContainers());
}
```
