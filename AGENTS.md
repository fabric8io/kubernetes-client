# Fabric8 Kubernetes Client - AI Agents Instructions

Always reference these instructions first and fallback to search or bash commands only when you encounter unexpected information that does not match the info here.

This file provides guidance to AI coding agents (GitHub Copilot, Claude Code, etc.) when working with code in this repository.

## Project Overview

Fabric8 Kubernetes Client is a Java client library that provides access to the full Kubernetes and OpenShift REST APIs via a fluent DSL. The project is a large multi-module Maven build targeting Java 11+, with pluggable HTTP client implementations and extensive extension modules for Kubernetes ecosystem projects (Knative, Tekton, Istio, etc.).

## Working Effectively

### Bootstrap and Setup

```bash
# Clone the repository
git clone https://github.com/fabric8io/kubernetes-client.git
cd kubernetes-client

# Quick build without tests (recommended for setup)
make quickly
```

### Build Commands

The project uses a `Makefile` for common operations. Prefer make targets over raw Maven commands.

```bash
# Quick build without tests (default target, ~3-5 minutes)
make quickly

# Full build with tests (10-15 minutes)
# WARNING: This is a long-running command - DO NOT CANCEL
make install

# Clean build artifacts
make clean

# Format code (license headers + Java formatting) - run before committing
make format

# Generate/regenerate model classes from OpenAPI schemas
make generate-model

# Regenerate javadoc element-list files for cross-module linking
# Run after adding/removing packages in core modules
make generate-javadoc-links
```

