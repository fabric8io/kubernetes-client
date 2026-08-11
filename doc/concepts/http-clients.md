---
title: "HTTP Client Backends"
description: "Pluggable HTTP client implementations via SPI"
weight: 4
---

# HTTP Client Backends

Fabric8 Kubernetes Client uses a pluggable HTTP client architecture via Java SPI (Service Provider Interface). You choose the backend at build time by including the corresponding dependency.

## Available Backends

| Backend | Artifact | Requires |
|---------|----------|----------|
| **Vert.x 4** (default) | `kubernetes-httpclient-vertx` | Java 11+ |
| **Vert.x 5** | `kubernetes-httpclient-vertx-5` | Java 11+ |
| **OkHttp** | `kubernetes-httpclient-okhttp` | Java 11+ |
| **JDK HttpClient** | `kubernetes-httpclient-jdk` | Java 11+ |
| **Jetty** | `kubernetes-httpclient-jetty` | Java 11+ |

## Switching Backends

Exclude the default Vert.x backend and add your preferred one:

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

<!-- Use OkHttp instead -->
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-httpclient-okhttp</artifactId>
    <version>${kubernetes-client.version}</version>
</dependency>
```

## When to Choose What

- **Vert.x 4** — Default choice. Event-driven, non-blocking, good performance. Best for most use cases.
- **Vert.x 5** — For projects already on Vert.x 5. Same architecture as the Vert.x 4 backend but built against the Vert.x 5 API.
- **OkHttp** — Widely used in the Java ecosystem. Good if your project already depends on OkHttp.
- **JDK HttpClient** — Zero additional dependencies. Good for minimal footprints.
- **Jetty** — Useful if your project already uses the Jetty ecosystem.

## Troubleshooting

If you see `No HttpClient implementation found`, ensure exactly one HTTP client artifact is on the classpath:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-httpclient-jdk</artifactId>
</dependency>
```
