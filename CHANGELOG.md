## CHANGELOG

### 4.10-SNAPSHOT
#### Bugs
* Fix #2285: Raw CustomResource API createOrReplace does not propagate exceptions from create
* Fix Raw CustomResource API path generation to not having trailing slash
* Fix #2131: Failing to parse CustomResourceDefinition with OpenAPIV3Schema using JSONSchemaPropOr\* fields
* Fix #2297: Resuscitate ProjectRequestHandler in openshift-client
* Fix #2328: Failure in deserialization while watching events
* Fix #2299: Improve error handling of RejectedExecutionException from ExecutorService
* Fix KubernetesAttributesExctractor to extract metadata from unregistered custom resources, such when using Raw CustomResource API 
* Fix #2296: No adapter available for type:interface io.fabric8.kubernetes.client.dsl.V1APIGroupDSL
* Fix #2269: Setting a grace period when deleting resource using `withPropagationPolicy()`

#### Improvements
* Fix #2233: client.service().getUrl(..) should be able to fetch URL for ClusterIP based services
* Fix #2278: Added type parameters for KubernetesList in KubernetesClient + test verifying waitUntilCondition **always** retrieves resource from server
* Fix #2320: Added JUnit5 extension for mocking KubernetesClient in tests using @EnableKubernetesMockClient
* Fix #2332: Added PodExecOptions model

#### Dependency Upgrade

#### New Features
* Fix #1868: Add Support for rolling update
* Fix #2266: Support for APIServices in Kubernetes Client

### 4.10.2 (2020-06-02)
#### Bugs
* Fix #2251: Modify KubernetesDeserializer for handling classes with same name but different apiVersions 
* Fix #2205: Event model classes from core v1 have been lost
* Fix #2226: SharedIndexInformer for non-namespaced resources not working
* Fix #2201: Uberjar doesn't contain model classes anymore
* Fix #2066: Uber Jar includes merged service entry for multiple implementations of the same interface
* Fix #2195: Annotation processors and build time dependencies transitive
* Fix #1760: The bundle version of kubernetes-client is missing ServiceLoader files
* Fix #2218: Uberjar: Package rewrite issues in `META-INF/services`
* Fix #2212: JDK8 always uses http/1.1 protocol (Prevent OkHttp from wrongly enabling http/2)

#### Improvements
* Fix #2199: KubernetesClient#customResources now accepts CustomResourceDefinitionContext
* Adds basic support for Pod Eviction API

#### Dependency Upgrade

#### New Features
* Added DSL support for `admissionregistration.k8s.io/v1beta1` resources
* Add support for Namespaced SharedInformers, fixed probelms with OperationContext argument
* Fix #1821: ListOptions now supported when watching a Kubernetes Resource

### 4.10.1 (2020-05-06)
#### Bugs
* Fix #2189: Change package names of Resource Operation classes in order to avoid duplicates Operation classes

#### Improvements

#### Dependency Upgrade

#### New Features
* Fix #2165: Support for setting ListOptions while listing objects

### 4.10.0 (2020-05-04)
#### Bugs
* Feature #1456: Added Watch support on MockServer in Crud mode
* Fix #2163: fix kubernetes-client not support cert chain
* Fix #2144: CRD's schema Default fields do not handle boolean and are prefixed with Raw keyword
* KubernetesAttributeExtractor: handle possible /status subpath due to using status subresource on crd
* Fix #2124: Raw Watch on CustomResource does not work if name specified

#### Improvements
* Fix #2174: Change log level to warn for multiple `kubeconfig` warning
* Fix #2088: Support networking.k8s.io/v1beta1 alongside extensions/v1beta1
* Fix #2107: Set PropagationPolicy to Background by default
  (_Note: Deletion option `cascading(..)` has been marked as deprecated_)

#### Dependency Upgrade
* Updated Kubernetes Model to v1.18.0
* Fix #2145: Updated OkHttp to v3.12.11

#### New Features
* Fix #2115: Keep tekton v1alpha1 api
* Fix #2002: DSL Support for PodTemplate 
* Fix #2015: Add Support for v1, v2beta1, and v2beta2 apiVersions in case of HorizontalPodAutoscaler

### 4.9.2 (2020-05-19)
#### Bugs
* Fix #2212: JDK8 always uses http/1.1 protocol (Prevent OkHttp from wrongly enabling http/2)

