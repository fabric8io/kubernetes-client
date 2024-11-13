# Migration from 6.x to 7.x

## Contents
- [Java baseline set to Java 11](#java-11)
- [Bouncy Castle is no longer needed](#bouncy-castle)
- [Config changes](#config-changes)
  - [Support for multiple kubeconfig files](#config-changes-multiple-kubeconfig)
- [Model Changes](#model-changes)
  - [kubernetes-model artifact removed](#kubernetes-model-artifact-removed)
  - [Moved packages](#model-changes-moved-packages)
  - [Service Catalog removed (operator.openshift.io)](#service-catalog-removed)
  - [Removed deprecated types for network.openshift.io (OpenShift-SDN-only)](#openshift-network-removed)
  - [Renamed clusterautoscaling to autoscaling](#openshift-clusterautoscaling-to-autoscaling)
  - [Renamed machineconfig to machineconfiguration](#openshift-machineconfig-to-machineconfiguration)
  - [Cert Manager Extension](#cert-manager-extension)
  - [Istio Extension](#istio-extension)
  - [Open Cluster Management Extension](#open-cluster-management-extension)
  - [Open Virtual Network OVN Extension](#ovn-extension)
  - [Tekton Extension](#tekton-extension)
  - [Vertical Pod Autoscaler Extension](#vertical-pod-autoscaler-extension)
- [MockWebServer is based on Vert.x](#mockwebserver-vertx)
  - [OkHttp class replacements](#mockwebserver-okhttp-replacements)
  - [SSL/TLS certificates](#mockwebserver-ssl-tls-certificates)
- [Deprecations and Removals](#deprecations-and-removals)
  - [Apache Felix SCR Annotations removed](#apache-felix-scr-annotations)
  - [OpenShift Server Mock removed](#openshift-server-mock-removed)
  - [Service Catalog API (extension) removed](#service-catalog-extension)


> [!NOTE]
> If you encounter any problems with the following "Migration from 6.x to 7.x" instructions, please let us know by creating an issue in our [GitHub repository](https://github.com/fabric8io/kubernetes-client/issues).
>
> We value your feedback and will work to address your issue promptly.
> Your contribution is essential to improving our documentation, making our migration process smoother for everyone!

## Java baseline set to Java 11 <a href="#java-11" id="java-11"/>

Starting from version 7.0.0, you will need a Java 11+ runtime (using the latest Java release is always encouraged) to use the Fabric8 Kubernetes Client.

It's been more than 10 years since Java 8 was released, and it's no longer supported by most vendors.
We made our best effort to keep the client compatible with Java 8 for as long as possible, but it's time to move on.

## Bouncy Castle is no longer needed <a href="#bouncy-castle" id="bouncy-castle"/>

The Bouncy Castle library is no longer needed as a dependency.
In previous versions, this was an optional dependency needed for Elliptic Curve (EC) Keys.
The Kubernetes client now uses the default Java security provider which should be enough to handle all scenarios.

## Config changes <a href="#config-changes" id="config-changes"/>

The `Config` class has been completely refactored to improve its reliability and usability.

### Support for multiple kubeconfig files <a href="#config-changes-multiple-kubeconfig" id="config-changes-multiple-kubeconfig"/>

The `Config` class now supports the use of multiple kubeconfig files.

Additional references:
- [Organizing Cluster Access Using kubeconfig Files](https://kubernetes.io/docs/concepts/configuration/organize-cluster-access-kubeconfig/)

#### Config API changes

The `Config#getKubeconfigFilename` has changed its name and signature to support multiple files, it's now called `Config#getKubeconfigFilenames` and returns a collection of strings with the obtained paths. 

## Model Changes <a href="#model-changes" id="model-changes"/>

The way we generate the Kubernetes model types/classes has changed.
We've moved from a reflection-based approach from the Go types, to a mixed approach leveraging the OpenAPI schemas that are publicly available.

This change has had several impacts on the generated classes, including:

### kubernetes-model artifact removed <a href="#kubernetes-model-artifact-removed" id="kubernetes-model-artifact-removed"/>

The Maven artifact `io.fabric8:kubernetes-model` has been removed from the project and is no longer published.

This artifact was just an aggregator of _some_ of the Kubernetes model artifacts and had no specific purpose.
It is no longer published, the `io.fabric8:kubernetes-client-api` or `io.fabric8:kubernetes-openshift-uberjar` artifacts should be used instead.

### Moved packages <a href="#model-changes-moved-packages" id="model-changes-moved-packages"/>

Some of the types and packages have been moved to more suiting modules and package names.

- `io.openshift.helm` API group is now part of the `io.fabric8:openshift-model-miscellaneus` module.
- `io.openshift.network` API group is now part of the `io.fabric8:openshift-model-miscellaneus` module.

### Service Catalog removed (operator.openshift.io) <a href="#service-catalog-removed" id="service-catalog-removed"/>

The operator.openshift.io APIs have been deprecated since OpenShift 4.1.
The model types and DSL entry points for these APIs have been removed from the OpenShift client.
- [openshift/api: remove the service catalog crds](https://github.com/openshift/api/pull/596)
- [OpenShift Container Platform 4.1 release notes](https://docs.openshift.com/container-platform/4.1/release_notes/ocp-4-1-release-notes.html#ocp-4-1-service-broker-service-catalog-deprecation)

### Removed deprecated types for network.openshift.io (OpenShift-SDN-only) <a href="#openshift-network-removed" id="openshift-network-removed" />

Some of the types in the `network.openshift.io` API group have been removed.
From the remaining types some of them have been moved to more appropriate modules.
- [openshift/api: clean up openshift-sdn references in the API](https://github.com/openshift/api/pull/1981)

The removed types include:
- ClusterNetwork (`OpenShiftClient.clusterNetworks`)
- EgressNetworkPolicy (`OpenShiftClient.egressNetworkPolicies`)
- HostSubnet (`OpenShiftClient.hostSubnets`)
- NetNamespace (`OpenShiftClient.netNamespaces`)

The moved types include:
- Config (io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config) (`openshift-model-operator`)
- EgressRouter (`openshift-model-operator`)
- HelmChartRepository (`openshift-model-miscellaneous`)
- OperatorPKI (`openshift-model-operator`)
- ProjectHelmChartRepository (`openshift-model-miscellaneous`)

### Renamed clusterautoscaling to autoscaling <a href="#openshift-clusterautoscaling-to-autoscaling" id="openshift-clusterautoscaling-to-autoscaling" />

The module `openshift-model-clusterautoscaling` has been renamed to `openshift-model-autoscaling` to match the API group name.

The package has also been renamed from `io.fabric8.openshift.api.model.clusterautoscaling` to `io.fabric8.openshift.api.model.autoscaling`.

The OpenShiftClient DSL entry-point has also been renamed from `OpenShiftClient.clusterAutoscaling()` to `OpenShiftClient.openShiftAutoscaling()`.

### Renamed machineconfig to machineconfiguration <a href="#openshift-machineconfig-to-machineconfiguration" id="openshift-machineconfig-to-machineconfiguration" />

The module `openshift-model-machineconfig` has been renamed to `openshift-model-machineconfiguration` to match the API group name.

The package has also been renamed from `io.fabric8.openshift.api.model.machineconfig` to `io.fabric8.openshift.api.model.machineconfiguration`.

The OpenShiftClient DSL entry-point remains the same: `OpenShiftClient.machineConfigurations()`.

### Cert Manager Extension <a href="#cert-manager-extension" id="cert-manager-extension"/>

The deprecated Alpha and Beta model types have been removed.
This means that the `io.fabric8:cert-manager-model-v1alpha2`, `io.fabric8:cert-manager-model-v1alpha3`, and `io.fabric8:cert-manager-model-v1beta1` modules are no longer available.

The module `io.fabric8:cert-manager-model-v1` has been renamed to `io.fabric8:cert-manager-model`.

### Istio Extension <a href="#istio-extension" id="istio-extension"/>

All the model modules for the Istio extension have been merged into a single module `io.fabric8:istio-model`.
You will be able to find the packages from `io:fabric8:istio-model-v1alpha3` and `io:fabric8:istio-model-v1beta1` in the new module artifact.

Many of the classes have also been moved to a nested `api` package following the Go types structure.
The following packages are now available:
- `io.fabric8.istio.api.api.meta.v1alpha1`
- `io.fabric8.istio.api.api.type.v1beta1`
- `io.fabric8.istio.api.api.analysis.v1alpha1`
- `io.fabric8.istio.api.api.extensions.v1alpha1`
- `io.fabric8.istio.api.api.networking.v1alpha3`
- `io.fabric8.istio.api.api.networking.v1beta1`
- `io.fabric8.istio.api.api.security.v1alpha1`
- `io.fabric8.istio.api.api.security.v1beta1`
- `io.fabric8.istio.api.api.telemetry.v1alpha1`

### Open Cluster Management Extension <a href="#open-cluster-management-extension" id="open-cluster-management-extension"/>

All the model modules for the Open Cluster Management extension have been merged into a single module `io.fabric8:open-cluster-management`.

The following table contains the resulting package changes:

| Old Package                                                                                        | New Package                                                        |
|----------------------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `io.fabric8.openclustermanagement.api.model.agent.v1`                                              | `io.fabric8.openclustermanagement.api.model.agent.v1`              |
| `io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1`                                       | Deprecated and removed                                             |
| `io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1`   | Deprecated and removed                                             |
| `io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.placementrule.v1` | `io.fabric8.openclustermanagement.api.model.apps.v1`               |
| `io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1`                    | `io.fabric8.openclustermanagement.api.model.apps.v1`               |
| `io.fabric8.openclustermanagement.api.model.cluster.v1`                                            | `io.fabric8.openclustermanagement.api.model.cluster.v1`            |
| `io.fabric8.openclustermanagement.api.model.cluster.v1alpha1`                                      | `io.fabric8.openclustermanagement.api.model.cluster.v1alpha1`      |
| `io.fabric8.openclustermanagement.api.model.cluster.v1beta1`                                       | `io.fabric8.openclustermanagement.api.model.cluster.v1beta1`       |
| `io.fabric8.openclustermanagement.api.model.discovery.v1alpha1`                                    | `io.fabric8.openclustermanagement.api.model.discovery.v1alpha1`    |
| `io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta1`        | `io.fabric8.openclustermanagement.api.model.observability.v1beta1` |
| `io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2`        | `io.fabric8.openclustermanagement.api.model.observability.v1beta2` |
| `io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.shared`              | `io.fabric8.openclustermanagement.api.model.shared`                |
| `io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1`                           | `io.fabric8.openclustermanagement.api.model.operator.v1`           |
| `io.fabric8.openclustermanagement.api.model.operator.v1`                                           | `io.fabric8.openclustermanagement.api.model.operator.v1`           |
| `io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1`                    | Deprecated and removed                                             |
| `io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1`              | `io.fabric8.openclustermanagement.api.model.apps.v1`               |
| `io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1`                  | `io.fabric8.openclustermanagement.api.model.policy.v1`             |
| `io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1`             | `io.fabric8.openclustermanagement.api.model.policy.v1beta1`        |
| `io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1`              | `io.fabric8.openclustermanagement.api.model.apps.v1`               |
| `io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1`                               | Deprecated and removed                                             |

In addition, the following DSL entry-points have been removed to adapt the `io.fabric8:open-cluster-management-client` to the new model structure:
- `OpenClusterManagementAppsAPIGroupClient.helmReleases()`
- `OpenClusterManagementAppsAPIGroupClient.applications()`
- `OpenClusterManagementAppsAPIGroupClient.gitOpsClusters()`
- `OpenClusterManagementSearchAPIGroupDSL.searchCustomizations()`
- `OpenClusterManagementSearchAPIGroupDSL.searchOperators()`

### Open Virtual Network OVN Extension <a href="#ovn-extension" id="ovn-extension"/>

The modules and artifacts related to this extension have been renamed:

| Old Artifact Name                             | New Artifact Name       |
|-----------------------------------------------|-------------------------|
| `io.fabric8:open-virtual-networking`          | `io.fabric8:ovn`        |
| `io.fabric8:open-virtual-networking-client`   | `io.fabric8:ovn-client` |
| `io.fabric8:open-virtual-networking-model-v1` | `io.fabric8:ovn-model`  |


### Tekton Extension <a href="#tekton-extension" id="tekton-extension"/>

All the model modules for the Tekton extension have been merged into a single module `io.fabric8:tekton-model`.

The following packages have been moved:

| Old Package                                                              | New Package                                  |
|--------------------------------------------------------------------------|----------------------------------------------|
| `io.fabric8.tekton.pipeline.v1`                                          | `io.fabric8.tekton.v1`                       |
| `io.fabric8.tekton.pipeline.v1alpha1`                                    | `io.fabric8.tekton.v1alpha1`                 |
| `io.fabric8.tekton.pipeline.v1beta1`                                     | `io.fabric8.tekton.v1beta1`                  |
| `io.fabric8.tekton.v1.internal.pipeline.pkg.apis.config`                 | `io.fabric8.tekton.pipeline.pkg.apis.config` |
| `io.fabric8.tekton.v1.internal.pipeline.pkg.apis.pipeline.pod`           | `io.fabric8.tekton.pod`                      |
| `io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.pod`     | `io.fabric8.tekton.pod`                      |
| `io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1beta1` | `io.fabric8.tekton.v1beta1`                  |
| `io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.config`            | `io.fabric8.tekton.pipeline.pkg.apis.config` |
| `io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.pipeline.pod`      | `io.fabric8.tekton.pod`                      |
| `io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.resource.v1alpha1` | `io.fabric8.tekton.v1alpha1`                 |
| `io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.run.v1beta1`       | `io.fabric8.tekton.v1beta1`                  |
| `io.fabric8.tekton.v1beta1.internal.pipeline.pkg.result`                 | `io.fabric8.tekton.pipeline.pkg.result`      |

### Vertical Pod Autoscaler Extension <a href="#vertical-pod-autoscaler-extension" id="vertical-pod-autoscaler-extension"/>

The module `verticalpodautoscaler-model-v1` has been renamed to `verticalpodautoscaler-model`.

The package containing the Vertical Pod Autoscaler classes has also been renamed from `io.fabric8.verticalpodautoscaler.api.model` to `io.fabric8.autoscaling.api.model.v1`.

## MockWebServer is based on Vert.x <a href="#mockwebserver-vertx" id="mockwebserver-vertx"/>

MockWebServer is no longer based on OkHttp, but on Vert.x instead.

### OkHttp class replacements <a href="#mockwebserver-okhttp-replacements" id="mockwebserver-okhttp-replacements"/>

As part of this change, the OkHttp dependency has been completely removed from all the MockWebServer related modules.

The `okhttp3`, `okhttp3.mockwebserver` and `okio` package classes have been replaced by equivalent classes.
The following table contains the mapping of the classes:

| OkHttp Class Name                       | New Class Name                                    |
|-----------------------------------------|---------------------------------------------------|
| `okhttp3.Headers`                       | `io.fabric8.mockwebserver.http.Headers`           |
| `okhttp3.HttpUrl`                       | `io.fabric8.mockwebserver.http.HttpUrl`           |
| `okhttp3.MediaType`                     | `io.fabric8.mockwebserver.http.MediaType`         |
| `okhttp3.Protocol`                      | `io.fabric8.mockwebserver.vertx.Protocol`         |
| `okhttp3.Response`                      | `io.fabric8.mockwebserver.http.Response`          |
| `okhttp3.WebSocket`                     | `io.fabric8.mockwebserver.http.WebSocket`         |
| `okhttp3.WebSocketListener`             | `io.fabric8.mockwebserver.http.WebSocketListener` |
| `okhttp3.mockwebserver.Dispatcher`      | `io.fabric8.mockwebserver.http.Dispatcher`        |
| `okhttp3.mockwebserver.MockResponse`    | `io.fabric8.mockwebserver.http.MockResponse`      |
| `okhttp3.mockwebserver.MockWebServer`   | `io.fabric8.mockwebserver.MockWebServer`          |
| `okhttp3.mockwebserver.QueueDispatcher` | `io.fabric8.mockwebserver.http.QueueDispatcher`   |
| `okhttp3.mockwebserver.RecordedRequest` | `io.fabric8.mockwebserver.http.RecordedRequest`   |
| `okio.Buffer`                           | `io.fabric8.mockwebserver.http.Buffer`            |
| `okio.ByteString`                       | `io.fabric8.mockwebserver.http.ByteString`        |

### SSL/TLS certificates <a href="#mockwebserver-ssl-tls-certificates" id="mockwebserver-ssl-tls-certificates"/>

The MockWebServer will now use self-signed certificates that are generated each time the server is started.
In the prior version, the MockWebServer used a set of hardcoded certificates that were distributed with the `io.fabric8:mockwebserver` module artifact.
If you need the certificates (public and private), you can retrieve them by using the new `MockWebServer#getSelfSignedCertificate` method.

## Deprecations and Removals <a href="#deprecations-and-removals" id="deprecations-and-removals"/>

### Apache Felix SCR annotations removed <a href="#apache-felix-scr-annotations" id="apache-felix-scr-annotations" />

[Apache Felix SCR annotations](https://felix.apache.org/documentation/subprojects/apache-felix-maven-scr-plugin/scr-annotations.html) are not supported anymore by community. Fabric8 Kubernetes Client no longer uses Apache Felix SCR annotations for OSGi
Declarative Services. Fabric8 Kubernetes Client is now using official OSGi annotations instead. If you're using Apache Felix SCR
annotations, you need to switch to [Official OSGi Component annotations](https://docs.osgi.org/javadoc/r6/cmpn/org/osgi/service/component/annotations/package-summary.html).

### OpenShift Server Mock removed <a href="#openshift-server-mock-removed" id="openshift-server-mock-removed"/>

The `io.fabric8:openshift-server-mock` module has been removed from the project after being deprecated for a long time.

The usage of the `@EnableOpenShiftMockClient` annotation should be replaced with the `@EnableKubernetesMockClient` annotation.

The use of the `OpenShiftMockServer` class should be replaced with the `KubernetesMockServer` class.

### Service Catalog API (extension) removed <a href="#service-catalog-extension" id="service-catalog-extension"/>

The Service Catalog API extension has been removed.
The upstream project has been archived since May 6, 2022.
We are no longer supporting it.
