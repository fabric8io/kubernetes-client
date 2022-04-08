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

### What is Bouncy Castle optional dependency and when is it required?
BouncyCastle is a Java library that complements the default Java Cryptographic Extension (JCE) and it is required while using JcaPEMKeyConverter. To use support for EC Keys you must explicitly add this dependency to classpath. This should be added at the extension level. Having to add bouncy castle dependencies would not have been an issue. Especially as the Documentation tells to do so here: https://quarkus.io/guides/security-customization.
