---
title: "Leases and Coordination"
description: "Leases for leader election, node heartbeats, and distributed coordination"
weight: 24
---

# Leases and Coordination

Leases (coordination.k8s.io/v1) are lightweight resources used for leader election, node heartbeats, and distributed locking.

## Creating a Lease

```java
Lease lease = new LeaseBuilder()
    .withNewMetadata()
        .withName("my-lock")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withHolderIdentity("instance-1")
        .withLeaseDurationSeconds(15)
        .withAcquireTime(MicroTime.now())
        .withRenewTime(MicroTime.now())
        .withLeaseTransitions(0)
    .endSpec()
    .build();

client.leases().inNamespace("default").resource(lease).create();
```

## Listing Leases

```java
LeaseList leases = client.leases().inNamespace("kube-system").list();
for (Lease l : leases.getItems()) {
    System.out.printf("Lease %s: holder=%s, duration=%ds%n",
        l.getMetadata().getName(),
        l.getSpec().getHolderIdentity(),
        l.getSpec().getLeaseDurationSeconds());
}
```

## Leader Election Using Leases

For building HA controllers, see [Building Controllers]({{< relref "/docs/advanced/controllers" >}}) which covers the `LeaderElector` API built on top of Leases.