---
title: "Guides"
description: "Task-oriented guides for common Fabric8 Kubernetes Client workflows"
weight: 3
bookCollapseSection: true
---

# Guides

Step-by-step guides for common tasks with the Fabric8 Kubernetes Client.

### Workloads
- [Managing Deployments]({{< relref "/docs/guides/deployments" >}}) — create, scale, rolling update, pause, resume, undo
- [StatefulSets and DaemonSets]({{< relref "/docs/guides/statefulsets-and-daemonsets" >}})
- [Jobs and CronJobs]({{< relref "/docs/guides/jobs-and-cronjobs" >}})
- [Pod Operations]({{< relref "/docs/guides/pod-operations" >}}) — exec, attach, logs, port-forward, file transfer, eviction, ephemeral containers

### Networking
- [Services and Ingress]({{< relref "/docs/guides/services-and-ingress" >}})
- [Network Policies]({{< relref "/docs/guides/network-policies" >}})
- [Endpoints and EndpointSlices]({{< relref "/docs/guides/endpoint-slices" >}})

### Configuration and Storage
- [ConfigMaps and Secrets]({{< relref "/docs/guides/configmaps-and-secrets" >}})
- [Storage]({{< relref "/docs/guides/storage" >}}) — PVs, PVCs, StorageClasses

### Cluster Administration
- [Namespaces]({{< relref "/docs/guides/namespaces" >}})
- [Nodes]({{< relref "/docs/guides/nodes" >}}) — labels, taints, cordon/uncordon
- [RBAC]({{< relref "/docs/guides/rbac" >}}) — Roles, ClusterRoles, authorization checks
- [ServiceAccounts]({{< relref "/docs/guides/service-accounts" >}}) — token requests
- [Resource Quotas and Limit Ranges]({{< relref "/docs/guides/resource-quotas-and-limits" >}})
- [Autoscaling]({{< relref "/docs/guides/autoscaling" >}}) — HPA, PDB, metrics
- [Scheduling]({{< relref "/docs/guides/scheduling" >}}) — PriorityClasses, RuntimeClasses
- [Leases and Coordination]({{< relref "/docs/guides/leases-and-coordination" >}})
- [Events]({{< relref "/docs/guides/events" >}}) — watch cluster events for debugging

### Security
- [Certificate Signing Requests]({{< relref "/docs/guides/certificates" >}}) — create, approve, deny
- [Admission Webhooks]({{< relref "/docs/guides/admission-webhooks" >}}) — ValidatingWebhookConfiguration, MutatingWebhookConfiguration, ValidatingAdmissionPolicy

### API Extensions
- [Managing CRDs]({{< relref "/docs/guides/crds" >}}) — CustomResourceDefinition lifecycle
- [Loading YAML and Generic Resources]({{< relref "/docs/guides/loading-and-generic-resources" >}})
- [Server-Side Content Negotiation]({{< relref "/docs/guides/server-side-content-negotiation" >}}) — PartialObjectMetadata, Table
- [Dry Run and Server-Side Apply]({{< relref "/docs/guides/dry-run-and-server-side-apply" >}}) — validate without persisting, field ownership