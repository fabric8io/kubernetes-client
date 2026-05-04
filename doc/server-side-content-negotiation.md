# Server-Side Content Negotiation: PartialObjectMetadata and Table

Kubernetes supports server-side content negotiation via the HTTP `Accept` header, allowing clients to request a different representation of a resource without changing the API endpoint. The Fabric8 client exposes two such representations:

| Feature | Accept Header | Use Case |
|---------|--------------|----------|
| `PartialObjectMetadata` | `application/json;as=PartialObjectMetadata;g=meta.k8s.io;v=v1` | Fetch only `metadata` (no spec/status) |
| `Table` | `application/json;as=Table;v=v1;g=meta.k8s.io` | Fetch server-rendered tabular data (like `kubectl get`) |

Both features are available on **any** resource type - built-in resources, CRDs, and custom resources alike.

---

## PartialObjectMetadata

### What is it?

`PartialObjectMetadata` is a lightweight response containing only the resource's `metadata` field - no `spec`, no `status`. The Kubernetes API server strips those fields server-side before sending the response, significantly reducing payload size.

This is useful when you only need labels, annotations, names, UIDs, or resource versions - for example, in controllers that watch many resources but only need metadata to make decisions.

### DSL

```
// Single resource
client.<resource>().inNamespace(ns).withName(name).getAsPartialObjectMetadata()

// Collection
client.<resource>().inNamespace(ns).listAsPartialObjectMetadata()
client.<resource>().inNamespace(ns).listAsPartialObjectMetadata(ListOptions)
```

### Get the metadata of a single resource

```java
PartialObjectMetadata meta = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .getAsPartialObjectMetadata();

if (meta == null) {
    // resource does not exist
    return;
}

String name      = meta.getMetadata().getName();
String uid       = meta.getMetadata().getUid();
Map<String, String> labels      = meta.getMetadata().getLabels();
Map<String, String> annotations = meta.getMetadata().getAnnotations();
String resourceVersion          = meta.getMetadata().getResourceVersion();
```

> **Note:** `getAsPartialObjectMetadata()` returns `null` if the resource does not exist (404), consistent with `get()`.

### List metadata of all resources in a namespace

```java
PartialObjectMetadataList list = client.pods()
    .inNamespace("production")
    .listAsPartialObjectMetadata();

for (PartialObjectMetadata item : list.getItems()) {
    System.out.println(item.getMetadata().getName());
}
```

### Filter with label selector

```java
PartialObjectMetadataList list = client.pods()
    .inNamespace("default")
    .withLabel("app", "my-app")
    .listAsPartialObjectMetadata();
```

### Filter with field selector

```java
PartialObjectMetadataList list = client.pods()
    .inNamespace("default")
    .withField("status.phase", "Running")
    .listAsPartialObjectMetadata();
```

### List across all namespaces

```java
PartialObjectMetadataList list = client.pods()
    .inAnyNamespace()
    .listAsPartialObjectMetadata();
```

### Cluster-scoped resources (no namespace)

```java
// Get a single node's metadata
PartialObjectMetadata node = client.nodes()
    .withName("worker-node-1")
    .getAsPartialObjectMetadata();

// List all nodes' metadata
PartialObjectMetadataList nodes = client.nodes()
    .listAsPartialObjectMetadata();
```

### Non-core API resources

```java
PartialObjectMetadata deploy = client.apps().deployments()
    .inNamespace("staging")
    .withName("my-deploy")
    .getAsPartialObjectMetadata();
```

### Paginate with ListOptions

```java
String continueToken = null;
do {
    ListOptionsBuilder opts = new ListOptionsBuilder().withLimit(100L);
    if (continueToken != null) {
        opts.withContinue(continueToken);
    }

    PartialObjectMetadataList page = client.pods()
        .inNamespace("default")
        .listAsPartialObjectMetadata(opts.build());

    page.getItems().forEach(item ->
        System.out.println(item.getMetadata().getName()));

    continueToken = page.getMetadata() != null
        ? page.getMetadata().getContinue_()
        : null;

} while (continueToken != null && !continueToken.isEmpty());
```

### Custom resources

```java
PartialObjectMetadataList list = client.resources(MyCustomResource.class)
    .inNamespace("default")
    .listAsPartialObjectMetadata();
```

---

## Table

### What is it?

A `Table` is the format used by `kubectl get` - instead of full resource objects, the server returns:
- **`columnDefinitions`** - the column headers (name, type, description, priority)
- **`rows`** - one row per resource, where each row's `cells` list is aligned by index with `columnDefinitions`

The server decides which columns to include based on the resource type. Columns with `priority == 0` are shown in the default view; columns with `priority > 0` are "wide" columns shown with `kubectl get -o wide`.

### DSL

```
// Single resource
client.<resource>().inNamespace(ns).withName(name).getAsTable()

// Collection
client.<resource>().inNamespace(ns).listAsTable()
client.<resource>().inNamespace(ns).listAsTable(ListOptions)
```

