---
title: "RBAC"
description: "Manage Roles, ClusterRoles, and their Bindings"
weight: 9
---

# RBAC

## Roles and RoleBindings

### Creating a Role

```java
Role role = new RoleBuilder()
    .withNewMetadata()
        .withName("pod-reader")
        .withNamespace("default")
    .endMetadata()
    .addNewRule()
        .withApiGroups("")
        .withResources("pods")
        .withVerbs("get", "watch", "list")
    .endRule()
    .build();

client.rbac().roles().inNamespace("default").resource(role).create();
```

### Binding a Role to a User

```java
RoleBinding binding = new RoleBindingBuilder()
    .withNewMetadata()
        .withName("read-pods")
        .withNamespace("default")
    .endMetadata()
    .addNewSubject()
        .withKind("User")
        .withName("jane")
        .withApiGroup("rbac.authorization.k8s.io")
    .endSubject()
    .withNewRoleRef()
        .withKind("Role")
        .withName("pod-reader")
        .withApiGroup("rbac.authorization.k8s.io")
    .endRoleRef()
    .build();

client.rbac().roleBindings().inNamespace("default").resource(binding).create();
```

## ClusterRoles and ClusterRoleBindings

### Creating a ClusterRole

```java
ClusterRole clusterRole = new ClusterRoleBuilder()
    .withNewMetadata()
        .withName("node-reader")
    .endMetadata()
    .addNewRule()
        .withApiGroups("")
        .withResources("nodes")
        .withVerbs("get", "list", "watch")
    .endRule()
    .build();

client.rbac().clusterRoles().resource(clusterRole).create();
```

### Binding a ClusterRole to a ServiceAccount

```java
ClusterRoleBinding crb = new ClusterRoleBindingBuilder()
    .withNewMetadata()
        .withName("monitoring-node-reader")
    .endMetadata()
    .addNewSubject()
        .withKind("ServiceAccount")
        .withName("monitoring")
        .withNamespace("monitoring")
    .endSubject()
    .withNewRoleRef()
        .withKind("ClusterRole")
        .withName("node-reader")
        .withApiGroup("rbac.authorization.k8s.io")
    .endRoleRef()
    .build();

client.rbac().clusterRoleBindings().resource(crb).create();
```

## Checking Access (Authorization)

```java
SelfSubjectAccessReview review = new SelfSubjectAccessReviewBuilder()
    .withNewSpec()
        .withNewResourceAttributes()
            .withNamespace("default")
            .withVerb("create")
            .withResource("pods")
        .endResourceAttributes()
    .endSpec()
    .build();

SelfSubjectAccessReview result = client.authorization().v1()
    .selfSubjectAccessReview()
    .create(review);

System.out.println("Allowed: " + result.getStatus().getAllowed());
```