**Direct Maven commands** (when make targets don't cover the use case):
```bash
# Build a specific module
mvn clean install -pl kubernetes-client-api -DskipTests -T 1C

# Build with dependencies
mvn clean install -pl kubernetes-client -am -DskipTests -T 1C

# Check formatting without applying
mvn spotless:check
```

### Testing

```bash
# Run all unit tests (5-10 minutes)
# WARNING: This is a long-running command - DO NOT CANCEL
mvn clean install

# Run tests for a specific module
mvn test -pl kubernetes-tests

# Run a single test class
mvn test -pl kubernetes-tests -Dtest=PodCrudTest

# Run integration tests (requires running Kubernetes cluster)
# WARNING: This is a long-running command - DO NOT CANCEL
mvn -Pitests -pl kubernetes-itests verify

# Run OpenShift-specific integration tests
mvn -Pitests -pl kubernetes-itests verify -Dtest="io.fabric8.openshift.**"
```

### Running Examples

```bash
# Examples are in kubernetes-examples module
cd kubernetes-examples
mvn exec:java -Dexec.mainClass="io.fabric8.kubernetes.examples.ListPods"
```

## Architecture

### Technical Structure

```
kubernetes-client/                    # Root project
├── kubernetes-client-api/            # Core API interfaces and abstractions
├── kubernetes-client/                # Main client implementation
├── kubernetes-model-generator/       # Generates model classes from K8s OpenAPI
├── java-generator/                   # Generates Java from CRDs
├── crd-generator/                    # CRD generator from Java classes
├── generator-annotations/            # Annotations for code generation
│
├── httpclient-jdk/                   # Java 11+ HTTP client implementation
├── httpclient-okhttp/                # OkHttp3 implementation
├── httpclient-jetty/                 # Jetty HTTP client
├── httpclient-vertx/                 # Vert.x HTTP client (default)
│
├── kubernetes-tests/                 # Unit tests with mock server
├── kubernetes-itests/                # Integration tests (require cluster)
│
├── junit/                            # Testing utilities
│   ├── kubernetes-server-mock/       # Mock Kubernetes server
│   ├── kubernetes-junit-jupiter/     # JUnit 5 integration
│   ├── mockwebserver/                # HTTP/WebSocket mock server
│   └── kube-api-test/                # Real K8s API server testing
│
├── extensions/                       # Additional API support
│   ├── knative/                      # Knative resources
│   ├── tekton/                       # Tekton CI/CD
│   ├── istio/                        # Istio service mesh
│   ├── volcano/                      # Volcano batch scheduling
│   ├── chaosmesh/                    # Chaos engineering
│   └── ...
│
├── openshift-client-api/             # OpenShift API interfaces
├── openshift-client/                 # OpenShift implementation
│
├── doc/                              # Documentation
├── ide-config/                       # IDE configuration files
└── kubernetes-examples/              # Usage examples
```

### Design Patterns

**Fluent DSL/Builder Pattern**: Primary API design pattern
```java
KubernetesClient client = new KubernetesClientBuilder().build();
client.pods().inNamespace("default").withName("mypod").get();
client.apps().deployments().inNamespace("ns").list();
```

**Resource Builders**: All Kubernetes resources have builders
```java
Pod pod = new PodBuilder()
    .withNewMetadata()
        .withName("mypod")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .addNewContainer()
            .withName("nginx")
            .withImage("nginx:latest")
        .endContainer()
    .endSpec()
    .build();
```

**Adapter Pattern**: Convert between client types
```java
OpenShiftClient osClient = kubernetesClient.adapt(OpenShiftClient.class);
```

**API Group DSL**: Organized by Kubernetes API groups
- `client.pods()`, `client.services()` - Core v1
- `client.apps().deployments()` - apps/v1
- `client.batch().jobs()` - batch/v1
- `client.network().networkPolicies()` - networking.k8s.io/v1

**Pluggable HTTP Clients**: Via SPI (Service Provider Interface)
- Default: Vert.x
- Alternatives: OkHttp, Jetty, JDK HttpClient

## Code Style

**Formatting**: Use make target for formatting (applies both license headers and Java formatting)
```bash
# Format all code (license headers + spotless) - run before committing
make format

# Check formatting without applying
mvn spotless:check
```

**IDE Configuration**: Import from `/ide-config/`
- Eclipse: `eclipse-format.xml` and `eclipse.importorder`
- IntelliJ: Import Eclipse formatter profile

**Conventions**:
- Package naming: `io.fabric8.kubernetes.*`
- Logger variable: `logger` (not `LOG` or `LOGGER`)
- No wildcard imports (e.g., use `import java.util.List;` not `import java.util.*;`)
- Apache License 2.0 headers required on all source files
- Use fluent/DSL-style API design
- Java 11+ syntax allowed

## Testing Guidelines

### Testing Frameworks
- **JUnit 5** (Jupiter) - Primary test framework
- **JUnit 4** - Legacy tests (being migrated)
- **AssertJ** - Fluent assertions (`assertThat(...)`)
- **Mockito** - Mocking (use sparingly)
- **Awaitility** - Async testing

### Mock Server Testing

Two modes available via `@EnableKubernetesMockClient`:

**CRUD Mode** (recommended for most tests):
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

**Expectations Mode** (for precise HTTP control):
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

### Testing Philosophy

1. **Prefer CRUD Mode**: Use `crud = true` for simpler, more maintainable tests
2. **Black-box Testing**: Test behavior through the client API, not internals
3. **Avoid Excessive Mocking**: Use the mock server instead of Mockito for client tests
4. **Use AssertJ**: Prefer fluent assertions for readability

### Test Structure Pattern

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

## Common Tasks

### Adding a New Resource Type

1. Define model class with builders in `kubernetes-model-generator`
2. Add DSL interface in `kubernetes-client-api`
3. Implement in `kubernetes-client`
4. Add tests in `kubernetes-tests`

### Working with Custom Resources

```java
// Define the custom resource class
@Group("example.com")
@Version("v1")
public class MyResource extends CustomResource<MySpec, MyStatus>
    implements Namespaced {}

// Use with client
MixedOperation<MyResource, KubernetesResourceList<MyResource>, Resource<MyResource>>
    myResources = client.resources(MyResource.class);

myResources.inNamespace("ns").create(new MyResource());
```

### Generating CRDs from Java

```bash
# See doc/CRD-generator.md
mvn io.fabric8:crd-generator-maven-plugin:generate
```

### Generating Java from CRDs

```bash
# See doc/java-generation-from-CRD.md
mvn io.fabric8:java-generator-maven-plugin:generate
```

### Updating CHANGELOG

When adding features or fixing bugs, update `CHANGELOG.md` in the root directory.

## Troubleshooting

### Build Failures

**OutOfMemoryError during build**:
```bash
export MAVEN_OPTS="-Xmx2g"
mvn clean install
```

**Test failures with mock server**:
- Ensure tests use `@EnableKubernetesMockClient` annotation
- Check that server expectations match actual requests

### Common Issues

**"No HttpClient implementation found"**: Add an HTTP client dependency
```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-httpclient-jdk</artifactId>
</dependency>
```

**Model class not found**: Regenerate model classes from OpenAPI schemas
```bash
# Using make target (recommended)
make generate-model

# Or using Maven directly with generate profile
cd kubernetes-model-generator && mvn -Pgenerate clean install
```

## Key Documentation

- `/doc/CHEATSHEET.md` - kubectl equivalents in Java
- `/doc/FAQ.md` - Frequently asked questions
- `/doc/CRD-generator.md` - CRD generation from Java
- `/doc/java-generation-from-CRD.md` - Java generation from CRDs
- `/doc/kube-api-test.md` - Testing with real API server
- `/doc/MIGRATION-v7.md` - Migration guide for v7

## Dependencies

Key libraries used:
- Jackson 2.x - JSON/YAML serialization
- SLF4J - Logging facade
- Sundrio - Builder generation
- SnakeYAML - YAML parsing