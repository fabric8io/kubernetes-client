# Kubernetes & OpenShift 3 Java Client
This client provides access to the full [Kubernetes](http://kubernetes.io/) &
[OpenShift 3](http://openshift.org/) REST APIs via a fluent DSL.

## Usage

### Creating a client
Due to the amount of options (mainly to do with authentication) available when creating a client, a builder API is
provided to create the client.

The easiest way to create a client is:

```java
KubernetesClient client = new DefaultKubernetesClient.Builder().build();
```

This will use settings from different sources in the following order of priority:

* Anything specified through the builder DSL methods
* System properties
* Environment variables
* Kube config file
* Service account token & mounted CA certificate

System properties are preferred over environment variables. The following system properties & environment variables can be used for configuration:

* `kubernetes.master` / `KUBERNETES_MASTER`
* `kubernetes.api.version` / `KUBERNETES_API_VERSION`
* `kubernetes.oapi.version` / `KUBERNETES_OAPI_VERSION`
* `kubernetes.tls.protocols` / `KUBERNETES_TLS_PROTOCOLS`
* `kubernetes.trust.certificates` / `KUBERNETES_TRUST_CERT`
* `kubernetes.certs.ca.file` / `KUBERNETES_CA_CERTIFICATE_FILE`
* `kubernetes.certs.ca.data` / `KUBERNETES_CA_CERTIFICATE_DATA`
* `kubernetes.certs.client.file` / `KUBERNETES_CLIENT_CERTIFICATE_FILE`
* `kubernetes.certs.client.data` / `KUBERNETES_CLIENT_CERTIFICATE_DATA`
* `kubernetes.certs.client.key.file` / `KUBERNETES_CLIENT_KEY_FILE`
* `kubernetes.certs.client.key.data` / `KUBERNETES_CLIENT_KEY_DATA`
* `kubernetes.certs.client.key.algo` / `KUBERNETES_CLIENT_KEY_ALGO`
* `kubernetes.certs.client.key.passphrase` / `KUBERNETES_CLIENT_KEY_PASSPHRASE`
* `kubernetes.auth.basic.username` / `KUBERNETES_AUTH_BASIC_USERNAME`
* `kubernetes.auth.basic.password` / `KUBERNETES_AUTH_BASIC_PASSWORD`
* `kubernetes.auth.tryKubeConfig` / `KUBERNETES_AUTH_TRYKUBECONFIG`
* `kubernetes.auth.tryServiceAccount` / `KUBERNETES_AUTH_TRYSERVICEACCOUNT`
* `kubernetes.auth.token` / `KUBERNETES_OAUTH_TOKEN`

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

Update uses the inline builders from the Kubernetes Model:

```java
Namespace myns = client.namespaces().withName("myns").edit()
                   .editMetadata()
                     .addToLabels("a", "label")
                   .endMetadata()
                   .update();

Service myservice = client.services().inNamespace("default").withName("myservice").edit()
                     .editMetadata()
                       .addToLabels("another", "label")
                     .endMetadata()
                     .update();
```
