### CHANGELOG

#### 4.2-SNAPSHOT

  Bugs

    * Fix #1297: wrong result produced when exec in used and params contains '&'. Url string not encoded properly.
    * Fix #1449: System.currentTimeMillis() replaced with System.nanoTime()
    * Fix #1495: avoid runtime dependency on Commons Collections

#### 4.2.1

  Bugs
    
    * Fix #1297: wrong result produced when exec in used and params contains '&'. Url string not encoded properly.
    * Fix #1473: Use correct plural form in OpenshiftRole
    * Fix #1480: The kubernetes-client is not optionally depending on bouncycastle.
    * Fix #1490: Resource could not be loaded
    * Fix #1468: Taking labels into consideration when comparing resources for equality.
  
  Improvements
  
    * Fix #1455: Use SubjectAccessReview and LocalSubjectAccessReview in kubernetes client using subjectAccessReviewAuth()
  
  Dependency Upgrade
  

  New Feature
  
    * First Draft of Custom Resource Improvements (#1472)

#### 4.2.0

  Bugs

    * Fix #1387: ValidatingWebhookConfigurationOperationsImpl should be a NonNamespaceOperation
    * Fix #1429: Fixes JsonMappingException: No resource type found for:v1#List when reading a Kubernetes List YAML
    * Fix #760: Api get pod from yaml issue
    * Fix #807: Loading a deployment from server with a config file throws exception

  Improvements

    * Fix #1425: Preserve labels and fields when using CRD's withResourceVersion()
    * Service DSL now includes methods for port forwarding
    * Introduce file and dir read / copy from pods

  Dependency Upgrade

    * Upgrade Sundrio to 0.17.2
    * Upgrade to Bean Validation 2.0

  New Feature

#### 4.1.3

  Bugs

   * Fix #1008: Use a reasonable buffer size for exec stdin
   * Fix #1005: Loading a template from file and processing it locally by passing parameters map is broken

  Improvements

    * Fix #1362: store exceptions thrown in port forwarder websocket
    * Generate Jandex index file for faster lookup performance
    * Fix #1361: Relax restrictions on environment variable names
    * Refactor: Use lambdas wherever possible across project
    * Fix #1371: Add an example for Job Controller

  Dependency Upgrade
    * Bump Snakeyaml to version 1.24

  New Feature
    * Feature 213: Added require( ) method to Resource object class.
    * Fix #1064: Make Deployments rollable

#### 4.1.2
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
