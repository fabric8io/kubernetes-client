---
title: "Building Controllers"
description: "Build Kubernetes controllers and operators using informers"
weight: 2
---

# Building Controllers

A Kubernetes controller watches for changes to resources and reconciles actual state with desired state. Fabric8 Kubernetes Client provides the building blocks through informers and the client API.

## Basic Controller Pattern

```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {

    SharedIndexInformer<Pod> podInformer = client.pods()
        .inNamespace("default")
        .inform(new ResourceEventHandler<Pod>() {

            @Override
            public void onAdd(Pod pod) {
                reconcile(pod);
            }

            @Override
            public void onUpdate(Pod oldPod, Pod newPod) {
                reconcile(newPod);
            }

            @Override
            public void onDelete(Pod pod, boolean deletedFinalStateUnknown) {
                System.out.println("Deleted: " + pod.getMetadata().getName());
            }
        }, 30_000L);

    // Keep the controller running
    Thread.currentThread().join();
}
```

## Reconciliation with Work Queue

For production controllers, decouple event handling from reconciliation:

```java
BlockingQueue<String> workQueue = new LinkedBlockingQueue<>();

// Event handler adds keys to the work queue
client.pods().inNamespace("default").inform(new ResourceEventHandler<Pod>() {
    @Override
    public void onAdd(Pod pod) {
        workQueue.add(pod.getMetadata().getNamespace() + "/" + pod.getMetadata().getName());
    }

    @Override
    public void onUpdate(Pod oldPod, Pod newPod) {
        workQueue.add(newPod.getMetadata().getNamespace() + "/" + newPod.getMetadata().getName());
    }

    @Override
    public void onDelete(Pod pod, boolean deletedFinalStateUnknown) {
        workQueue.add(pod.getMetadata().getNamespace() + "/" + pod.getMetadata().getName());
    }
});

// Worker thread processes the queue
while (true) {
    String key = workQueue.take();
    try {
        reconcile(key);
    } catch (Exception e) {
        // Re-queue on failure
        workQueue.add(key);
    }
}
```

## Using Multiple Informers

Controllers often need to watch several resource types:

```java
SharedIndexInformer<Deployment> depInformer = client.apps().deployments()
    .inNamespace("default")
    .inform(depHandler, 30_000L);

SharedIndexInformer<Service> svcInformer = client.services()
    .inNamespace("default")
    .inform(svcHandler, 30_000L);

// Query the cache for cross-referencing
List<Deployment> deps = depInformer.getStore().list();
List<Service> svcs = svcInformer.getStore().list();
```

## Leader Election

For high-availability controllers that run multiple replicas:

```java
LeaderElector leaderElector = client.leaderElector()
    .withConfig(new LeaderElectionConfigBuilder()
        .withName("my-controller-lock")
        .withLeaseDuration(Duration.ofSeconds(15))
        .withRenewDeadline(Duration.ofSeconds(10))
        .withRetryPeriod(Duration.ofSeconds(2))
        .withLock(new LeaseLock("default", "my-controller-lock", "instance-1"))
        .withLeaderCallbacks(new LeaderCallbacks(
            () -> System.out.println("Became leader — starting reconciliation"),
            () -> System.out.println("Lost leadership — stopping"),
            newLeader -> System.out.println("Current leader: " + newLeader)
        ))
        .build())
    .build();

leaderElector.run();
```

## Further Reading

- [Kubernetes Operators in Java]({{< relref "/docs/KubernetesOperatorsInJavaWrittenUsingFabric8" >}}) — Real-world operator examples built with Fabric8 Kubernetes Client
