---
title: "Services and Ingress"
description: "Expose applications with Services and Ingress resources"
weight: 2
---

# Services and Ingress

## Creating a Service

```java
Service service = new ServiceBuilder()
    .withNewMetadata()
        .withName("my-service")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .addToSelector("app", "my-app")
        .addNewPort()
            .withPort(80)
            .withTargetPort(new IntOrString(8080))
            .withProtocol("TCP")
        .endPort()
        .withType("ClusterIP")
    .endSpec()
    .build();

client.services().inNamespace("default").resource(service).create();
```

## Service Types

```java
// NodePort
new ServiceBuilder()
    .withNewSpec()
        .withType("NodePort")
        .addNewPort()
            .withPort(80)
            .withTargetPort(new IntOrString(8080))
            .withNodePort(30080)
        .endPort()
    .endSpec()
    .build();

// LoadBalancer
new ServiceBuilder()
    .withNewSpec()
        .withType("LoadBalancer")
        .addNewPort()
            .withPort(443)
            .withTargetPort(new IntOrString(8443))
        .endPort()
    .endSpec()
    .build();
```

## Creating an Ingress

```java
Ingress ingress = new IngressBuilder()
    .withNewMetadata()
        .withName("my-ingress")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .addNewRule()
            .withHost("myapp.example.com")
            .withNewHttp()
                .addNewPath()
                    .withPath("/")
                    .withPathType("Prefix")
                    .withNewBackend()
                        .withNewService()
                            .withName("my-service")
                            .withNewPort()
                                .withNumber(80)
                            .endPort()
                        .endService()
                    .endBackend()
                .endPath()
            .endHttp()
        .endRule()
    .endSpec()
    .build();

client.network().v1().ingresses().inNamespace("default").resource(ingress).create();
```