#### Improvements

#### Dependency Upgrade

#### New Features

### 4.9.1 (2020-04-17)
#### Bugs
* Fix #2071: Fixed pvc example issue #2071
* Fix #1109: something drops '-' from Singular/Plural forms of CustomResources
* Fix #1586: Replace of Job should add extra selector property to the resource
* Fix #2034: Quantity.equals mishandles fractions
* Fix #2009: Regression `withoutLabel()` stopped to work
* Fix #2057: Fix jar and osgi bundle generation for extensions
* Fix #2075: KubernetesDeserializer registration for CustomResources
* Fix #2078: watchLog for Deployment and StatefulSet
* Fix #2046: OpenshiftClient getVersion returns null for Openshift ContainerPlatform v4
* Fix #2117: Knative Service.status is always null

#### Improvements
* Fix #1987: Added an example for Task and TaskRun with updated model
* Fix #2019: Added CustomResourceCrudTest
* Fix #2054: JobExample doesn't work
* Fix #2082:  Added filter node metrics via labels
* Generated List classes for Knative implement proper KubernetesResourceList interface
* Modify the dependency management of the generator of kubernetes-model to golang module

#### Dependency Upgrade
* Updated Knative model to v0.13.0
* Updated Tekton Model to v0.11.0

#### New Features

### 4.9.0 (2020-03-12)
#### Bugs

* Fix #2047: Readiness#isReady is unreliable for StatefulSet
* Fix #1247: URL parameters are not escaped.
* Fix #1961: Two SharedInformer issues related to kube-apiserver unavailable and relisting
* Fix #2023: Class RawCustomResourceOperationsImpl can't handle HTTP responses with empty body coming from the k8s 
cluster (Jackson deserialization error was throwed). This kind of response can be returned after executing operations 
like the delete of a custom resource.
* Fix #2017: Incorrect plural form for Endpoints kind
* Fix #2053: Fixed parsing of exponential values. Added multiplication to the amount during parsing exponential values.
* Fix #2058: NullPointerException with upload() websocket failures

#### Improvements

* Fix #2012: osgi: Allow the ManagedKubernetesClient to consume an available OAuthTokenProvider

#### Dependency Upgrade
* Updated Knative model to v0.12.0
* Updated Commons-Compress to v1.20 to avoid https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2019-12402

#### New Features
* Fix #1820: Override Createable.create(T) to avoid generic array creation

### 4.8.0 (14-02-2020)
#### Bugs
* Fix #1847: Remove resource-\*.vm files from \*-client.jar
* Fix #959: Support for double braced `${{ }}` template placeholders
* Fix #1964: Refactor Duration
* Fix #703: Fix NullPointerException in Config.tryKubeConfig
* Fix #2000: Unable to create jobs in OSGi environments

#### Improvements
* Fix #1874: Added unit tests verifying windows line-ends (CRLF) work
* Fix #1177: Added support for OpenID Connect token in kubeconfig

#### Dependency Upgrade
* Update Jackson Bom to 2.10.2
* Fix #1968: Support for PodSecurityPolicies in Kubernetes 1.17

#### New Features
* Fix #1948: LeaderElection Implementation (Lock Implementations: ConfigMap & Lease)


### 4.7.1 (24-01-2020)
#### Bugs
* Fix #1937: `Quantity.getAmountInBytes()` should be able to handle negative exponents
* Fix #1805: Unable to create Template on OCP4

#### Improvements
* Fix #1894: SharedInformer Improvements
* Fix #1963: Use Serialization not a default ObjectMapper in Watch
* Fix #1957: Build Failing on CI due to Central repository moving to HTTPS

#### Dependency Upgrade
* Fix #1962: chore(deps): bump karaf.version from 4.2.7 to 4.2.8
* Fix #1960: chore(deps): bump junit-bom from 5.5.2 to 5.6.0
* Fix #1939: chore(deps): bump sundrio.version from 0.20.0 to 0.21.0

#### New Features
* Fix #1917: Allow user to add custom Headers to client

### 4.7.0 (08-01-2020)
#### Bugs
* Fix #1850: Add option to disable timestamps in build logs on Openshift
* Fix #1902: Fix the usage of reflection, so that `getMetadata` is detected properly
* Fix #1925: Client should always read services from server during replace
* Fix #1486: Creating CRDs with schema validation is broken
* Fix #1707: HorizontalPodAutoscalerSpecBuilder found no metric method
* Fix #885: Quantity doesn't honour the unit
* Fix #1895: Parsing different quantity formats

