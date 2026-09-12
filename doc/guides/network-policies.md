---
title: "Network Policies"
description: "Control pod-to-pod traffic with NetworkPolicies"
weight: 11
---

# Network Policies

## Creating a NetworkPolicy

Allow ingress traffic only from pods with `app=frontend` on port 8080:

```java
NetworkPolicy policy = new NetworkPolicyBuilder()
    .withNewMetadata()
        .withName("allow-frontend")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withNewPodSelector()
            .addToMatchLabels("app", "backend")
        .endPodSelector()
        .withPolicyTypes("Ingress")
        .addNewIngress()
            .addNewFrom()
                .withNewPodSelector()
                    .addToMatchLabels("app", "frontend")
                .endPodSelector()
            .endFrom()
            .addNewPort()
                .withPort(new IntOrString(8080))
                .withProtocol("TCP")
            .endPort()
        .endIngress()
    .endSpec()
    .build();

client.network().v1().networkPolicies()
    .inNamespace("default")
    .resource(policy)
    .create();
```

## Deny All Ingress

```java
NetworkPolicy denyAll = new NetworkPolicyBuilder()
    .withNewMetadata()
        .withName("deny-all-ingress")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withNewPodSelector() // empty selector = all pods
        .endPodSelector()
        .withPolicyTypes("Ingress")
        // no ingress rules = deny all
    .endSpec()
    .build();

client.network().v1().networkPolicies()
    .inNamespace("default")
    .resource(denyAll)
    .create();
```

## Listing NetworkPolicies

```java
NetworkPolicyList policies = client.network().v1()
    .networkPolicies()
    .inNamespace("default")
    .list();

for (NetworkPolicy np : policies.getItems()) {
    System.out.println("NetworkPolicy: " + np.getMetadata().getName());
}
```
