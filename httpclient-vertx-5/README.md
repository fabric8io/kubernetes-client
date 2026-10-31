# Vert.x 5 HTTP Client For Fabric8 Kubernetes Client

The default HTTP client implementation of the Fabric8 Kubernetes Client, based on Vert.x 5.x.
`io.fabric8:kubernetes-client` and `io.fabric8:openshift-client` bring it in transitively, and it's discovered through the `HttpClient.Factory` service loader.

It can't be used together with `kubernetes-httpclient-vertx` (Vert.x 4.x): both need the same `io.vertx` artifacts at different major versions.
See the [8.0 migration guide](../doc/MIGRATION-v8.md#vertx5-httpclient) to switch to Vert.x 4 or to another client.

## Testing

The integration tests in `kubernetes-itests` use this client by default:

```bash
mvn -Pitests -pl kubernetes-itests verify
```

To run them with the legacy Vert.x 4 client instead, activate the `httpclient-vertx-4` profile:

```bash
mvn -Pitests -Phttpclient-vertx-4 -pl kubernetes-itests verify
```