#### Improvements
* Fix #1880: Remove use of reapers manually doing cascade deletion of resources, leave it upto Kubernetes APIServer
* Test coverage for ServiceCatalog
* Fix #1772: Add Javadocs for KubernetesClient class

#### Dependency Upgrade
* Fix #1889: update tekton from v0.7.0 to v0.9.0
* Fix #1872: Support for kubernetes 1.17

#### New Features
* Fix #417: Support Subresources
* Fix #1548: Allow user to update the status on CustomResources
* Fix #1282: Add Support for fetching Kubernetes metrics
* Fix #1917 Allow user to add custom headers to client

### 4.6.4 (20-11-2019)
#### Bugs
* Fix #1866: fix disabled Integration tests
* Fix #1859 - Pass caller's propagation-policy/cascade options to the underlying replicaset when deleting a deployment

#### Improvements
* Fix #1832: chore: refactor poms and update some dependencies
* SelfSubjectRulesReview test coverage

#### Dependency Upgrade
* Fix #1869: chore(deps): bump maven.surefire.plugin.version from 3.0.0-M3 to 3.0.0-M4
* Fix #1864: chore(deps): bump jackson-bom from 2.10.0 to 2.10.1

#### New Features
* Fix #1041: Support cascading delete on custom resources
* Fix #1765 Ability to upload files to a pod

### 4.6.3 (09-11-2019)
#### Bugs
* Fix #1838: Use the correct apiGroup for Knative in KnativeResourceMappingProvider
* Fix #1856: Prevent NPE loop when deleting locally loaded scaleable resource (e.g. statefulset).
* Fix #1853: Revert #1800 due to the concern pointed out [here](https://github.com/fabric8io/kubernetes-client/pull/1800#issuecomment-549561724)

#### Improvements

#### Dependency Upgrade
* chore(deps): bump maven-jar-plugin from 3.1.2 to 3.2.0
* chore(deps): bump maven-source-plugin from 3.1.0 to 3.2.0
* chore(deps): bump jackson-bom from 2.9.10 to 2.10.0

#### New Feature
* Fix #1188: Support for logs for Jobs

### 4.6.2 (01-11-2019)
#### Bugs
* Fix #1833: Respect the termination grace period from the Kubernetes resource by default
* Fix #1827: Fix `withGracePeriod` and `withPropagationPolicy` return type to safely chain further DSL methods and default GracePeriod to 30s
* Fix #1828: VersionInfo date parsing of year
* Fix #1844: KubernetesDeserializer can now handle ArrayNode.
* Fix #1853: Reverts changes introduced by #1800

#### Improvements
* Cleanup log4j dependency from project

#### Dependency Upgrade

#### New Feature
* Fix #1816: Support for Binding in k8-client dsl

### 4.6.1 (15-10-2019)
#### Bugs
* Fix #1796: Check if BouncyCastle provider is set
* Fix #1724: createOrReplace function does not work properly for Custom defined resources
* Fix #1775: KubernetesList.list().delete(resources) orphanDependents semantics change between 4.1.3 and 4.5.2
* Fix #1803: Missing "/" in request url while using customresource client
* Fix #1789: Create or replace on operation seems broken
* Fix #1782: Informer Deadlock; Fix lock typo in SharedProcessor
* Fix #1607: WaitUntilReady for lists

#### Improvements
* Fix #1797: Utils.waitUntilReady should record the stack trace of the caller before rethrowing an exception
* Add support for filtering labels by EXISTS/NOT_EXISTS via the single argument versions of `.withLabel` and `.withoutLabel`
* Schedule reconnect in case of HTTP_GONE when watching; the rescheduled connect will start from beginning of history by not specifying resourceVersion
* Example added for PortForward.

#### Dependency Upgrade
* Updated Knative Serving to v0.9.90
* Update Tekton to v0.7.0

#### New Feature
* Add support for watch in RawCustomResourceOperations

### 4.6.0 (20-09-2019)
#### Bugs
* Fix #1767: Removed fixed override for Okhttp client's `pingInterval`
* Fix #1758: generation of resource handlers for OpenShift
* Fix #1626: Scaling StatefulSets with waiting seems to fail

