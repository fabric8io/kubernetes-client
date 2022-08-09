# Frequently Asked Questions:

### How do I use KubernetesClient with IPv6 Kubernetes Clusters?
We're aware of this [issue](https://github.com/fabric8io/kubernetes-client/issues/2632) in Fabric8 Kubernetes Client. Unfortunately, this is caused by the OkHttp transitive dependency. You can check suggested workaround here:

[Using KubernetesClient with IPv6 based Kubernetes Clusters](./KubernetesClientWithIPv6Clusters.md)

### What artifact(s) should my project depend on?
Fabric8 version 6 introduces more options with regards to dependencies.

1. Have compile dependencies on kubenetes-client or openshift-client - this is no different than what was done with version 5 and before.  If you have done custom development involving effectively internal classes, you'll need to still use this option.

2. Have compile dependencies on kubenetes-client-api or openshift-client-api, and a runtime dependency on kubenetes-client or openshift-client.  This option will provide your application with a cleaner compile time classpath.

Further more you will also have choices in the HttpClient that is utilized.  

By default kubenetes-client has a runtime dependency on OkHttp (kubernetes-httpclient-okhttp).  If you need to directly manipulate OkHttp, you add a compile dependency to kubernetes-httpclient-okhttp.  

If you wish to use another HttpClient implementation typically you will exclude kubernetes-httpclient-okhttp and include the other runtime dependency instead.

### What is Bouncy Castle Optional dependency and When is it required?
[BouncyCastle](https://bouncycastle.org/) is a Java library that complements the default Java Cryptographic Extension (JCE) and it is required for using some KubernetesClient features. To use support for EC Keys you must explicitly add this dependency to classpath. For example, in case of a Maven project add the required dependencies to `pom.xml` file such as:
```xml
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcpkix-jdk15on</artifactId>
    <version>${bouncycastle.version}</version>
</dependency>
```

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
