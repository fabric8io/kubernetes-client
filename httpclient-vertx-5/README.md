# Vert.x 5 HTTP Client For Fabric8 Kubernetes Client

This module provides Vert.x 5.x HTTP client implementation for the Fabric8 Kubernetes Client, featuring improved async handling and WebSocket separation introduced in Vert.x 5.

## Features

- **Vert.x 5.2.0**: Uses latest stable Vert.x 5.x release
- **Async Operations**: Enhanced async HTTP request handling
- **WebSocket Separation**: Vert.x 5's separate HTTP and WebSocket client architecture
- **Backpressure Support**: Built-in flow control for streaming operations
- **Stack-based Recursion Guard**: Memory-safe recursion protection without ThreadLocal

## Usage

Add the dependency to your project:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-httpclient-vertx-5</artifactId>
    <version>${fabric8.version}</version>
</dependency>
```

The HTTP client will be automatically discovered via service loader.

## Testing

### Running Integration Tests

To run integration tests specifically with the Vert.x 5 HTTP client:

```bash
# Run all integration tests with Vert.x 5
mvn -Phttpclient-vertx -Pitests verify -Dtest.httpclient=vertx-5

# Run specific test with Vert.x 5
mvn -Phttpclient-vertx test -Dtest=ConfigMapIT -Dtest.httpclient=vertx-5

# Run WebSocket tests with Vert.x 5  
mvn -Phttpclient-vertx test -Dtest=WatchIT -Dtest.httpclient=vertx-5
```

### Version Validation Test

A special test (`VertxVersionValidationIT`) validates that Vert.x 5.2.0 is actually being used:

```bash
mvn -Phttpclient-vertx test -Dtest=VertxVersionValidationIT -Dtest.httpclient=vertx-5
```

### Dependency Verification

Verify the correct Vert.x version is being used:

```bash
mvn -Phttpclient-vertx dependency:tree | grep vertx
# Should show: vertx-core:jar:5.2.0:compile
```

## Architecture Notes

- **WebSocket Client Separation**: Unlike Vert.x 4, Vert.x 5 uses separate HTTP and WebSocket clients
- **Dependency Management**: This module is the default http client starting from version 8.0.0, for more info see the [migration guide](../doc/MIGRATION-v8.md#vertx5-httpclient)
- **Profile Isolation**: The httpclient-vertx-5 profile ensures no conflicts with default Vert.x 4 usage