#### Improvements

#### Dependency Upgrade
* Updated Kubernetes Model to Kubernetes v1.15.3

#### New Feature
* Fix #1380: Support for ControllerRevision
* Added Template Instance Support
* Fix #1384: Initial draft for SharedInformer support.

### 4.5.2 (14-09-2019)
#### Bugs
* Fix #1759: Portforwarding is broken

#### Improvements

#### Dependency Upgrade

#### New Feature


### 4.5.1 (11-09-2019)

#### Improvements
  * Removed Bean Validation integration

### 4.5.0 (10-09-2019)

#### Bugs
  * Fix #1745: Calling getInputStreamFromDataOrFile function with correct parameter order
  * Fix #1730: Fix failing build on jdk11
  * Fix #1634: Cascade delete can't be overriden
  * Fixed Knative model so that it recognizes Container and Volume types as Buildable.
  * Remove lexicographic resource version check in WatchHTTPManager

#### Improvements
  * Added in kubernetes-server-mock (CRUD) the withoutLabel filter and respective tests
  * Removed @Valid annotation from all model class fields (improves quarkus integration).

#### New Feature
  * Allow user to set a propagation policy on deletion


### 4.4.2 (23-08-2019)
#### Bugs
  * Fix #1706: admissionregistration resources are now parsed correctly
  * Fix #1722: Service port forward are now done in the correct namespace
  * Fixed deserialize of `IntOrString` with correct `Kind` instead of `null`

#### Improvements
  * Test coverage for HorizontalPodAutoscaler
  * Added example for PersistentVolumeClaim
  * Added test coverage for ResourceQuota

#### Dependency Upgrade
  * Fix #1331: Migrated from JUnit 4 to JUnit 5

#### New Feature
  * Service Catalog extension


### 4.4.1 (08-08-2019)
####  Bugs
  * Fix #1690: Endpoints is always pluralized
  * Fix #1684: Fixed URL resolution algorithm for OpenShift resources without API Group name

#### Improvements
  * Fix #1650: Introduced `kubernetes.disable.autoConfig` system property to disable auto configuration in Config
  * Fix #1661: Remove generic parameter from KubernetesResource
  * Improved OpenShiftOperation.wrap method performance
  * RawCustomResourceOperationsImpl#makeCall now closes the created Response object

#### Dependency Upgrade

#### New Feature

### 4.4.0 (05-08-2019)
#### Bugs
  * Fix #1592: Corrected type returned by Config.builder()
  * Fix #1565: CRD's Enums are prefixed with Raw keyword
  * Fixed user/password authentication bug in OpenShift 4
  * Fix #1667: Origin header for watch requests had a port of -1 when no port specified

#### Improvements
   * Test coverage for PersistentVolumeClaim
   * Fix #1589: Move HorizontalPodAutoscaler to autoscaling/v1
   * Fix #1553: Allow to explicitly set non-matching field selectors using `withoutField`
   * Cleaned up kubernetes-model pom.xml
   * Removed deprecated KubernetesKind enum

#### Dependency Upgrade

#### New Feature
  * Knative extension
  * Tekton extension
  * Increased OpenShift 4.x compatibility

### 4.3.1 (19-07-2019)
#### Bugs
  * Fix #1592: Corrected type returned by Config.builder()
  * Set cascade deletion to true in case of list operations
  * Fix #1617: Multiple CA certificates with non-unique Subject DN not loaded
  * Fix #1634: Make map backing KubernetesDeserializer thread-safe

#### Improvements
  * Test coverage for Namespace.
  * Example added for NamespaceQuota
  * Example added for Endpoints.
  * Test coverage for Endpoints.
  * Fix #1589: Move HorizontalPodAutoscaler to autoscaling/v1
  * Fix #1553: Allow to explicitly set non-matching field selectors using withoutField
  * assertNotNull replaced with assertTrue for boolean statements in unit tests
  * Test coverage for PodPreset
  * Added test coverage for PersistentVolume
  * Fix #1290: Added github stale bot.
  * Add type parameter to make CustomResourceList.getItems() return a typed List.

#### Dependency Upgrade
  * Upgrade Jackson to version 2.9.9

#### New Feature
  * Fixes #973: added support for service catalog client
  * Added support for SelfSubjectAccessReview
  * Added support for SelfSubjectRulesReview

