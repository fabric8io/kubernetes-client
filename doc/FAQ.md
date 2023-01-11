# Frequently Asked Questions:

### How do I use KubernetesClient with IPv6 Kubernetes Clusters?
We're aware of this [issue](https://github.com/fabric8io/kubernetes-client/issues/2632) in Fabric8 Kubernetes Client. Unfortunately, this is caused by the OkHttp transitive dependency. You can check the suggested workaround here:

[Using KubernetesClient with IPv6 based Kubernetes Clusters](./KubernetesClientWithIPv6Clusters.md)

### What artifact(s) should my project depend on?
Fabric8 version 6 introduces more options with regards to dependencies.

1. Have compile dependencies on kubenetes-client or openshift-client - this is no different than what was done with version 5 and before.  If you have done custom development involving effectively internal classes, you'll need to still use this option.

2. Have compile dependencies on kubenetes-client-api or openshift-client-api, and a runtime dependency on kubenetes-client or openshift-client.  This option will provide your application with a cleaner compile time classpath.

Furthermore you will also have choices in the HttpClient that is utilized.  

By default kubenetes-client has a runtime dependency on OkHttp (kubernetes-httpclient-okhttp).  If you need to directly manipulate OkHttp, you add a compile dependency to kubernetes-httpclient-okhttp.  

If you wish to use another HttpClient implementation typically you will exclude kubernetes-httpclient-okhttp and include the other runtime or compile dependency instead.

### What is Bouncy Castle Optional dependency and When is it required?
[BouncyCastle](https://bouncycastle.org/) is a Java library that complements the default Java Cryptographic Extension (JCE) and it is required for using some KubernetesClient features. To use support for EC Keys you must explicitly add this dependency to classpath. For example, in case of a Maven project add the required dependencies to `pom.xml` file such as:
```xml
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcpkix-jdk15on</artifactId>
    <version>${bouncycastle.version}</version>
</dependency>
```

### I've tried adding a dependency to kubernetes-client, but I'm still getting weird class loading issues, what gives?

More than likely your project already has transitive dependencies to a conflicting version of the Fabric8 Kubernetes Client.  For example spring-cloud-dependencies already depends upon the client.  You should fully override the client version in this case via the kubernetes-client-bom:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>io.fabric8</groupId>
      <artifactId>kubernetes-client-bom</artifactId>
      <version>${fabric8.client.version}</version>
      <scope>import</scope>
      <type>pom</type>
    </dependency>
  ...
```

That will align all of the transitive Fabric8 Kubernetes Client dependencies to you chosen version, fabric8.client.version.  Please be aware though that substituting a different major version of the client may not be fully compatible with the existing usage in your dependency - if you run into an issue, please check for or create an issue for an updated version of that project's library that contains a later version of the Fabric8 Kubernetes Client.

### What threading concerns are there?

There has been a lot of changes under the covers with thread utilization in the Fabric8 client over the 5.x and 6.x releases.  So the exact details of what threads are created / used where will depend on the particular release version.

At the core the thread utilization will depend upon the http client implementation.  Per client OkHttp maintains a pool of threads for task execution.  It will dedicate 2 threads out of that pool per WebSocket connection.  If you have a lot of WebSocket usage (Informer or Watches) with OkHttp, you can expect to see a large number of threads in use - which can potentially exhaust the OkHttp defaults.

With the JDK http client it will only maintain a selector thread and a small worker pool which will be based upon your available processors per client.  It does not matter how many Informers or Watches you run, the same worker pool is shared.

> **Note:** It is recommended with either HTTP client implementation that logic you supply via Watchers, ExecListeners, ResourceEventHandlers, Predicates, etc. does not execute long running tasks. 

For non-ResourceEventHandlers call backs long-running operation can be a problem.  When using the OkHttp client and default settings holding a IO thread inhibits websocket processing that can timeout the ping and may prevent additional requests since the okhttp client defaults to only 5 concurrent requests per host.  When using the JDK http client the long running task will inhibit the use of that IO thread for ALL http processing.  Note that calling other KubernetesClient operations, especially those with waits, can be long-running.  We are working towards providing non-blocking mode for many of these operations, but until that is available consider using a separate task queue for such work.

On top of the http client threads the Fabric8 client maintains a task thread pool for scheduled tasks and for potentially long-running tasks that are called from WebSocket operations, such as handling input and output streams and ResourceEventHandler call backs.  This thread pool defaults to an unlimited number of cached threads, which will be shutdown when the client is closed - that is a sensible default with either http client as the amount of concurrently running async tasks will typically be low.  If you would rather take full control over the threading use KubernetesClientBuilder.withExecutor or KubernetesClientBuilder.withExecutorSupplier - however note that constraining this thread pool too much will result in a build up of event processing queues.

Finally the fabric8 client will use 1 thread per PortForward and an additional thread per socket connection - this may be improved upon in the future.

### What additional logging is available?

Like many java application the Fabric8 Client utilizes [slf4j](https://www.slf4j.org/).  You may configure support for whatever underlying logging framework suits your needs.  The logging contexts for the Fabric8 Client follow the standard convention of the package structure - everything from within the client will be rooted at the io.fabric8 context.  Third-party dependencies, including the chosen HTTP client implementation, will have different root contexts.

If you are using pod exec, which can occur indirectly via pod operations like copying files, and not seeing the expected behavior - please enable debug logging for the io.fabric8.kubernetes.client.dsl.internal context.  That will provide the stdErr and stdOut as debug logs to further diagnose what is occurring.

### How to use KubernetesClient in OSGi?

Fabric8 Kubernetes Client provides ManagedKubernetesClient and ManagedOpenShiftClient as [OSGi Declarative Service](https://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.component.html). In order to use it, you must have [Service Component Runtime (SCR)](https://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.component.html#service.component-service.component.runtime) feature enabled in your OSGi runtime. In [Apache Karaf](https://karaf.apache.org/), you can add this to Karaf Maven Plugin configuration:
```xml
<plugin>
  <groupId>org.apache.karaf.tooling</groupId>
  <artifactId>karaf-maven-plugin</artifactId>
  <version>${karaf.version}</version>
  <configuration>
    <startupFeatures>
      <feature>scr</feature>
    </startupFeatures>
  </configuration>
</plugin>
```

You would need to provide component configuration files for the client you're using. For example, in case of [Apache Karaf](https://karaf.apache.org/), place configuration files in this directory:
```
src/
└── main
    └── resources
        ├── assembly
        │ └── etc
        │     ├── io.fabric8.kubernetes.client.cfg
        │     ├── io.fabric8.openshift.client.cfg
```

Once added KubernetesClient declarative services would be exposed automatically on startup. Then you can inject it in your project. Here is an example using Apache camel's `@BeanInject` annotation:

```java
  @BeanInject
  private KubernetesClient kubernetesClient
```

### Why am I getting Exception when using `*` in NO_PROXY ?

Starting Fabric8 Kubernetes Client v6.1.0, we've change NO_PROXY matching as simple as possible and not support any meta characters. It honors the [GNU WGet Spec](https://www.gnu.org/software/wget/manual/html_node/Proxies.html).

So instead of providing NO_PROXY like this:

(Unsupported) :x:
```java
NO_PROXY: localhost,127.0.0.1,*.google.com, *.github.com
```
we should provide it like this:

(Supported) :heavy_check_mark:
```java
NO_PROXY: localhost,127.0.0.1,.google.com,.github.com
```
