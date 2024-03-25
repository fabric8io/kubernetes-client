# Kubernetes Log4j Lookup

The Kubernetes Log4j Lookup provides a [Log4j Core Lookup](https://logging.apache.org/log4j/2.x/manual/lookups) that
can be used to logs files data specific to the Kubernetes container in which the application is running.

## Usage

In order to use it, you only need to add the following artifact to your Maven dependencies:

```xml

<dependencies>
  <dependency>
    <groupId>io.fabric8</groupId>
    <artifactId>kubernetes-log4j</artifactId>
    <version>${fabric8.version}</version>
    <scope>runtime</scope>
  </dependency>
  ...
</dependencies>
```

The following lookups can be use in a `log4j2.xml` configuration file.

| Supported keys                | Description                                |
|-------------------------------|--------------------------------------------|
| `${k8s:masterUrl}`            | the master URL of the Kubernetes cluster   |
| `${k8s:namespaceId}`          | the id of the namespace                    |
| `${k8s:namespaceName}`        | the name of the namespace                  |
| `${k8s:namespaceAnnotations}` | the annotations of the namespace           |
| `${k8s:namespaceLabels}`      | the labels of the namespace                |
| `${k8s:podId}`                | the id of the pod                          |
| `${k8s:podIp}`                | the IP of the pod                          |
| `${k8s:podName}`              | the name of the pod                        |
| `${k8s:accountName}`          | the name of the pod service account        |
| `${k8s:annotations}`          | the annotations of the pod                 |
| `${k8s:labels}`               | the labels of the pod                      |
| `${k8s:labels.<name>}`        | the value of the `<name>` label of the pod |
| `${k8s:containerId}`          | the id of the container                    |
| `${k8s:containerName}`        | the name of the container                  |
| `${k8s:imageId}`              | the id of the container image              |
| `${k8s:imageName}`            | the name of the container image            |
| `${k8s:host}`                 | the node name of the pod                   |
| `${k8s:hostIp}`               | the IP of the pod                          |

## Configuration

In order to access data from the Kubernetes cluster, the Kubernetes Log4j lookup uses the automatic configuration
procedure of the Fabric8 Kubernetes client.

### Automatic configuration

See [Configuring the client](https://github.com/fabric8io/kubernetes-client/tree/main?tab=readme-ov-file#configuring-the-client)

### Legacy configuration

To ease the transition between the [`log4j-kubernetes`](https://logging.apache.org/log4j/2.x/log4j-kubernetes)
artifact and Fabric8's Log4j lookup, the Kubernetes client can also be configured via one of the [Log4j property
sources](https://logging.apache.org/log4j/2.x/manual/configuration#SystemProperties).

To enable the legacy configuration, the Java System property `kubernetes.log4j.useProperties` must be set to `true`.

The following configuration properties are recognized.

| Log4j Property Name                                                                                           |                Default |                        Description |
|---------------------------------------------------------------------------------------------------------------|-----------------------:|-----------------------------------:|
| `log4j2.kubernetes.client.apiVersion`<br/>`spring.cloud.kubernetes.client.apiVersion`                         |                     v1 |             Kubernetes API Version |
| `log4j2.kubernetes.client.caCertData`<br/>`spring.cloud.kubernetes.client.caCertData`                         |                        |          Kubernetes API CACertData |
| `log4j2.kubernetes.client.caCertFile`<br/>`spring.cloud.kubernetes.client.caCertFile`                         |                        |          Kubernetes API CACertFile |
| `log4j2.kubernetes.client.clientCertData`<br/>`spring.cloud.kubernetes.client.clientCertData`                 |                        |      Kubernetes API ClientCertData |
| `log4j2.kubernetes.client.clientCertFile`<br/>`spring.cloud.kubernetes.client.clientCertFile`                 |                        |      Kubernetes API ClientCertFile |
| `log4j2.kubernetes.client.clientKeyAlgo`<br/>`spring.cloud.kubernetes.client.clientKeyAlgo`                   |                    RSA |       Kubernetes API ClientKeyAlgo |
| `log4j2.kubernetes.client.clientKeyData`<br/>`spring.cloud.kubernetes.client.clientKeyData`                   |                        |       Kubernetes API ClientKeyData |
| `log4j2.kubernetes.client.clientKeyFile`<br/>`spring.cloud.kubernetes.client.clientKeyFile`                   |                        |       Kubernetes API ClientKeyFile |
| `log4j2.kubernetes.client.clientKeyPassPhrase`<br/>`spring.cloud.kubernetes.client.clientKeyPassphrase`       |               changeit | Kubernetes API ClientKeyPassphrase |
| `log4j2.kubernetes.client.connectionTimeout`<br/>`spring.cloud.kubernetes.client.connectionTimeout`           |                    10s |                 Connection timeout |
| `log4j2.kubernetes.client.httpProxy`<br/>`spring.cloud.kubernetes.client.http-proxy`                          |                        |                                    |
| `log4j2.kubernetes.client.httpsProxy`<br/>`spring.cloud.kubernetes.client.https-proxy`                        |                        |                                    |
| `log4j2.kubernetes.client.loggingInterval`</br>`spring.cloud.kubernetes.client.loggingInterval`               |                    20s |                   Logging interval |
| `log4j2.kubernetes.client.masterUrl`<br/>`spring.cloud.kubernetes.client.masterUrl`                           | kubernetes.default.svc |     Kubernetes API Master Node URL |
| `log4j2.kubernetes.client.namespace`<br/>`spring.cloud.kubernetes.client.namespace`                           |                default |               Kubernetes Namespace |
| `log4j2.kubernetes.client.noProxy`<br/>`spring.cloud.kubernetes.client.noProxy`                               |                        |                                    |
| `log4j2.kubernetes.client.password`<br/>`spring.cloud.kubernetes.client.password`                             |                        |            Kubernetes API Password |
| `log4j2.kubernetes.client.proxyPassword`<br/>`spring.cloud.kubernetes.client.proxyPassword`                   |                        |                                    |
| `log4j2.kubernetes.client.proxyUsername`<br/>`spring.cloud.kubernetes.client.proxyUsername`                   |                        |                                    |
| `log4j2.kubernetes.client.requestTimeout`<br/>`spring.cloud.kubernetes.client.requestTimeout`                 |                    10s |                    Request timeout |
| `log4j2.kubernetes.client.rollingTimeout`<br/>`spring.cloud.kubernetes.client.rollingTimeout`                 |                   900s |                    Rolling timeout |
| `log4j2.kubernetes.client.trustCerts`<br/>`spring.cloud.kubernetes.client.trustCerts`                         |                  false |  Kubernetes API Trust Certificates |
| `log4j2.kubernetes.client.username`<br/>`spring.cloud.kubernetes.client.username`                             |                        |            Kubernetes API Username |
| `log4j2.kubernetes.client.watchReconnectInterval`<br/>`spring.cloud.kubernetes.client.watchReconnectInterval` |                     1s |                 Reconnect Interval |
| `log4j2.kubernetes.client.watchReconnectLimit`<br/>`spring.cloud.kubernetes.client.watchReconnectLimit`       |                     -1 |   Reconnect Interval limit retries |

### Usage in Spring Boot

Note that Log4j Core is initialized at least twice by Spring Boot and since the Spring `Environment` is only
available
during the last Log4j initialization Spring properties will only be available to Log4j in the last initialization.
