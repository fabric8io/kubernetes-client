# kube-api-test

`kube-api-test` makes it easy to implement integration tests with Kubernetes API Server in Java.
Inspired by [envtest](https://book.kubebuilder.io/reference/envtest.html) in Kubebuilder (Golang).

It runs the API Server binaries directly (without nodes and other components, but with etcd).
Linux, Windows, Mac is supported.

## Usage

Include dependency:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kube-api-test</artifactId>
    <version>[version]</version>
    <scope>test</scope>
</dependency>
```

### In Unit Tests

See sample unit
test [here](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/core/src/test/java/io/fabric8/kubeapitest/sample/JUnitExtensionSimpleCaseTest.java)

```java

@EnableKubeAPIServer
class JUnitExtensionSimpleCaseTest {

    // Use @KubeConfig annotation to inject kube config yaml to init any client
    @KubeConfig
    static String kubeConfigYaml;

    @Test
    void simpleTestWithTargetVersion() {
        var client = new KubernetesClientBuilder()
                .withConfig(Config.fromKubeconfig(kubeConfigYaml))
                .build();

        client.resource(TestUtils.testConfigMap()).create();
        var cm = client.resource(TestUtils.testConfigMap()).get();

        Assertions.assertThat(cm).isNotNull();
    }
}
```

### Public API

The underlying API can be used directly.
See [KubeApiServer](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/core/src/main/java/io/fabric8/kubeapitest/KubeAPIServer.java#L28-L28)

See
it's [usage in a test](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/core/src/test/java/io/fabric8/kubeapitest/sample/KubeApiServerTest.java#L31-L31).

```java
class KubeApiServerTest {
    
    @Test
    void apiServerTest() {
        var kubeApi = new KubeAPIServer();
        kubeApi.start();

        var client =  new KubernetesClientBuilder()
                .withConfig(Config.fromKubeconfig(kubeApi.getKubeConfigYaml()))
                .build();
        
        client.resource(TestUtils.testConfigMap()).create();
        
        var cm = client.resource(TestUtils.testConfigMap()).get();
        Assertions.assertThat(cm).isNotNull();
        
        kubeApi.stop();
    }
}
```

### Fabric8 Client Injection Support

Use dependency:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kube-api-test-client-inject</artifactId>
    <version>[version]</version>
    <scope>test</scope>
</dependency>
```

The client can be directly injected to the test. See sample test [here](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/client-inject/src/test/java/io/fabric8/kubeapitest/junit/sample/JUnitFabric8ClientInjectionTest.java#L28-L28).

```java

@EnableKubeAPIServer
class JUnitFabric8ClientInjectionTest {

    static KubernetesClient client;
   
    // emitted code     
}  
```

### Configuration Options

See available configuration options documented in [KubeAPIServerConfig](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/core/src/main/java/io/fabric8/kubeapitest/KubeAPIServerConfig.java)

Not all those properties can be overridden using [`@EnableKubeAPIServer`](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/core/src/main/java/io/fabric8/kubeapitest/junit/EnableKubeAPIServer.java)
annotation, since might not make sense to do it for an individual test case. However, those can be passed to
[`KubeApiServer`](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/core/src/main/java/io/fabric8/kubeapitest/KubeAPIServer.java)
and also configured globally using environment variables, see [KubeAPIServerConfigBuilder](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/core/src/main/java/io/fabric8/kubeapitest/KubeAPIServerConfigBuilder.java)


### Updating kube config file

In general, it is not advised but if instructed kube config file (~/kube/config) is updated by the framework.
See related property in [`@EnableKubeAPIServer`](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/core/src/main/java/io/fabric8/kubeapitest/junit/EnableKubeAPIServer.java#L42-L42)
annotation. The config file is automatically cleaned up on stop.

### How does it work

In the background Kubernetes and etcd (and kubectl) binaries are downloaded if not found locally.
All the certificates for the Kube API Server and for the client is generated.
The client certificates are generated with group `system:masters`;

### Downloading binaries

Binaries are downloaded automatically under ~/.kubeapitest/k8s/[target-platform-and-version] if no binary found locally.
If there are multiple binaries found, the latest if selected (unless a target version is not specified).

Also [`setup-envtest`](https://pkg.go.dev/sigs.k8s.io/controller-runtime/tools/setup-envtest#section-readme) can be used
to download binaries manually. By executing `setup-envtest use --bin-dir ~/.kubeapitest` will download the latest required
binaries to the default directory. This is useful if always running the tests in offline mode.

### Support for Parallel Execution in Junit5

Parallel test execution is explicitly supported for JUnit5, in fact the project tests are running parallel.
Running a new instance for each test case. This speeds up the tests (in our case >75%) in a way that test cases are also
fully isolated from each other. Although we experienced stability issues on non-Linux platforms. 

### Testing Mutation and Validation Webhooks

An additional benefit of running K8S API Server this way, is that it makes easy to test
[Conversion Hooks](https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definition-versioning/#webhook-conversion)
and/or
[Dynamic Admission Controllers](https://kubernetes.io/docs/reference/access-authn-authz/extensible-admission-controllers/)

In general, it is a best practice to use additional standard frameworks to implement Kubernetes webhooks,
like [kubernetes-webooks-framework](https://github.com/java-operator-sdk/kubernetes-webooks-framework)
with Quarkus or Spring. However, we demonstrate how it works
in [this test](https://github.com/fabric8io/kubernetes-client/blob/main/junit/kube-api-test/core/src/test/java/io/fabric8/kubeapitest/sample/KubernetesMutationHookHandlingTest.java#L72-L72)
