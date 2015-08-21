# Kubernetes & OpenShift 3 Java Client
This client provides access to the full [Kubernetes](http://kubernetes.io/) &
[OpenShift 3](http://openshift.org/) REST APIs via a fluent DSL.

## Usage

### Creating a client
The easiest way to create a client is:

```java
KubernetesClient client = new DefaultKubernetesClient();
```

`DefaultKubernetesClient` implements both the `KubernetesClient` & `OpenShiftClient` interface so if you need the
OpenShift extensions, such as `Build`s, etc then simply do:

```java
OpenShiftClient osClient = new DefaultKubernetesClient();
```

This will use settings from different sources in the following order of priority:

* System properties
* Environment variables
* Kube config file
* Service account token & mounted CA certificate

System properties are preferred over environment variables. The following system properties & environment variables can be used for configuration:

* `kubernetes.master` / `KUBERNETES_MASTER`
* `kubernetes.api.version` / `KUBERNETES_API_VERSION`
* `kubernetes.oapi.version` / `KUBERNETES_OAPI_VERSION`
* `kubernetes.tls.protocols` / `KUBERNETES_TLS_PROTOCOLS`
* `kubernetes.trust.certificates` / `KUBERNETES_TRUST_CERTIFICATES`
* `kubernetes.certs.ca.file` / `KUBERNETES_CERTS_CA_FILE`
* `kubernetes.certs.ca.data` / `KUBERNETES_CERTS_CA_DATA`
* `kubernetes.certs.client.file` / `KUBERNETES_CERTS_CLIENT_FILE`
* `kubernetes.certs.client.data` / `KUBERNETES_CERTS_CLIENT_DATA`
* `kubernetes.certs.client.key.file` / `KUBERNETES_CERTS_CLIENT_KEY_FILE`
* `kubernetes.certs.client.key.data` / `KUBERNETES_CERTS_CLIENT_KEY_DATA`
* `kubernetes.certs.client.key.algo` / `KUBERNETES_CERTS_CLIENT_KEY_ALGO`
* `kubernetes.certs.client.key.passphrase` / `KUBERNETES_CERTS_CLIENT_KEY_PASSPHRASE`
* `kubernetes.auth.basic.username` / `KUBERNETES_AUTH_BASIC_USERNAME`
* `kubernetes.auth.basic.password` / `KUBERNETES_AUTH_BASIC_PASSWORD`
* `kubernetes.auth.tryKubeConfig` / `KUBERNETES_AUTH_TRYKUBECONFIG`
* `kubernetes.auth.tryServiceAccount` / `KUBERNETES_AUTH_TRYSERVICEACCOUNT`
* `kubernetes.auth.token` / `KUBERNETES_AUTH_TOKEN`
* `kubernetes.watch.reconnectInterval` / `KUBERNETES_WATCH_RECONNECTINTERVAL`
* `kubernetes.watch.reconnectLimit` / `KUBERNETES_WATCH_RECONNECTLIMIT`

Alternatively you can use the `ConfigBuilder` to create a config object for the Kubernetes client:

```java
Config config = new DefaultKubernetesClient.ConfigBuilder().masterUrl("https://mymaster.com").build;
KubernetesClient client = new DefaultKubernetesClient(config);
```

###
Using the DSL is the same for all resources.

List resources:

```java
NamespaceList myNs = client.namespaces().list();

ServiceList myServices = client.services().list();

ServiceList myNsServices = client.services().inNamespace("default").list();
```

Get a resource:

```java
Namespace myns = client.namespaces().withName("myns").get();

Service myservice = client.services().inNamespace("default").withName("myservice").get();
```

Delete:

```java
Namespace myns = client.namespaces().withName("myns").delete();

Service myservice = client.services().inNamespace("default").withName("myservice").delete();
```

Editing resources uses the inline builders from the Kubernetes Model:

```java
Namespace myns = client.namespaces().withName("myns").edit()
                   .editMetadata()
                     .addToLabels("a", "label")
                   .endMetadata()
                   .done();

Service myservice = client.services().inNamespace("default").withName("myservice").edit()
                     .editMetadata()
                       .addToLabels("another", "label")
                     .endMetadata()
                     .done();
```

In the same spirit you can inline builders to create:

```java
Namespace myns = client.namespaces().createNew()
                   .editMetadata()
                     .withName("myns")
                     .addToLabels("a", "label")
                   .endMetadata()
                   .done();

Service myservice = client.services().inNamespace("default").createNew()
                     .editMetadata()
                       .withName("myservice")
                       .addToLabels("another", "label")
                     .endMetadata()
                     .done();
```
