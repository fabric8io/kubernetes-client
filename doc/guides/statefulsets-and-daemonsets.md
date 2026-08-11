---
title: "StatefulSets and DaemonSets"
description: "Manage stateful applications and node-level daemons"
weight: 7
---

# StatefulSets and DaemonSets

## StatefulSets

### Creating a StatefulSet

```java
StatefulSet ss = new StatefulSetBuilder()
    .withNewMetadata()
        .withName("web")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withReplicas(3)
        .withServiceName("web-headless")
        .withNewSelector()
            .addToMatchLabels("app", "web")
        .endSelector()
        .withNewTemplate()
            .withNewMetadata()
                .addToLabels("app", "web")
            .endMetadata()
            .withNewSpec()
                .addNewContainer()
                    .withName("nginx")
                    .withImage("nginx:1.25")
                    .addNewPort()
                        .withContainerPort(80)
                    .endPort()
                .endContainer()
            .endSpec()
        .endTemplate()
    .endSpec()
    .build();

client.apps().statefulSets().inNamespace("default").resource(ss).create();
```

### Scaling a StatefulSet

```java
client.apps().statefulSets()
    .inNamespace("default")
    .withName("web")
    .scale(5);
```

### Rolling Restart

```java
client.apps().statefulSets()
    .inNamespace("default")
    .withName("web")
    .rolling()
    .restart();
```

## DaemonSets

### Creating a DaemonSet

```java
DaemonSet ds = new DaemonSetBuilder()
    .withNewMetadata()
        .withName("log-collector")
        .withNamespace("kube-system")
    .endMetadata()
    .withNewSpec()
        .withNewSelector()
            .addToMatchLabels("app", "log-collector")
        .endSelector()
        .withNewTemplate()
            .withNewMetadata()
                .addToLabels("app", "log-collector")
            .endMetadata()
            .withNewSpec()
                .addNewContainer()
                    .withName("fluentd")
                    .withImage("fluentd:latest")
                .endContainer()
            .endSpec()
        .endTemplate()
    .endSpec()
    .build();

client.apps().daemonSets().inNamespace("kube-system").resource(ds).create();
```

### Listing DaemonSets

```java
DaemonSetList dsList = client.apps().daemonSets().inAnyNamespace().list();
for (DaemonSet d : dsList.getItems()) {
    System.out.printf("DaemonSet %s: desired=%d, ready=%d%n",
        d.getMetadata().getName(),
        d.getStatus().getDesiredNumberScheduled(),
        d.getStatus().getNumberReady());
}
```
