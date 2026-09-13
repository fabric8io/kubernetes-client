---
title: "Admission Webhooks"
description: "Manage ValidatingWebhookConfiguration and MutatingWebhookConfiguration"
weight: 18
---

# Admission Webhooks

Admission webhooks intercept API requests before they are persisted, allowing validation or mutation of resources.

## ValidatingWebhookConfiguration

```java
ValidatingWebhookConfiguration vwc = new ValidatingWebhookConfigurationBuilder()
    .withNewMetadata()
        .withName("pod-validator")
    .endMetadata()
    .addNewWebhook()
        .withName("validate.pods.example.com")
        .withAdmissionReviewVersions("v1")
        .withSideEffects("None")
        .withNewClientConfig()
            .withNewService()
                .withName("webhook-service")
                .withNamespace("webhook-system")
                .withPath("/validate")
            .endService()
        .endClientConfig()
        .addNewRule()
            .withApiGroups("")
            .withApiVersions("v1")
            .withOperations("CREATE", "UPDATE")
            .withResources("pods")
            .withScope("Namespaced")
        .endRule()
    .endWebhook()
    .build();

client.admissionRegistration().v1()
    .validatingWebhookConfigurations()
    .resource(vwc)
    .create();
```

## MutatingWebhookConfiguration

```java
MutatingWebhookConfiguration mwc = new MutatingWebhookConfigurationBuilder()
    .withNewMetadata()
        .withName("pod-injector")
    .endMetadata()
    .addNewWebhook()
        .withName("inject.pods.example.com")
        .withAdmissionReviewVersions("v1")
        .withSideEffects("None")
        .withReinvocationPolicy("IfNeeded")
        .withNewClientConfig()
            .withNewService()
                .withName("injector-service")
                .withNamespace("webhook-system")
                .withPath("/mutate")
            .endService()
        .endClientConfig()
        .addNewRule()
            .withApiGroups("")
            .withApiVersions("v1")
            .withOperations("CREATE")
            .withResources("pods")
            .withScope("Namespaced")
        .endRule()
    .endWebhook()
    .build();

client.admissionRegistration().v1()
    .mutatingWebhookConfigurations()
    .resource(mwc)
    .create();
```

## Listing Webhook Configurations

```java
// Validating
client.admissionRegistration().v1()
    .validatingWebhookConfigurations()
    .list()
    .getItems()
    .forEach(v -> System.out.println("Validating: " + v.getMetadata().getName()));

// Mutating
client.admissionRegistration().v1()
    .mutatingWebhookConfigurations()
    .list()
    .getItems()
    .forEach(m -> System.out.println("Mutating: " + m.getMetadata().getName()));
```

## ValidatingAdmissionPolicy (K8s 1.30+)

CEL-based in-process validation without a webhook server:

```java
ValidatingAdmissionPolicy policy = new ValidatingAdmissionPolicyBuilder()
    .withNewMetadata()
        .withName("require-labels")
    .endMetadata()
    .withNewSpec()
        .withNewMatchConstraints()
            .addNewResourceRule()
                .withApiGroups("")
                .withApiVersions("v1")
                .withOperations("CREATE")
                .withResources("pods")
            .endResourceRule()
        .endMatchConstraints()
        .addNewValidation()
            .withExpression("object.metadata.labels.size() > 0")
            .withMessage("Pods must have at least one label")
        .endValidation()
    .endSpec()
    .build();

client.admissionRegistration().v1()
    .validatingAdmissionPolicies()
    .resource(policy)
    .create();
```