### 4.3.0 (10-06-2019)
#### Bugs
  * Fix #1500: exec `redirectingInput` was not correctly setting the input pipe (since 4.2.0).
  * Fix #1507: remove unnecessary OutputStream copying a directory and return the directory object instead the file object when a directory is copied or read
  * Fix #758: Deleting Deployments with `.cascading(true)` creates a new Replica Set
  * Fix #1515: HasMetadataOperation.periodicWatchUntilReady is broken
  * Fix #1550: MutatingWebhookConfigurationOperationsImpl should be a NonNamespaceOperation
  
#### Improvements
  * Added example for raw custom resources.

#### Dependency Upgrade

#### New Feature
  * Fix #1523: Added createOrReplace() method to RawCustomResourceOperations dsl
  * Feature #1374 Add support for resizeChannel in ExecWebSocketListener

### 4.2.2 (17-04-2019)
#### Bugs
  * Fix #1297: wrong result produced when exec in used and params contains '&'. Url string not encoded properly.
  * Fix #1449: System.currentTimeMillis() replaced with System.nanoTime()
  * Fix #1495: avoid runtime dependency on Commons Collections

#### Improvements

#### Dependency Upgrade

#### New Feature

### 4.2.1 (15-04-2019)
#### Bugs
  * Fix #1297: wrong result produced when exec in used and params contains '&'. Url string not encoded properly.
  * Fix #1473: Use correct plural form in OpenshiftRole
  * Fix #1480: The kubernetes-client is not optionally depending on bouncycastle.
  * Fix #1490: Resource could not be loaded
  * Fix #1468: Taking labels into consideration when comparing resources for equality.

#### Improvements
  * Fix #1455: Use SubjectAccessReview and LocalSubjectAccessReview in kubernetes client using subjectAccessReviewAuth()

#### Dependency Upgrade

