---
title: "Certificate Signing Requests"
description: "Create, approve, and deny CertificateSigningRequests"
weight: 19
---

# Certificate Signing Requests

## Creating a CSR

```java
CertificateSigningRequest csr = new CertificateSigningRequestBuilder()
    .withNewMetadata()
        .withName("my-csr")
    .endMetadata()
    .withNewSpec()
        .withRequest(Base64.getEncoder().encodeToString(csrPem))
        .withSignerName("kubernetes.io/kube-apiserver-client")
        .addToUsages("client auth")
    .endSpec()
    .build();

client.certificates().v1().certificateSigningRequests()
    .resource(csr)
    .create();
```

## Approving a CSR

```java
client.certificates().v1().certificateSigningRequests()
    .withName("my-csr")
    .approve(new CertificateSigningRequestConditionBuilder()
        .withType("Approved")
        .withStatus("True")
        .withReason("ApprovedByAdmin")
        .withMessage("Approved for cluster access")
        .build());
```

## Denying a CSR

```java
client.certificates().v1().certificateSigningRequests()
    .withName("my-csr")
    .deny(new CertificateSigningRequestConditionBuilder()
        .withType("Denied")
        .withStatus("True")
        .withReason("DeniedByPolicy")
        .withMessage("Request does not meet security requirements")
        .build());
```

## Listing CSRs

```java
CertificateSigningRequestList csrList = client.certificates().v1()
    .certificateSigningRequests()
    .list();

for (CertificateSigningRequest c : csrList.getItems()) {
    String status = c.getStatus().getConditions().stream()
        .map(CertificateSigningRequestCondition::getType)
        .findFirst()
        .orElse("Pending");
    System.out.printf("CSR %s: %s%n", c.getMetadata().getName(), status);
}
```

## Retrieving the Signed Certificate

```java
CertificateSigningRequest approved = client.certificates().v1()
    .certificateSigningRequests()
    .withName("my-csr")
    .get();

byte[] cert = Base64.getDecoder().decode(approved.getStatus().getCertificate());
```