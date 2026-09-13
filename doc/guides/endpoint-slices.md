---
title: "Endpoints and EndpointSlices"
description: "Manage service endpoints and discovery"
weight: 23
---

# Endpoints and EndpointSlices

## Endpoints (core/v1)

```java
// List endpoints for a service
Endpoints ep = client.endpoints()
    .inNamespace("default")
    .withName("my-service")
    .get();

for (EndpointSubset subset : ep.getSubsets()) {
    for (EndpointAddress addr : subset.getAddresses()) {
        for (EndpointPort port : subset.getPorts()) {
            System.out.printf("  %s:%d%n", addr.getIp(), port.getPort());
        }
    }
}
```

### Creating Custom Endpoints

```java
Endpoints endpoints = new EndpointsBuilder()
    .withNewMetadata()
        .withName("external-db")
        .withNamespace("default")
    .endMetadata()
    .addNewSubset()
        .addNewAddress()
            .withIp("10.0.0.100")
        .endAddress()
        .addNewPort()
            .withPort(5432)
            .withProtocol("TCP")
        .endPort()
    .endSubset()
    .build();

client.endpoints().inNamespace("default").resource(endpoints).create();
```

## EndpointSlices (discovery.k8s.io/v1)

EndpointSlices are the scalable successor to Endpoints, splitting large endpoint sets across multiple objects:

```java
EndpointSliceList slices = client.discovery().v1()
    .endpointSlices()
    .inNamespace("default")
    .withLabel("kubernetes.io/service-name", "my-service")
    .list();

for (EndpointSlice slice : slices.getItems()) {
    System.out.println("Slice: " + slice.getMetadata().getName());
    for (Endpoint endpoint : slice.getEndpoints()) {
        System.out.printf("  addresses=%s, ready=%s%n",
            endpoint.getAddresses(),
            endpoint.getConditions().getReady());
    }
}
```