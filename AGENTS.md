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

Before running builds or tests, verify Maven is using a supported Java version for this checkout:

```bash
mvn -version
rg -n "maven.compiler.release|maven.compiler.source|java.version|maven-enforcer|toolchain|jdk" pom.xml .mvn **/pom.xml
```

Derive the required Java version from the project's Maven configuration; do not hardcode it in this file. If Maven is using an unsupported JDK, set `JAVA_HOME` to an installed supported JDK and re-run `mvn -version` before starting the build or test command.

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

For agent runs, keep Maven output out of the conversation context unless it is needed for debugging:

```bash
log="$(mktemp "${TMPDIR:-/tmp}/kubernetes-client-build.XXXXXX.log")"
MAVEN_ARGS="-B -ntp" make install >"$log" 2>&1
rc=$?
echo "Full build log: $log"
tail -200 "$log"
exit "$rc"
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

Test suite prerequisites:
- `make install` and module `mvn test` commands do not require an external cluster.
- `mvn -Pitests -pl kubernetes-itests verify` requires a reachable Kubernetes API. Run `kubectl cluster-info` first.
- OpenShift-specific integration tests require an OpenShift API. Run `oc whoami` or `kubectl api-resources | rg 'route.openshift.io|project.openshift.io'` first.
- `mvn -Pitests -pl kubernetes-itests-envtest verify` is standalone and does not require an external cluster.
- `mvn -Pitests -pl chaos-tests verify` requires Docker for JKube image builds plus a reachable Kubernetes cluster with Chaos Mesh installed. Run `docker info`, `kubectl cluster-info`, and `kubectl api-resources | rg 'chaos-mesh.org|networkchaos'` first.

If any prerequisite fails, report an environment block unless the user explicitly asks to run the failing suite anyway.

For long-running Maven commands, write output to a log file and poll with short tails, for example `tail -80 "$log"` every few minutes. Use Maven's final summary and report XML for test counts instead of repeatedly streaming the full log.

### Reproducing CI flakes locally

CI runs on 2-core GitHub Actions VMs with limited RAM. Surefire `forkCount=1C` and Vert.x event-loop sizing both scale with `Runtime.availableProcessors()`, so a flake that surfaces under CI scheduling pressure often won't reproduce with a plain `mvn test` on a 16+ core developer host. Run the test inside a constrained `docker` (or `podman`) container with the project and `~/.m2` bind-mounted — this is the closest local approximation to CI shape and almost always the fastest way to confirm or rule out a race.

```bash
# Constrained container — 2 cores, ~7 GB RAM, cgroup-enforced
docker run --rm \
  --cpus=2 --memory=7g --cpuset-cpus="0,1" \
  --user $(id -u):$(id -g) -e HOME=/tmp \
  -v "$PWD:/work" \
  -v "$HOME/.m2:/host-m2" \
  -w /work \
  maven:3.9-eclipse-temurin-11 \
  mvn -pl kubernetes-tests \
      -Dtest='SomeFlakyTest#someFlakyMethod' \
      -Dmaven.repo.local=/host-m2/repository \
      test
```

For harder contention, run a sibling `stress-ng` container pinned to the same `cpuset` as a noisy neighbor, then loop the test 25–50 times under that stress.

```bash
docker run --rm -d --name stressor --cpus=2 --cpuset-cpus="0,1" \
  alpine:latest sh -c 'apk add --no-cache stress-ng && stress-ng --cpu 4 --cpu-load 80 --timeout 600s'
```

Caveat: not every CI flake reproduces locally — GH Actions VMs add IO/network jitter that cgroup quota cannot simulate. After ~20 unsuccessful iterations, switch to instrument-and-wait (add timing logs on a debug branch and watch the next CI hit) rather than burning more local hours.

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

**Default to plain HTTP** (`https = false`) for new mock-mode tests. The first HTTPS call in each surefire fork pays a ~7–8 s TLS/Vert.x cold-start cost, which compounds under `forkCount=1C`. Only enable HTTPS when TLS itself is the unit under test (current exceptions: `UntrustedCertTest` and `KeyLoadTests`).

```java
@EnableKubernetesMockClient(https = false, crud = true)
class MyTest { /* ... */ }
```

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
5. **Declarative `@DisplayName`**: Add `@DisplayName` on test methods describing the *behavior contract*. When the test fails, the implementer of a future fix or refactor should learn from the displayed name exactly which contract they broke, without having to read the test body.

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

## Security

Read below when hunting for vulnerabilities or validating security issues.

### Scope and Severity

Consult `/doc/THREAT_MODEL.md` to verify that the vulnerability is in scope and to assess its severity.

### Deduplication

Vulnerability must be deduplicated against online github issues and pull requests.

If issue (open or closed) exists for the bug, then it is already known and must not be re-reported.
If the issue significantly downgrades severity or does not recognize security implications of the bug,
then the issue can be updated with new info instead of duplicate report.

If PR exists that fixes the vulnerability, then the bug must not be reported.

### POC

When reporting vulnerabilities always provide proof of concept (POC).

POC should be based on Java code that demonstrates vulnerable usage of kubernetes-client APIs.

POC can include supporting files like YAML configs or shell scripts for setting up environment.

### Patch

Patch must make the POC fail.

Patch must follow rules from CONTRIBUTING.md

Patch should not change signature of public methods and APIs unless strictly neccesary.

Patch must be properly validated:

1. Apply the exact patch to a fresh branch from the target repo default branch.
2. Run `git apply --check` before applying when possible.
3. Run every test command listed in the writeup or issue.
4. Also run tests for every directly changed module, not only the new regression test.
5. If the patch changes generated/builder/config/serialization metadata, run the module’s invariant tests or full module test suite.
6. Before pushing, run `git diff --check` and the repo formatter/checker.
7. If a full CI-equivalent build is too expensive, state exactly what was not run in the PR body.
8. After opening the PR, inspect failed CI logs before classifying failures as flakes.

Verify that patch does not introduce new vulnerabilities.

The patch must be complete: no bypasses that can keep the vulnerability exploitable must be possible.
If the patch is not full and keeps any edge cases or bypasses, then the report must inform about that.
