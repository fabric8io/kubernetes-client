---
title: "ConfigMaps and Secrets"
description: "Manage application configuration and sensitive data"
weight: 3
---

# ConfigMaps and Secrets

## ConfigMaps

### Creating a ConfigMap

```java
ConfigMap configMap = new ConfigMapBuilder()
    .withNewMetadata()
        .withName("app-config")
        .withNamespace("default")
    .endMetadata()
    .addToData("database.url", "jdbc:postgresql://db:5432/mydb")
    .addToData("log.level", "INFO")
    .addToData("app.properties", "key1=value1\nkey2=value2")
    .build();

client.configMaps().inNamespace("default").resource(configMap).create();
```

### Reading a ConfigMap

```java
ConfigMap cm = client.configMaps()
    .inNamespace("default")
    .withName("app-config")
    .get();

String dbUrl = cm.getData().get("database.url");
```

## Secrets

### Creating a Secret

```java
Secret secret = new SecretBuilder()
    .withNewMetadata()
        .withName("db-credentials")
        .withNamespace("default")
    .endMetadata()
    .withType("Opaque")
    .addToStringData("username", "admin")
    .addToStringData("password", "s3cret")
    .build();

client.secrets().inNamespace("default").resource(secret).create();
```

### TLS Secret

```java
Secret tlsSecret = new SecretBuilder()
    .withNewMetadata()
        .withName("tls-cert")
        .withNamespace("default")
    .endMetadata()
    .withType("kubernetes.io/tls")
    .addToData("tls.crt", Base64.getEncoder().encodeToString(certBytes))
    .addToData("tls.key", Base64.getEncoder().encodeToString(keyBytes))
    .build();
```

### Reading Secret Data

```java
Secret secret = client.secrets()
    .inNamespace("default")
    .withName("db-credentials")
    .get();

// Data is Base64-encoded
String username = new String(Base64.getDecoder().decode(secret.getData().get("username")));
```
