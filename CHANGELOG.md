### CHANGELOG

#### 4.0.6
  Bugs
  
    * Fix #1214 : Watch resource versions not correctly tracked resulting in 410 errors on reconnect

  Improvements

    * Chore #1168 : Upgrade to Java 8
    * fix #1197 : Broken withName() method  for CustomResourceDefinition.

  Improvements
    * Fix #1179 : Impersonate-Extra keys may be specified multiple times
    * Fix #1182 : Fixes flaky integration tests.
    * Fix #1200 : Support client authenticator commands like `aws-iam-authenticator`.
    * Fix #1201 : Fix problems with swallowed InterruptedExceptions 

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