### Key principle: columns are server-defined

You do not know the column names or count ahead of time - the server sends them with the response. Always read `columnDefinitions` first, then use it to interpret each row's `cells`.

### List resources as a table

```java
Table table = client.pods()
    .inNamespace("default")
    .listAsTable();

// Column names
table.getColumnDefinitions().forEach(col ->
    System.out.print(col.getName() + "\t"));
// NAME  READY  STATUS  RESTARTS  AGE

// Row data (cells aligned with columnDefinitions by index)
for (TableRow row : table.getRows()) {
    row.getCells().forEach(cell -> System.out.print(cell + "\t"));
    System.out.println();
}
// my-pod  1/1  Running  0  5d
```

### Get a single resource as a table

```java
Table table = client.pods()
    .inNamespace("default")
    .withName("my-pod")
    .getAsTable();

if (table == null) {
    // resource does not exist
    return;
}

// A single resource returns a table with one row
TableRow row = table.getRows().get(0);
System.out.println(row.getCells()); // [my-pod, 1/1, Running, 0, 5d]
```

> **Note:** `getAsTable()` returns `null` if the resource does not exist (404), consistent with `get()`.

### Look up a specific column by name

Since columns are server-defined, build a name-to-index map to look up cells by column name rather than hard-coding index positions:

```java
Table table = client.pods().inNamespace("default").listAsTable();

// Build column name → index map
Map<String, Integer> colIndex = new HashMap<>();
List<TableColumnDefinition> cols = table.getColumnDefinitions();
for (int i = 0; i < cols.size(); i++) {
    colIndex.put(cols.get(i).getName(), i);
}

// Read specific columns from each row
for (TableRow row : table.getRows()) {
    String name   = (String) row.getCells().get(colIndex.get("Name"));
    String status = (String) row.getCells().get(colIndex.get("Status"));
    String ready  = (String) row.getCells().get(colIndex.get("Ready"));
    System.out.printf("%-30s %-10s %-8s%n", name, status, ready);
}
```

### Show only default columns (skip -o wide columns)

Columns with `priority == 0` are shown by default; `priority > 0` are wide-only columns:

```java
Table table = client.pods().inNamespace("default").listAsTable();
List<TableColumnDefinition> cols = table.getColumnDefinitions();

// Collect indexes of default (non-wide) columns
List<Integer> defaultCols = new ArrayList<>();
for (int i = 0; i < cols.size(); i++) {
    if (cols.get(i).getPriority() == 0) {
        defaultCols.add(i);
    }
}

// Print headers
defaultCols.forEach(i -> System.out.print(cols.get(i).getName() + "\t"));
System.out.println();

// Print rows
for (TableRow row : table.getRows()) {
    defaultCols.forEach(i -> System.out.print(row.getCells().get(i) + "\t"));
    System.out.println();
}
```

### Filter with label or field selector

```java
// By label
Table table = client.pods()
    .inNamespace("default")
    .withLabel("app", "my-app")
    .listAsTable();

// By field
Table table = client.pods()
    .inNamespace("default")
    .withField("status.phase", "Running")
    .listAsTable();
```

### List across all namespaces

```java
Table table = client.pods()
    .inAnyNamespace()
    .listAsTable();
```

### Cluster-scoped resources (no namespace)

```java
Table table = client.nodes().listAsTable();
```

### Non-core API resources

```java
Table table = client.apps().deployments()
    .inNamespace("staging")
    .listAsTable();
```

### Paginate with ListOptions

```java
String continueToken = null;
do {
    ListOptionsBuilder opts = new ListOptionsBuilder().withLimit(50L);
    if (continueToken != null) {
        opts.withContinue(continueToken);
    }

    Table page = client.pods()
        .inNamespace("default")
        .listAsTable(opts.build());

    page.getRows().forEach(row ->
        System.out.println(row.getCells().get(0))); // pod name

    continueToken = page.getMetadata() != null
        ? page.getMetadata().getContinue_()
        : null;

} while (continueToken != null && !continueToken.isEmpty());
```

### Custom resources

```java
Table table = client.resources(MyCustomResource.class)
    .inNamespace("default")
    .listAsTable();
```

---

## Choosing between PartialObjectMetadata and Table

| | PartialObjectMetadata | Table |
|--|----------------------|-------|
| **Returns** | `ObjectMeta` (name, labels, annotations, UID, etc.) | Server-defined columns + formatted cell values |
| **Use when** | You need structured metadata fields | You need human-readable display data |
| **Column structure** | Always the same (`ObjectMeta`) | Varies by resource type, server-defined |
| **kubectl equivalent** | N/A (internal API) | `kubectl get <resource>` |
| **Payload size** | Smaller than full resource | Smaller than full resource |
| **Cell types** | Typed Java fields | `Object` (String, Integer, null) |
| **Good for** | Controllers, operators, automation | Display, CLI tools, dashboards |
