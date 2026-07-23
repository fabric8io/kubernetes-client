---
title: "Testing"
description: "Test your Kubernetes code with mock servers and real API servers"
weight: 6
bookCollapseSection: true
---

# Testing

Fabric8 provides testing utilities for both unit tests (with a mock Kubernetes server) and integration tests (with a real API server).

- **[Mock Server Testing]({{< relref "/docs/testing/mock-server" >}})** — Unit test with a fake Kubernetes API (CRUD and expectations modes)
- **[Integration Testing with a Real API Server]({{< relref "/docs/testing/kube-api-test" >}})** — Run tests against a real Kubernetes API Server using kube-api-test