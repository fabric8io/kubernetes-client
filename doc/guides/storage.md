---
title: "Storage"
description: "PersistentVolumes, PersistentVolumeClaims, and StorageClasses"
weight: 8
---

# Storage

## PersistentVolumeClaims

### Creating a PVC

```java
PersistentVolumeClaim pvc = new PersistentVolumeClaimBuilder()
    .withNewMetadata()
        .withName("data-pvc")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withAccessModes("ReadWriteOnce")
        .withNewResources()
            .addToRequests("storage", new Quantity("10Gi"))
        .endResources()
        .withStorageClassName("standard")
    .endSpec()
    .build();

client.persistentVolumeClaims().inNamespace("default").resource(pvc).create();
```

### Listing PVCs

```java
PersistentVolumeClaimList pvcs = client.persistentVolumeClaims()
    .inNamespace("default")
    .list();

for (PersistentVolumeClaim p : pvcs.getItems()) {
    System.out.printf("PVC %s: %s (%s)%n",
        p.getMetadata().getName(),
        p.getStatus().getPhase(),
        p.getSpec().getResources().getRequests().get("storage"));
}
```

## PersistentVolumes

```java
PersistentVolume pv = new PersistentVolumeBuilder()
    .withNewMetadata()
        .withName("nfs-pv")
    .endMetadata()
    .withNewSpec()
        .withCapacity(Map.of("storage", new Quantity("100Gi")))
        .withAccessModes("ReadWriteMany")
        .withPersistentVolumeReclaimPolicy("Retain")
        .withNewNfs()
            .withServer("nfs.example.com")
            .withPath("/exports/data")
        .endNfs()
    .endSpec()
    .build();

client.persistentVolumes().resource(pv).create();
```

## StorageClasses

### Listing StorageClasses

```java
StorageClassList scList = client.storage().v1().storageClasses().list();
for (StorageClass sc : scList.getItems()) {
    System.out.printf("StorageClass %s: provisioner=%s%n",
        sc.getMetadata().getName(),
        sc.getProvisioner());
}
```

### Creating a StorageClass

```java
StorageClass sc = new StorageClassBuilder()
    .withNewMetadata()
        .withName("fast-ssd")
    .endMetadata()
    .withProvisioner("kubernetes.io/gce-pd")
    .withParameters(Map.of("type", "pd-ssd"))
    .withReclaimPolicy("Delete")
    .withVolumeBindingMode("WaitForFirstConsumer")
    .build();

client.storage().v1().storageClasses().resource(sc).create();
```
