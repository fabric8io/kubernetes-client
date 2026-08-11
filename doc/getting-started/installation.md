---
title: "Installation"
description: "Add Fabric8 Kubernetes Client to your project"
weight: 1
---

# Installation

## Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-client</artifactId>
    <version>${kubernetes-client.version}</version>
</dependency>
```

## Gradle

```groovy
implementation 'io.fabric8:kubernetes-client:${kubernetesClientVersion}'
```

## HTTP Client Implementations

The client ships with multiple HTTP client backends. The default is **Vert.x**. If you prefer a different backend, exclude the default and add your preferred one:

| Backend | Artifact |
|---------|----------|
| Vert.x 4 (default) | `kubernetes-httpclient-vertx` |
| Vert.x 5 | `kubernetes-httpclient-vertx-5` |
| OkHttp | `kubernetes-httpclient-okhttp` |
| JDK HttpClient | `kubernetes-httpclient-jdk` |
| Jetty | `kubernetes-httpclient-jetty` |

### Example: Using JDK HttpClient instead of Vert.x

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-client</artifactId>
    <version>${kubernetes-client.version}</version>
    <exclusions>
        <exclusion>
            <groupId>io.fabric8</groupId>
            <artifactId>kubernetes-httpclient-vertx</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-httpclient-jdk</artifactId>
    <version>${kubernetes-client.version}</version>
</dependency>
```

> **Note:** The JDK HttpClient backend requires Java 11+.
