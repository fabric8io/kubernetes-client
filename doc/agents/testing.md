# Testing

## Commands

```bash
# Run all unit tests, about 5-10 minutes
# WARNING: This is a long-running command. Do not cancel it.
mvn clean install

# Run tests for a specific module
mvn test -pl kubernetes-tests

# Run a single test class
mvn test -pl kubernetes-tests -Dtest=PodCrudTest

# Run integration tests, requires a running Kubernetes cluster
# WARNING: This is a long-running command. Do not cancel it.
mvn -Pitests -pl kubernetes-itests verify

# Run OpenShift-specific integration tests
mvn -Pitests -pl kubernetes-itests verify -Dtest="io.fabric8.openshift.**"
```

## Suite Prerequisites

- `make install` and module `mvn test` commands do not require an external
  cluster.
- `mvn -Pitests -pl kubernetes-itests verify` requires a reachable Kubernetes
  API. Run `kubectl cluster-info` first.
- OpenShift-specific integration tests require an OpenShift API. Run `oc
  whoami` or `kubectl api-resources | rg 'route.openshift.io|project.openshift.io'`
  first.
- `mvn -Pitests -pl kubernetes-itests-envtest verify` is standalone and does
  not require an external cluster.
- `mvn -Pitests -pl chaos-tests verify` requires Docker for JKube image builds
  plus a reachable Kubernetes cluster with Chaos Mesh installed. Run `docker
  info`, `kubectl cluster-info`, and `kubectl api-resources | rg
  'chaos-mesh.org|networkchaos'` first.

If any prerequisite fails, report an environment block unless the user
explicitly asks to run the failing suite anyway.

## Frameworks

- JUnit 5 Jupiter is the primary test framework.
- JUnit 4 is present for legacy tests that are being migrated.
- AssertJ is used for fluent assertions through `assertThat(...)`.
- Mockito is available but should be used sparingly.
- Awaitility is used for async testing.

## Mock Server Testing

Two modes are available through `@EnableKubernetesMockClient`.

Default to plain HTTP, `https = false`, for new mock-mode tests. The first
HTTPS call in each surefire fork pays a 7-8 second TLS/Vert.x cold-start cost,
which compounds under `forkCount=1C`. Only enable HTTPS when TLS itself is the
unit under test. Current exceptions are `UntrustedCertTest` and `KeyLoadTests`.

```java
@EnableKubernetesMockClient(https = false, crud = true)
class MyTest { /* ... */ }
```

## CRUD Mode

CRUD mode is recommended for most tests.

```java
@EnableKubernetesMockClient(crud = true)
class MyTest {
    KubernetesMockServer server;
    KubernetesClient client;

    @Test
    void testCreateAndGet() {
        Pod pod = new PodBuilder()
            .withNewMetadata().withName("test").endMetadata()
            .build();

        client.pods().inNamespace("ns").create(pod);
        Pod result = client.pods().inNamespace("ns").withName("test").get();

        assertThat(result).isNotNull();
        assertThat(result.getMetadata().getName()).isEqualTo("test");
    }
}
```

## Expectations Mode

Use expectations mode for precise HTTP control.

```java
@EnableKubernetesMockClient
class MyTest {
    KubernetesMockServer server;
    KubernetesClient client;

    @Test
    void testWithExpectations() {
        server.expect()
            .get()
            .withPath("/api/v1/namespaces/ns/pods/mypod")
            .andReturn(200, pod)
            .once();

        Pod result = client.pods().inNamespace("ns").withName("mypod").get();
        assertThat(result).isNotNull();
    }
}
```

## Testing Philosophy

1. Prefer CRUD mode with `crud = true` for simpler, more maintainable tests.
2. Test behavior through the client API, not internals.
3. Avoid excessive mocking; use the mock server instead of Mockito for client
   tests.
4. Use AssertJ for fluent assertions.
5. Add `@DisplayName` on test methods describing the behavior contract. When a
   test fails, the displayed name should identify the broken contract without
   requiring the future implementer to read the test body.

## Test Structure Pattern

```java
class DeploymentServiceTest {

    @EnableKubernetesMockClient(crud = true)
    static class WhenCreatingDeployment {
        KubernetesClient client;

        @Nested
        class WithValidInput {
            private Deployment result;

            @BeforeEach
            void setUp() {
                Deployment deployment = new DeploymentBuilder()
                    .withNewMetadata().withName("myapp").endMetadata()
                    .build();
                result = client.apps().deployments()
                    .inNamespace("default")
                    .create(deployment);
            }

            @Test
            void returnsCreatedDeployment() {
                assertThat(result.getMetadata().getName()).isEqualTo("myapp");
            }

            @Test
            void assignsUid() {
                assertThat(result.getMetadata().getUid()).isNotNull();
            }
        }
    }
}
```
