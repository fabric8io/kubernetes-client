# Troubleshooting

## OutOfMemoryError During Build

```bash
export MAVEN_OPTS="-Xmx2g"
mvn clean install
```

## Test Failures with Mock Server

- Ensure tests use the `@EnableKubernetesMockClient` annotation.
- Check that server expectations match actual requests.

## Missing HTTP Client Implementation

When the error says `No HttpClient implementation found`, add an HTTP client
dependency:

```xml
<dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-httpclient-jdk</artifactId>
</dependency>
```

## Missing Model Class

Regenerate model classes from OpenAPI schemas.

```bash
# Preferred
make generate-model

# Direct Maven path when needed
cd kubernetes-model-generator
mvn -Pgenerate clean install
```
