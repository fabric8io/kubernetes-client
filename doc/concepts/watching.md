---
title: "Watching and Informers"
description: "Watch for resource changes and use informers for local caches"
weight: 3
---

# Watching and Informers

## Watching Resources

The `watch()` API provides real-time notifications of resource changes:

```java
Watch watch = client.pods().inNamespace("default").watch(new Watcher<Pod>() {
    @Override
    public void eventReceived(Action action, Pod pod) {
        switch (action) {
            case ADDED:
                System.out.println("Pod added: " + pod.getMetadata().getName());
                break;
            case MODIFIED:
                System.out.println("Pod modified: " + pod.getMetadata().getName());
                break;
            case DELETED:
                System.out.println("Pod deleted: " + pod.getMetadata().getName());
                break;
            case ERROR:
                System.out.println("Error on pod: " + pod.getMetadata().getName());
                break;
        }
    }

    @Override
    public void onClose(WatcherException e) {
        if (e != null) {
            System.err.println("Watch error: " + e.getMessage());
        }
    }
});

// Close the watch when done
watch.close();
```

## Filtered Watches

```java
// Watch pods with a specific label
client.pods().inNamespace("default")
    .withLabel("app", "web")
    .watch(watcher);

// Watch a single named resource
client.pods().inNamespace("default")
    .withName("my-pod")
    .watch(watcher);
```

## Informers

Informers maintain a local cache of resources and are more efficient than raw watches for building controllers:

```java
SharedIndexInformer<Pod> podInformer = client.pods()
    .inNamespace("default")
    .inform(new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod pod) {
            System.out.println("Added: " + pod.getMetadata().getName());
        }

        @Override
        public void onUpdate(Pod oldPod, Pod newPod) {
            System.out.println("Updated: " + newPod.getMetadata().getName());
        }

        @Override
        public void onDelete(Pod pod, boolean deletedFinalStateUnknown) {
            System.out.println("Deleted: " + pod.getMetadata().getName());
        }
    });

// The informer's cache
List<Pod> cachedPods = podInformer.getStore().list();

// Stop the informer
podInformer.close();
```

## Resync Period

Set a resync interval to periodically re-list and reconcile the cache:

```java
SharedIndexInformer<Pod> informer = client.pods()
    .inNamespace("default")
    .inform(handler, 30_000L); // resync every 30 seconds
```