#### New Feature
  * First Draft of Custom Resource Improvements (#1472)

### 4.2.0 (29-03-2019)
#### Bugs
  * Fix #1387: ValidatingWebhookConfigurationOperationsImpl should be a NonNamespaceOperation
  * Fix #1429: Fixes JsonMappingException: No resource type found for:v1#List when reading a Kubernetes List YAML
  * Fix #760: Api get pod from yaml issue
  * Fix #807: Loading a deployment from server with a config file throws exception

#### Improvements
  * Fix #1425: Preserve labels and fields when using CRD's withResourceVersion()
  * Service DSL now includes methods for port forwarding
  * Introduce file and dir read / copy from pods

#### Dependency Upgrade
  * Upgrade Sundrio to 0.17.2
  * Upgrade to Bean Validation 2.0

#### New Feature

### 4.1.3 (02-03-2019)
#### Bugs
  * Fix nanosecond conversion using waitUntilReady
  * Fix #1008: Use a reasonable buffer size for exec stdin
  * Fix #1005: Loading a template from file and processing it locally by passing parameters map is broken

#### Improvements
  * Fix #1362: store exceptions thrown in port forwarder websocket
  * Generate Jandex index file for faster lookup performance
  * Fix #1361: Relax restrictions on environment variable names
  * Refactor: Use lambdas wherever possible across project
  * Fix #1371: Add an example for Job Controller

#### Dependency Upgrade
  * Bump Snakeyaml to version 1.24

#### New Feature
  * Feature 213: Added require( ) method to Resource object class.
  * Fix #1064: Make Deployments rollable

### 4.1.2
  Bugs

    * Fix #1271: Issue deploying ReplicaSet to extensions/v1beta1

    * Fix #1152: Renamed Kubernetes RBAC resources to use non-prefixed names and renamed Openshift RBAC resources to prefix with Openshift

    * Fix #1218: CustomResourceDefinitions: cascading() causes NoSuchMethodError

    * Fix #1309: Can't get VersionInfo correctly

    * Fix #1332: Unable to use ExecCredentials

    * Fix #1351: NPE IpAddressMatcherTest

  Improvements

    * Updated compatability matrix after model upgrade in README.md

    * Fix #1306: Support `KUBECONFIG` env var with multiple paths

    * Classes implementing KubernetesResourceList has now generic type set.

    * Fix #1348: support `v1beta1` version for `ExecCredentials`

    * Fix #1326: Make CustomResource @Buildable

    * Fix #1354: suppress log warnings that `CustomResourceDefinition`s are still in beta


  Dependency Upgrade

    * Updated jackson to 2.9.8

    * Upgrade okhttp to 3.12.0

  New Feature

    * Fix #1286: Pod Preset Support

    * Fix #1339: oAuth token rotation support

    * Fix #1314: Support for EC Private Keys

  Misc

    * Appended some files to licence check exclusion list.

#### 4.1.1

  Bugs

    * Fix #1239: Fix one case of OkHttp connection leaks

    * Fix #1266: Not setting optional Impersonate-Group results in NPE in ImpersonatorInterceptor

    * Fix #1238: Renamed files with invalid Windows characters

    * Fix #1260: Added Windows support in ConfigTest.honorClientAuthenticatorCommands

    * Fix #579: Add Timestampable interface to PodOperationsImpl/BuildOperationsImpl and set timestamps parameter

    * Fix #1273: customResources can't be used with Cluster scoped CRDs

    * Fix #1228: Closed InputStream in OperationSupport's handleResponse to avoid leak

    * Fix #1280: Fix ExecCredential deserialization in kubeconfig auth

  Improvements

    * Fix #1226 : Extend and move integrations tests

    * Fix #989  : Add support for waitForCondition

    * Fix #1293 : OpenShiftOAuthInterceptor.authorize() should only throw IOException

  Dependency Upgrade

    * Fix #1223: jackson-dataformat-yaml dependency (2.7.7) ageing

    * Fix #1262: Upgrade maven-surefire-plugin to 3.0.0-M1

    * Fix #1272: Upgrade Awaitility to version 3.1.3

    * Fix #1235: Upgrade kubernetes-model to latest kubernetes/Openshift versions


  New Feature
    * Fix #1142: Pagination Support

    * Fix #1234: VolumeNodeAffinity support

    * Fix #1244: Pod Priority Support

    * Fix #1186: Added Support for creating HPA based on custom metrics

#### 4.0.7
  Bugs

    * Fix #1214 : Watch resource versions not correctly tracked resulting in 410 errors on reconnect

  Improvements

    * Fix #1179 : Impersonate-Extra keys may be specified multiple times
    * Fix #1182 : Fixes flaky integration tests.
    * Fix #1200 : Support client authenticator commands like `aws-iam-authenticator`.
    * Fix #1201 : Fix problems with swallowed InterruptedExceptions
    * Chore #1168 : Upgrade to Java 8
    * fix #1197 : Broken withName() method  for CustomResourceDefinition.

  Dependency Upgrade

  New Feature

#### 4.0.4
  Bugs

    * Fix #1180 : DeploymentExamples requires the definition of a selector with match labels

    * Fix #1099 : CustomResourceDefinitions: withResourceVersion() causes NoSuchMethodError

    * Fix #1156 : Watcher does not have correct authentication information in Openshift environment.

    * Fix #1125 : ConfigMap labels are ignored when using mock KubernetesServer

    * Fix #1144 : Get Request with OpenShift Mock Server Not Working

    * Fix #1147 : Cluster context was being ignored when loading the Config from a kubeconfig file

    * Fix #1162 : Deletion of DeploymentConfig now does not fail randomly because of issues related to owner references of the ReplicationController

    * Fix #1165 : Null parameter values when processing a template are now handled properly

    * Fix #1173 : Send response to Callback for exec commands that have no textual feedback

    * Fix #1172 : Use v1beta1 for CronJob

    * Fix #1158: Add support for label selectors in the mock server

  Improvements

    * Added Kubernetes/Openshift examples for client.getVersion()
    * Fix #1126 : Add new option `kubernetes.disable.hostname.verification` / `KUBERNETES_DISABLE_HOSTNAME_VERIFICATION` to disable hostname verification
    * Fix #1178 : Impersonate-Group may be specified multiple times

  Dependency Upgrade

    * Fix #924 : Include kubernetes-model in client BOM with dependencies.

  New Feature

    * Fix #1066 : Add support for Kubernetes RBAC Role and Role Binding
    * Fix #1150: Add support for Kubernetes RBAC Cluster Role and Cluster Role Binding
    * Fix #770: Added Support for CronJob
    * Fix #1140: Provide User Utilities
    * Fix #1139 : Make it easy to get the URL of a service.

#### 4.0.0
  Bugs

    * Fix #1098 : Unable to create LimitRange from yaml
    * Fix #1089 : Query parameters are not correctly processed if set in `masterUrl`
    * Fix #1112 : Append multiple query param in masterUrl
    * Fix #1085 : Impersonate parameters are not configurable for DefaultOpenShiftClient
    * Fix #1106 : Fix typo in crud mode in mockserver

  New Feature

    * Fix #1020 : Support for Kubernetes/Openshift v1.9/v3.9 respectively

  Improvements

    * Fix #1119 : Regression Test are more stable and takes less time to execute

  Dependency Upgrade

    * Kubernetes Model upgraded to 3.0.0 with support for Kubernetes/Openshift v1.9/v3.9 respectively
      Features and Fixes Available
       * Resources according to Kubernetes/Openshift v1.9/v3.9
       * Add support for RBAC Role, Role Binding and Netnamespace in Model
       * KubernetesDeserializer shouldn't pickup mappings from incompatible providers
       * Add all packages in KubernetesDeserializer

  Major Movements and Changes

    * SecurityContextConstraints has been moved to OpenShift client from Kubernetes Client
    * Job dsl is in both `batch` and `extensions`(Extensions is deprecated)
    * DaemonSet dsl is in both `apps` and `extensions`(Extensions is deprecated)
    * Deployment dsl is in both `apps` and `extensions`(Extensions is deprecated)
    * ReplicaSet dsl is in both `apps` and `extensions`(Extensions is deprecated)
    * NetworkPolicy dsl is in both `network` and `extensiosn`(Extensions is deprecated)
    * Storage Class moved from `client base DSL` to `storage` DSL
    * PodSecurityPolicies moved from `client base DSL` and `extensions` to only `extensions`
    * ThirdPartyResource has been removed.

#### 3.2.0
  Bugs
   * Fix #1083 : Mock Kubernetes server only handles core and extensions API groups
   * Fix #1087 : Mock server can't list custom resources
   * Fix #1055 : Unable to log in to cluster when using username and password

  New Feature
   * Support `error` websocket channel - https://github.com/fabric8io/kubernetes-client/pull/1045

  Improvements
   * Do not repeatedly create Config instance in exec - https://github.com/fabric8io/kubernetes-client/pull/1081
   * Determine kubernetes service host and port from environment if available - https://github.com/fabric8io/kubernetes-client/pull/1086
   * Upgraded Kuberneted Model version to 2.1.1
     Features and Fixes Available
      * KubernetesDeserializer can now lookup for resource mappings via ServiceLoader - https://github.com/fabric8io/kubernetes-model/pull/307
      * Add new package to OSGi exports - https://github.com/fabric8io/kubernetes-model/pull/310
      * Add additional types that are needed to support extensions - https://github.com/fabric8io/kubernetes-model/pull/305

#### 3.1.12
  Bugs
   * Fix #1070 : Error parsing openshift json template with the latest version

  New Feature
   * Fix #1048 : Add support for the k8s/openshift version

  Improvements
   * Fixes premature call to watcher onClose

#### 3.1.11
  Bugs
   * Fix #1013 : Kubernetes connection is not getting closed.
   * Fix #1004 : Multiple document handling breaks if "---" found anywhere in the document
   * Fix #1035 : RejectedExecutionException in WatchHTTPManager
   * Impersonation parameters not set in withRequestConfig - https://github.com/fabric8io/kubernetes-client/pull/1037

  Improvements
   * NO_PROXY setting now supports IP ranges so you can specify whole subnet to be excluded from proxy traffic eg. 192.168.0.1/8

#### 3.1.10
  Bugs

  New Feature
   * Added support for StorageClass - https://github.com/fabric8io/kubernetes-client/pull/978
   * Added support for PodSecurityPolicy - https://github.com/fabric8io/kubernetes-client/pull/992
   * The client now warns when using Kubernetes alpha or beta resources - https://github.com/fabric8io/kubernetes-client/pull/1010
   * A Config can now be built from `Config.fromKubeconfig(kubeconfigFileContents)`: https://github.com/fabric8io/kubernetes-client/pull/1029

  Improvements
   * Fixed issue of SecurityContextConstraints not working - https://github.com/fabric8io/kubernetes-client/pull/982
	Note :- This got fixed by fixing model - https://github.com/fabric8io/kubernetes-model/pull/274
  Dependencies Upgrade
