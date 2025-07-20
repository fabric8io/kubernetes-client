# Vert.x 5 Module Design & Implementation Plan

## Overview
Create a clean, well-designed `httpclient-vertx5` module while reverting the existing `httpclient-vertx` module to Vert.x 4 for Quarkus compatibility. This plan documents the complete design and implementation strategy.

## Development Standards & Guidelines

### Code Quality Standards:
1. **Finalize Everything Possible:** All parameters, class variables, and local variables that can be `final` must be `final`
2. **Use Lombok:** Leverage existing Lombok dependency to reduce boilerplate (`@Value`, `@Builder`, `@RequiredArgsConstructor`)
3. **Package-Private by Default:** Use package-private visibility where possible to reduce API surface
4. **Modular Logic:** Each component must stand alone and be independently testable
5. **Test Naming:** Use `@DisplayName("Should do xyz under (optional condition)")` for all tests

### Testing Standards:
1. **Test Only Public Interface:** Unit tests should only test the public methods of a class
2. **Nested Test Classes:** For classes with multiple public methods, use `@Nested` classes named after the method under test
3. **Parameterized Tests:** Use JUnit 5 `@ParameterizedTest` with `junit-jupiter-params` for concise test coverage
4. **Test Structure Example:**
```java
@DisplayName("HttpRequestBuilder")
final class HttpRequestBuilderTest {
    
    @Nested
    @DisplayName("uri")
    final class Uri {
        
        @ParameterizedTest
        @DisplayName("Should accept valid URIs")
        @ValueSource(strings = {"/api/v1/pods", "https://kubernetes.default.svc", "/health"})
        void shouldAcceptValidUris(final String uri) { /* test */ }
        
        @Test
        @DisplayName("Should reject null URI")
        void shouldRejectNullUri() { /* test */ }
    }
    
    @Nested
    @DisplayName("execute")
    final class Execute {
        
        @Test
        @DisplayName("Should return successful result for valid request")
        void shouldReturnSuccessfulResultForValidRequest() { /* test */ }
        
        @ParameterizedTest
        @DisplayName("Should handle HTTP error codes appropriately")
        @ValueSource(ints = {400, 401, 403, 404, 500, 502, 503})
        void shouldHandleHttpErrorCodesAppropriately(final int statusCode) { /* test */ }
    }
}
```

### Design Principles:

**Core Design Principles:**
- **SRP (Single Responsibility Principle):** Does this class or method have one clear reason to change?
- **DRY (Don't Repeat Yourself):** Is any logic or knowledge duplicated?
- **YAGNI (You Aren't Gonna Need It):** Is anything being built prematurely or speculatively?
- **KISS (Keep It Simple, Stupid):** Is there unnecessary complexity?
- **SoC (Separation of Concerns):** Are responsibilities clearly separated?

**OO Design Principles:**
- **OCP (Open/Closed Principle):** Can new behavior be added without modifying existing code?
- **LSP (Liskov Substitution Principle):** Would a subclass or alternative implementation behave correctly?
- **ISP (Interface Segregation Principle):** Are interfaces minimal and tailored to their consumers?
- **DIP (Dependency Inversion Principle):** Does the code depend on abstractions rather than concrete details?

**Pragmatic Principles:**
- **SLAP (Single Level of Abstraction Principle):** Does each method operate at one level of abstraction?
- **Tell, Don't Ask:** Does the code delegate behavior to the right objects, or does it just query data and act on it?
- **POLA (Principle of Least Astonishment):** Is the behavior predictable and intuitive?
- **Composition Over Inheritance:** Am I favoring delegation over deep hierarchies?
- **Law of Demeter:** Am I avoiding reaching through objects to manipulate nested collaborators?

## Phase 1: Create PLAN.md and Revert httpclient-vertx to Vert.x 4

1. **Create PLAN.md:** Persist this complete plan to project root ✅
2. **Revert changes in `httpclient-vertx` module:**
   - Revert `InputStreamReadStream.java` to use old `executeBlocking` API
   - Revert `VertxHttpClient.java`, `VertxHttpClientBuilder.java`, `VertxWebSocket.java`
   - Update `pom.xml` to use Vert.x 4.5.14 (Quarkus-compatible version)
3. **Update root pom.xml:**
   - Add `httpclient-vertx5` module 
   - Add Maven profiles for version selection
   - Add Vert.x 5 dependency management

## Phase 2: Create httpclient-vertx5 with Clean Architecture

### Module Structure:
```
httpclient-vertx5/
├── pom.xml
├── src/main/java/io/fabric8/kubernetes/client/vertx5/
│   ├── core/                    # Core domain (SRP)
│   │   ├── ConnectionConfig.java
│   │   ├── RequestSpec.java 
│   │   └── ResponseHandler.java
│   ├── functional/              # Functional utilities (DRY)
│   │   ├── Result.java
│   │   ├── AsyncOperations.java
│   │   └── StreamOperations.java
│   ├── infrastructure/          # Vert.x implementation (DIP)
│   │   ├── VertxConnectionFactory.java
│   │   ├── VertxRequestExecutor.java
│   │   └── VertxStreamHandler.java
│   ├── adapters/               # Kubernetes client adapters (OCP)
│   │   ├── KubernetesHttpClient.java
│   │   └── KubernetesWebSocketClient.java
│   └── builders/               # Fluent builders (KISS)
│       ├── HttpRequestBuilder.java
│       └── WebSocketBuilder.java
```

### Implementation Standards:

**1. Immutable Value Objects with Lombok:**
```java
@Value
@Builder
final class ConnectionConfig {
    @NonNull Duration connectTimeout;
    @NonNull Duration readTimeout;
    ProxyConfig proxy;      // nullable
    @NonNull TlsConfig tls;
}
```

**2. Package-Private Classes:**
```java
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
final class VertxRequestExecutor implements HttpExecutor {
    private final @NonNull Vertx vertx;
    private final @NonNull ConnectionConfig config;
}
```

**3. Functional Error Handling:**
```java
public sealed interface HttpResult<T> 
    permits Success, ClientError, ServerError, NetworkError {
    
    <U> HttpResult<U> map(final Function<T, U> mapper);
    <U> HttpResult<U> flatMap(final Function<T, HttpResult<U>> mapper);
    T orElse(final T defaultValue);
}
```

**4. Fluent API Design:**
```java
@Builder(builderClassName = "Builder", toBuilder = true)
public final class HttpRequestBuilder {
    
    public Builder uri(final String uri) { /* implementation */ }
    public Builder header(final String name, final String value) { /* implementation */ }
    public CompletableFuture<HttpResult<HttpResponse>> execute() { /* implementation */ }
}
```

### Enhanced Testing Standards:

**Complete Test Class Structure:**
```java
@DisplayName("VertxRequestExecutor")
final class VertxRequestExecutorTest {
    
    @Nested
    @DisplayName("execute")
    final class Execute {
        
        @Test
        @DisplayName("Should execute GET request successfully")
        void shouldExecuteGetRequestSuccessfully() { /* test */ }
        
        @ParameterizedTest
        @DisplayName("Should handle different HTTP methods")
        @EnumSource(HttpMethod.class)
        void shouldHandleDifferentHttpMethods(final HttpMethod method) { /* test */ }
        
        @ParameterizedTest
        @DisplayName("Should handle connection timeouts gracefully")
        @ValueSource(longs = {100, 500, 1000, 5000})
        void shouldHandleConnectionTimeoutsGracefully(final long timeoutMs) { /* test */ }
        
        @ParameterizedTest
        @DisplayName("Should retry failed requests when configured")
        @CsvSource({"1,true", "3,true", "0,false", "5,true"})
        void shouldRetryFailedRequestsWhenConfigured(final int retryCount, final boolean shouldSucceed) { /* test */ }
    }
    
    @Nested
    @DisplayName("close")
    final class Close {
        
        @Test
        @DisplayName("Should close Vert.x instance when configured")
        void shouldCloseVertxInstanceWhenConfigured() { /* test */ }
        
        @Test
        @DisplayName("Should not close shared Vert.x instance")
        void shouldNotCloseSharedVertxInstance() { /* test */ }
    }
}
```

## Phase 3: Implementation Steps

1. **Create base module structure and pom.xml**
2. **Implement core value objects (ConnectionConfig, RequestSpec, etc.)**
3. **Build functional utilities (Result, AsyncOperations)**
4. **Create infrastructure layer (VertxConnectionFactory, etc.)**
5. **Implement adapter layer (KubernetesHttpClient)**
6. **Add comprehensive unit tests with nested structure**
7. **Add integration tests**
8. **Performance benchmarking**

## Phase 4: Quality Gates

1. **Code Review Checklist:**
   - All possible variables are `final`
   - Lombok is used appropriately to reduce boilerplate
   - Package-private visibility is preferred
   - Each class has single responsibility
   - All tests use proper `@DisplayName` format
   - Tests only verify public interface
   - Nested test classes for multiple public methods
   - Parameterized tests used where appropriate

2. **Testing Requirements:**
   - Unit test coverage > 90%
   - Integration tests against real Kubernetes
   - Parameterized tests for edge cases using JUnit 5
   - Performance benchmarks vs Vert.x 4 implementation

3. **Documentation:**
   - Migration guide from httpclient-vertx to httpclient-vertx5
   - Performance comparison documentation
   - Usage examples showcasing functional features

## Implementation Progress

- [x] Create PLAN.md
- [ ] Revert httpclient-vertx to Vert.x 4
- [ ] Update root pom.xml 
- [ ] Create httpclient-vertx5 structure
- [ ] Implement core objects
- [ ] Build functional utilities
- [ ] Create infrastructure layer
- [ ] Implement adapters
- [ ] Add unit tests
- [ ] Add integration tests

This plan ensures clean, maintainable code following all specified principles while leveraging the project's existing Lombok and JUnit 5 infrastructure.