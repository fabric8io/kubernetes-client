---
title: "Custom Resources"
description: "Define and interact with Kubernetes Custom Resources"
weight: 1
---

# Custom Resources

## Defining a Custom Resource

Use annotations to define your custom resource Java classes:

```java
@Group("example.com")
@Version("v1")
public class Book extends CustomResource<BookSpec, BookStatus>
    implements Namespaced {
}

public class BookSpec {
    private String author;
    private String title;
    private int pages;

    // getters and setters
}

public class BookStatus {
    private String phase;
    private int availableCopies;

    // getters and setters
}
```

## Using Custom Resources with the Client

```java
// Get a typed resource client
MixedOperation<Book, KubernetesResourceList<Book>, Resource<Book>> books
    = client.resources(Book.class);

// Create
Book book = new Book();
book.getMetadata().setName("kubernetes-in-action");
book.getMetadata().setNamespace("library");
book.setSpec(new BookSpec("Marko Luksa", "Kubernetes in Action", 624));
books.inNamespace("library").resource(book).create();

// List
KubernetesResourceList<Book> allBooks = books.inNamespace("library").list();

// Get
Book fetched = books.inNamespace("library").withName("kubernetes-in-action").get();

// Update status
fetched.getStatus().setPhase("Available");
books.inNamespace("library").resource(fetched).updateStatus();

// Delete
books.inNamespace("library").withName("kubernetes-in-action").delete();
```

## Watching Custom Resources

```java
books.inNamespace("library").watch(new Watcher<Book>() {
    @Override
    public void eventReceived(Action action, Book book) {
        System.out.println(action + ": " + book.getMetadata().getName());
    }

    @Override
    public void onClose(WatcherException e) {}
});
```

## Loading from YAML

```java
Book book = client.resources(Book.class)
    .load(getClass().getResourceAsStream("/book.yaml"))
    .item();
```
