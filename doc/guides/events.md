---
title: "Events"
description: "Read and watch Kubernetes Events for debugging and monitoring"
weight: 17
---

# Events

Kubernetes Events record state changes, errors, and informational messages about cluster resources.

## Listing Events (core/v1)

```java
EventList events = client.v1().events()
    .inNamespace("default")
    .list();

for (Event event : events.getItems()) {
    System.out.printf("[%s] %s: %s - %s%n",
        event.getType(),
        event.getInvolvedObject().getName(),
        event.getReason(),
        event.getMessage());
}
```

## Filtering Events for a Specific Resource

```java
EventList podEvents = client.v1().events()
    .inNamespace("default")
    .withField("involvedObject.name", "my-pod")
    .withField("involvedObject.kind", "Pod")
    .list();
```

## Events API (events.k8s.io/v1)

The newer Events API provides richer event metadata:

```java
io.fabric8.kubernetes.api.model.events.v1.EventList events =
    client.events().v1().events()
        .inNamespace("default")
        .list();

for (io.fabric8.kubernetes.api.model.events.v1.Event event : events.getItems()) {
    System.out.printf("[%s] %s: %s%n",
        event.getType(),
        event.getReason(),
        event.getNote());
}
```

## Watching Events

```java
client.v1().events()
    .inNamespace("default")
    .watch(new Watcher<Event>() {
        @Override
        public void eventReceived(Action action, Event event) {
            System.out.printf("%s [%s] %s: %s%n",
                action,
                event.getType(),
                event.getInvolvedObject().getName(),
                event.getMessage());
        }

        @Override
        public void onClose(WatcherException e) {}
    });
```