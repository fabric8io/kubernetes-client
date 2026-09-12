---
title: "ServiceAccounts"
description: "Create ServiceAccounts and request tokens"
weight: 12
---

# ServiceAccounts

## Creating a ServiceAccount

```java
ServiceAccount sa = new ServiceAccountBuilder()
    .withNewMetadata()
        .withName("app-sa")
        .withNamespace("default")
    .endMetadata()
    .build();

client.serviceAccounts().inNamespace("default").resource(sa).create();
```

## Requesting a Token

```java
TokenRequest tokenRequest = client.serviceAccounts()
    .inNamespace("default")
    .withName("app-sa")
    .tokenRequest();

String token = tokenRequest.getStatus().getToken();
System.out.println("Token: " + token);
```

## With a Custom TokenRequest

```java
TokenRequest request = new TokenRequestBuilder()
    .withNewSpec()
        .withExpirationSeconds(3600L)
        .addNewAudience("https://my-api.example.com")
    .endSpec()
    .build();

TokenRequest result = client.serviceAccounts()
    .inNamespace("default")
    .withName("app-sa")
    .tokenRequest(request);
```

## Listing ServiceAccounts

```java
ServiceAccountList saList = client.serviceAccounts()
    .inNamespace("default")
    .list();

for (ServiceAccount s : saList.getItems()) {
    System.out.println("ServiceAccount: " + s.getMetadata().getName());
}
```
