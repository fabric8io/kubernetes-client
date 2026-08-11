---
title: "Client Configuration"
description: "Configure the Kubernetes client connection, authentication, and behavior"
weight: 3
---

# Client Configuration

## Default Configuration

By default, `KubernetesClientBuilder` reads your kubeconfig file (`~/.kube/config`) or detects in-cluster configuration automatically.

```java
KubernetesClient client = new KubernetesClientBuilder().build();
```

## Programmatic Configuration

Use `ConfigBuilder` for explicit configuration:

```java
Config config = new ConfigBuilder()
    .withMasterUrl("https://my-cluster:6443")
    .withNamespace("my-namespace")
    .withOauthToken("my-token")
    .build();

KubernetesClient client = new KubernetesClientBuilder()
    .withConfig(config)
    .build();
```

## Common Configuration Options

| Option | Method | Description |
|--------|--------|-------------|
| API Server URL | `withMasterUrl(url)` | Kubernetes API server endpoint |
| Namespace | `withNamespace(ns)` | Default namespace for operations |
| OAuth Token | `withOauthToken(token)` | Bearer token authentication |
| Client Certificate | `withClientCertFile(path)` | TLS client certificate path |
| Client Key | `withClientKeyFile(path)` | TLS client key path |
| Trust Store | `withCaCertFile(path)` | CA certificate for API server |
| Request Timeout | `withRequestTimeout(ms)` | HTTP request timeout in milliseconds |
| Connection Timeout | `withConnectionTimeout(ms)` | TCP connection timeout in milliseconds |

## Environment Variables

The client recognizes these environment variables:

| Variable | Description |
|----------|-------------|
| `KUBERNETES_MASTER` | API server URL |
| `KUBERNETES_NAMESPACE` | Default namespace |
| `KUBERNETES_AUTH_TOKEN` | Bearer token |
| `KUBERNETES_CERTS_CA_FILE` | CA certificate path |
| `KUBERNETES_CERTS_CLIENT_FILE` | Client certificate path |
| `KUBERNETES_CERTS_CLIENT_KEY_FILE` | Client key path |

## In-Cluster Configuration

When running inside a Kubernetes pod, the client auto-detects the service account credentials mounted at `/var/run/secrets/kubernetes.io/serviceaccount/`.

```java
// Works automatically inside a pod
KubernetesClient client = new KubernetesClientBuilder().build();
```

## Kubeconfig Context Management

```java
// List available contexts
Config config = Config.autoConfigure(null);

// Connect to a specific context
Config config = Config.autoConfigure("my-context");
KubernetesClient client = new KubernetesClientBuilder()
    .withConfig(config)
    .build();
```

## Server Version

```java
VersionInfo version = client.getKubernetesVersion();
System.out.printf("Server: %s.%s%n", version.getMajor(), version.getMinor());
```

## OpenShift

To create an OpenShift-aware client:

```java
try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
    // Access OpenShift-specific resources
    client.routes().inNamespace("default").list();
}
```
