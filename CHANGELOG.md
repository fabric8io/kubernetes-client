## CHANGELOG

### 6.2-SNAPSHOT

#### Bugs
* Fix #4369: Informers will retry with a backoff on list/watch failure as they did in 5.12 and prior.
* Fix #4350: SchemaSwap annotation is now repeatable and is applied multiple times if classes are used more than once in the class hierarchy.

#### Improvements
* Fix #4348: Introduce specific annotations for the generators
* Fix #4365: The Watch retry logic will handle more cases, as well as perform an exceptional close for events that are not properly handled.  Informers can directly provide those exceptional outcomes via the SharedIndexInformer.stopped CompletableFuture.
* Fix #4396: Provide more error context when @Group/@Version annotations are missing
* Fix #4384: The Java generator now supports the generation of specific annotations (min, max, pattern, etc.), as defined by #4348

#### Dependency Upgrade
* Fix #4243: Update Tekton pipeline model to v0.39.0
* Fix #4243: Update Tekton triggers model to v0.20.2
* Fix #4383: bump snakeyaml from 1.30 to 1.31

#### New Features
* Feat: add annotation @PreserveUnknownFields for marking generated field have `x-kubernetes-preserve-unknown-fields: true` defined

#### _**Note**_: Breaking changes in the API
* Fix #4350: SchemaSwap's fieldName parameter now expects a field name only, not a method or a constructor.
* Module `io.fabric8:tekton-model-triggers` which contained Tekton triggers v1alpha1 model has been removed. We have introduced separate modules `io.fabric8:tekton-model-v1alpha1` and `io.fabric8:tekton-model-v1beta1` for Tekton triggers v1alpha1 and v1beta1 apigroups respectively. Users who are using `io.fabric8:tekton-client` dependency directly should be unaffected by this change.
* Fix #4384: javax.validation.* annotations are no longer added by the Java generator.

### 6.1.1 (2022-09-01)

#### Bugs
fix #4373: NO_PROXY should allow URIs with hyphens ("circleci-internal-outer-build-agent")

### 6.1.0 (2022-08-31)

#### Bugs
* Fix #4109: Templates with parameters can be retrieved from OpenShift
* Fix #4206: KubernetesDeserializer can now handle any valid object. If the object lacks type information, it will be deserialized as a GenericKubernetesResource
* Fix #4247: NO_PROXY with invalid entries throws exception
* Fix #4256: crd-generator-apt pom.xml includes transitive dependencies
* Fix #4294: crd-generator respects JsonIgnore annotations on enum properties
* Fix #4320: corrected leader transitions field on leader election leases
* Fix #4360: JUnit dependencies aren't leaked in child modules

#### Improvements
* Fix #887: added KubernetesClient.visitResources to search and perform other operations across all resources.
* Fix #3960: adding a KubernetesMockServer.expectCustomResource helper method and additional mock crd support
* Fix #4041: adding Quantity.getNumericalAmount with an explanation about bytes and cores.
* Fix #4241: added more context to informer logs with the endpoint path
* Fix #4250: allowing for deserialization of polymorphic unwrapped fields
* Fix #4254: adding debug logging for exec stream messages
* Fix #4259: Java Generator's CR should have Lombok's `@EqualsAndHashCode` with `callSuper = true`
* Fix #4287: added WorkloadGroup for Istio v1alpha3 extension generator
* Fix #4318: implemented LeaderElection releaseOnCancel
* Fix #4359: Remove manual model classes with fields name `class`

#### Dependency Upgrade
* Fix #3967: Update chaos-mesh extension to v2.1.3. Add PodHttpChaos, GCPChaos, BlockChaos and PhysicalMachineChaos.
* Fix #4352: Update Knative model to v0.34.0
* Fix #4356: Update Apache CamelK to v1.9.2
* Fix #4361: Bump Cert-Manager to v1.9.0-beta.1.0.20220829113803-8465f1223efb

#### New Features
* Fix #2271: Support periodic refresh of access tokens before they expire
* Fix #4333: Implement "attach to pod" functionality

#### _**Note**_: Breaking changes in the API
* Fix #4206: The Serialization utility class will throw an Exception, instead of returning null, if an untyped unmarshall method is used on something that lacks type information
* In ChaosMesh Model, some types have been renamed. These are
  - `io.fabric8.chaosmesh.v1alpha1.AwsChaos` => `io.fabric8.chaosmesh.v1alpha1.AWSChaos`
  - `io.fabric8.chaosmesh.v1alpha1.IoChaos` => `io.fabric8.chaosmesh.v1alpha1.IOChaos`
  - `io.fabric8.chaosmesh.v1alpha1.PodIoChaos` => `io.fabric8.chaosmesh.v1alpha1.PodIOChaos`

### 5.12.3 (2022-07-27)

#### Bugs
* Fix #3969: relist will not trigger sync events
* Fix #4049: properly populate exception metadata with resource information if available
* Fix #4222: backport of #4082 - to not process events until the cache is complete
* Fix #4246: KubernetesClientException is swallowed in LeaderElector
* Fix #4295: Configure SnakeYaml to ignore converting timestamps to Date objects

### 6.0.0 (2022-07-13)

#### Bugs
* Fix #2811: Approve/Reject CSR not supported in v1beta1 CertificateSigningRequest API
* Fix #4216: Update metadata when `replaceStatus()` is called
* Fix #4217: patchStatus doesn't increment metadata.generation field in Kubernetes Mock Server (CRUD)
* Fix #4234: corrected the skip method for base64 inputstream

#### Improvements
* Fix #3227 : Move `config.openshift.io` apiGroup resources out of `openshift-model/`
* Fix #4006: Remove outdated shared test classes in `kubernetes-client/` and `openshift-client/` modules

### 6.0.0-RC1 (2022-06-13)

#### Bugs
* Fix #2860: ensure that lockexceptions won't inhibit notification
* Fix #3300: addressed race connection with watch reconnects
* Fix #3745: the client will throw better exceptions when a namespace is not discernible for an operation
* Fix #3832 #1883: simplifying the isHttpsAvailable check
* Fix #3990: Throw exception when `HasMetadata` is used in `resources(...)` API
* Fix #4081: moving Versionable.withResourceVersion to a method on WatchAndWaitable and removing Waitable from the return type
* Fix #4106: removed listing from projectrequests
* Fix #4140: changed StatefulSet rolling pause / resume to unsupported.  Also relying on default rolling logic to Deployments and StatefulSets
* Fix #4139: status changes don't increment metadata.generation field
* Fix #4149: port forwarding can accept both blocking and non-blocking channels
* Fix #4171: allowing any object in clone

#### Improvements
* Fix #1285: removed references to manually calling registerCustomKind
* Fix #2207: added LeaderElector.start to provide a CompletableFuture for easy cancellation
* Fix #3334: adding basic support for server side apply.  Use patch(PatchContext.of(PatchType.SERVER_SIDE_APPLY), service), or new PatchContext.Builder()withPatchType(PatchType.SERVER_SIDE_APPLY).withForce(true).build() to override conflicts
* Fix #3486: using a common jsonschema2pojo annotator - see the migration guide for possible changes to extension models
* Fix #3625: adds default maps to mostly prevent the need for null checks on things like annotations and labels
* Fix #3758: VersionInfo in KubernetesMockServer can be overridden
* Fix #3806: Remove `setIntVal`, `setStrVal`, `setKind` setters from `IntOrString` class to avoid invalid combinations
* Fix #3852: Deserializing kamelets fails with UnrecognizedPropertyException
* Fix #3889: remove piped stream for file download
* Fix #3968: SharedIndexInformer.initialState can be used to set the store state before the informer starts
  SharedIndexInformer allows for the addition and removal of indexes even after starting, and you can remove the default namespace index if you wish.
  And Store.getKey can be used rather than directly referencing static Cache functions.
* Fix #3969: relist will not trigger sync events
* Fix #4065: Client.getAPIResources("v1") can be used to obtain the core/legacy resources
* Fix #4082: improving informOnCondition to test the initial list instead of individual add events
* Fix #4093: adding a possibility to get a log as an `InputStream` from the `Loggable` resources
* Fix #4142: Added patch() and patch(PatchContext) methods for use with resource and load
* Fix #4146: ManagedKubernetesClient and ManagedOpenShiftClient as delayed OSGi services

#### Dependency Upgrade
* Fix #3788: Point CamelK Extension model to latest released version v1.8.0
* Fix #3813: Handle exit code status messages with pod uploads
* Fix #3947: Point CamelK Extension model to latest released version v1.8.2
* Fix #4031: Update Kubernetes Model to v1.24.0
* Fix #4100: Update Tekton Pipeline Model to v0.35.0

#### New Features
* Fix #3407 #3973: Added resource(item) to directly associate a resource with the DSL.  It can be used as an alternative to Loadable.load when you already have the item
  There is also client.resourceList(...).resources() and client.configMaps().resources() - that will provide a Resource stream.
  This allows you to implement composite operations easily with lambda: client.secrets().resources().forEach(r -> r.delete());
* Fix #3472 #3587: Allowing for customization of the Informer store/cache key function and how state is stored. See BasicItemStore and ReducedStateItemStore and the SharedIndexInformer.itemStore function
* Fix #3855: Created a new kubernetes-httpclient-jdk module with an HttpClient implementation based on the Java HttpClient
* Fix #3922: added Client.supports and Client.hasApiGroup methods
* Fix #3966: KubernetesMockServer has new methods - unsupported and reset - to control what apis are unsupported and to reset its state
* Fix #4112: Added TtyExecErrorable.terminateOnError to produce an exceptional outcome to the exitCode when a message is seen on stdErr
* Fix #3854: Camel-K: Missing method for manipulating KameletBindings
* Fix #4117: Created new kubernetes-junit-jupiter module, adds a JUnit5 extension for Kubernetes
* Fix #4180: Created a new kubernetes-httpclient-jetty module with an HttpClient implementation based on Eclipse Jetty

#### _**Note**_: Breaking changes in the API
Please see the [migration guide](doc/MIGRATION-v6.md)

### 5.12.2 (2022-04-06)

#### Bugs
* Fix #3582: SSL truststore can be loaded in FIPS enabled environments
* Fix #3797: Implement SchemaSwap; generate CRD from model not owned
* Fix #3811: Reintroduce `Replaceable` interface in `NonNamespaceOperation`
* Fix #3818: adding missing throws to launderThrowable
* Fix #3848: Supports Queue (cluster) API for Volcano extension
* Fix #3859: refined how a deserialization class is chosen to not confuse types with the same kind
* Fix #3880: Synchronize access to map in KubernetesCrudDispatcher
* Fix #3936: Kubernetes Mock Server .metadata.generation field is an integer
* Fix #3957: Lister `onOpen` should be called before marking the connection as open
* Fix #4022: Reintroduce `Deletable` interface in `NonNamespaceOperation`
* Fix #4009: updating readiness to consider 0 replicas

#### _**Note**_:
- `Config#autoConfigure(String context)`: Has been changed to only trigger the autoConfigure method once. Previously, providing a wrong context argument would not be a problem since an initial context-less autoConfigure would have already been invoked to provide a valid initial Config.

### 5.12.1 (2022-02-04)

#### Bugs
* Fix #3786: Deserialize WatchEvents using the specific object type
* Fix #3776: VerticalPodAutoscaler cannot load yaml with "controlledResources"
* Fix #3796: Limit usage of YAML Serializer
* Fix #3772: `edit()` should not be allowed as a NonNamespaceOperation
* Fix #3477: Handle exit code status messages with pod uploads

#### _**Note**_:
- `Config#autoConfigure(String context)`: Has been changed to only trigger the autoConfigure method once. Previously, providing a wrong context argument would not be a problem since an initial context-less autoConfigure would have already been invoked to provide a valid initial Config.

### 5.12.0 (2022-01-24)

#### Bugs
* Fix #3683: Handle JsonNode fields by adding x-kubernetes-preserve-unknown-fields
* Fix #3697: addresses response that aren't closed by interceptors that issue new requests
* Fix #3255: adding basic crud mock resourceVersion support - the field will be set and updated, but not utilized by list/watch queries
* Fix #3568: Pod file upload fails if the path is `/`
* Fix #3588: `openshift-server-mock` is not listed in dependencyManagement in main pom
* Fix #3648: `Serialization.unmarshal` fails to deserialize YAML with single document in presence of document delimiter(`---`)
* Fix #3679: output additionalProperties field with correct value type for map-like fields (CRD Generator)
* Fix #3671: HTTP(s) Proxy port is not defaulted or validated
* Fix #3712: properly return the full resource name for resources with empty group
* Fix #3761: Extension Jar packages don't contain the META-INF/jandex.idx index file
* Fix #3763: A Java Long should generate a field of type integer in the CRD
* Fix #3769: Fix for ClassCastException from SchemaFrom
* Fix #3756 prevent modifications by standard operations to user objects

#### Improvements
* Fix #3674: allows the connect and websocket timeouts to apply to watches instead of a hardcoded timeout
* Fix #3651: Introduce SchemaFrom annotation as escape hatch (CRD Generator)
* Fix #3587: adding inform support for limit/batch fetching
* Fix #3734: extract static finalizer validation method

#### Dependency Upgrade
* Fix #3637: Update Fabric8 Kubernetes Model to v1.23.0
* Fix #3670: Point CamelK Extension model to latest released version v1.7.0
* Fix #3725: Bump sundrio to v0.50.3

#### New Features
* Fix #3721: Add support for uploading file via InputStream
* Fix #3234: Allow specifying specific localhost while port-forwarding
* Fix #3506: Add support for Open Cluster Management extension

### 5.10.2 (2022-01-07)

#### Bugs
* Fix #3653: SnakeYAML uses only standard Java types

### 5.11.2 (2022-01-05)

#### Bugs
* Fix #3653: SnakeYAML uses only standard Java types
* Fix #3697: addresses response that aren't closed by interceptors that issue new requests

### 5.8.1 (2022-01-05)

#### Bugs
* Fix #3653: SnakeYAML uses only standard Java types

### 5.7.4 (2022-01-05)

#### Bugs
* Fix #3653: SnakeYAML uses only standard Java types

### 5.4.2 (2022-01-05)

#### Bugs
* Fix #3653: SnakeYAML uses only standard Java types

### 5.3.2 (2022-01-05)

#### Bugs
* Fix #3653: SnakeYAML uses only standard Java types

### 5.1.2 (2022-01-05)

#### Bugs
* Fix #3653: SnakeYAML uses only standard Java types

### 5.0.3 (2022-01-05)

#### Bugs
* Fix #3653: SnakeYAML uses only standard Java types

### 5.11.1 (2021-12-24)

#### Bugs
* Fix #3672: Native image builds of Fabric8 work (commons-codec no longer required)
* Fix #3639: Support for NodeMetrics and PodMetrics informers
* Fix #3662: NodeMetrics should be marked as Cluster scoped resource
* Fix #3686: Ignore fields annotated with JsonIgnore during CRD generation
* Fix #3652: Avoid a StackOverflow and properly fail on cyclic references in CRD generation

### 5.11.0 (2021-12-17)

#### Bugs
* Fix #3538: Update Plural rule to work with Prometheus
* Fix #3555: using the new builder for generic resources
* Fix #3535: ensure clientKeyAlgo is set properly when loading config YAML from `fromKubeconfig`
* Fix #3598: applying cancel to the correct future for waitUntilCondition and waitUntilReady
* Fix #3609: adding locking to prevent long running Watcher methods from causing reconnects with concurrent processing
* Fix #3629: correcting the watch 200/503 exception handling 
* Fix #3606: Template getObjects doesn't throw NPE when objects is null
* Fix #3620: throw a meaningful exception if no kind/plural is on a ResourceDefinitionContext, default plural if possible
* Fix #3636: ensure proper handling of LogWatch closure wrt its streams

#### Improvements
* Fix #3615: opt into bookmarks by default
* Fix #3600: add owner references support to HasMetadata

#### Dependency Upgrade
* Fix #3505: Update OpenShift Model to latest version (4.9.x)

#### New Features
* Fix #3579: Add support for Volcano extension
* Fix #3593: Add support for Istio extension

#### _**Note**_: Breaking changes in the API
* If you do not wish to receive bookmarks, then set ListOptions.allowWatchBookmarks=false - otherwise all Watches will default to requesting bookmarks.  If supported by the api-server, bookmarks will avoid 410 exceptions and keep the watch alive longer.  If you are using the mock framework with explicit uris, you may need to update your expected watch endpoints to include the parameter allowWatchBookmarks=true
* Refactoring #3547: due to an abstraction layer added over okHttp, the following api changes were made:
    * OperationContext withOkHttpClient was removed, it should be needed to be directly called
    * PatchType.getMediaType was replaced with PatchType.getContentType
    * ExecListener no longer passes the okhttp3.Response to onOpen.  onFailure will pass a simplified ExecListener.Response when possible.
    * okhttp3.TlsVersions has been replaced by io.fabric8.kubernetes.client.http.TlsVersion
    * HttpClientUtils.createHttpClient(config, additionalConfig) has been deprecated and now returns an OkHttpClientImpl
    * The client is no longer adaptable to an OkHttpClient, use Client.getHttpClient instead

### 5.10.1 (2021-11-12)

#### Bugs
* Fix #3583: Add KubernetesMockServer accessor to JUnit4 KubernetesServer rules
* Fix #3584: Add GenericKubernetesResourceBuilder to Kubernetes Model Core

### 5.10.0 (2021-11-11)

#### Bugs
* Fix #3408: quote pod upload file paths to support special chars
* Fix #3561: ensure okhttp resources are closed
* Fix #3570: added a setter for additionalProperties for proper builder support

#### Improvements
* Fix #3562: Kubernetes Mock Server improvements
* Fix #3406: Add support for approve/deny CertificateSigningRequests
* Fix #3460: support for deserializing templates with non-string params
* Fix #3574: support for deserialization of properties that don't match the target field's type
* Fix #3511: Improve selectors support in OperationContext

#### Dependency Upgrade
* Fix #3562: Bump MockWebServer

#### New Features
* Fix #3430: Support Vertical Pod Autoscaler

#### _**Note**_: Breaking changes in the API
##### Tools Changes:
- Serialization: Those KubernetesResources that include entries in the additionalProperties Map that override a field
  of the resource instance, will no longer be duplicated. The values present in the additionalProperties Map take
  precedence.

### 5.9.0 (2021-10-14)

#### Bugs
* Fix #3482: sanitizeName now truncate names to be less than 63 chars and makes sure first and last charaters are letters
* Fix #3353: addressing extra quoting in quantity serialization
* Fix #3509: notify reader when something is written in ExecWebSocketListener
* Fix #3501: addressed NPE with default BuildConfig operations

#### Improvements
* Fix #3448 added methods for getting specific version information - `KubernetesClient.getKubernetesVersion`, `OpenShiftClient.getOpenShiftV3Version`, and `OpenShiftClient.getOpenShiftV3Version`
* Fix #3404 supporting generic resources in resource/resourceList with minimal metadata, as well as a new entry point `KubernetesClient.genericKubernetesResources(String apiVersion, String kind)`
* Fix #3390: Make mock server support JSON_MERGE_PATCH
* Fix #2171: Support BOOKMARK (Watcher) events

#### New Features
* Fix #3294: Support fetching APIGroupList
* Fix #3303: Support fetching APIResourceList

#### _**Note**_: Breaking changes in the API
* OpenShiftConfig#openshiftApiGroupsEnabled is deprecated and no longer used.
* OpenShiftConfig#disableApiGroupCheck is used only to determine if a client is adaptable to the OpenShiftClient and is generally only needed in mock scenarios.  It will be set automatically on clients obtained from an openshift mock server.
* `KubernetesClient.getVersion` has been deprecated, please use one of the more specific methods introduced by #3448 - `KubernetesClient.getKubernetesVersion`, `OpenShiftClient.getOpenShiftV3Version`, and `OpenShiftClient.getOpenShiftV3Version`

### 5.8.0 (2021-09-23)

#### Bugs
* Fix #3445: TokenRefreshInterceptor throws when running incluster config
* Fix #3456: io.fabric8:crd-generator README should reference crd-generator-apt instead of now removed crd-generator artifact
* Fix #3384: preventing NPE from being logged with pod execs.
* Fix #3484: Ensuring that the informer isWatching flag is correctly reported

#### Improvements
* Fix #3468: Add method to get non-running `Informer` from context specific dsl
* Fix #3398: Added javadocs explaining the wait parameter
* Fix #3491: Add more metadata to `KubernetesClientException` when possible
* Fix #3465: Allowing for more super class event handlers

#### Dependency Upgrade
  * Fix #3326: Upgrade Kubernetes Model to v1.22.1

### 5.7.3 (2021-09-09)

#### Bugs
* Fix #3433: Extension annotator doesn't generate XxxEditable classes
* Fix #3450: CRD generator fails with ClassCastException in some cases
* Fix #3442: make sure new CRDGenerator instances start with a clean generation context

#### Dependency Upgrade
* Fix #3438: Upgrade Sundrio to 0.50.1

### 5.7.2 (2021-09-02)

#### Dependency Upgrade
* Fix #3441: Revert #3427 bump jandex from 2.3.1.Final to 2.4.0.Final

### 5.7.1 (2021-09-01)

#### Bugs
* Fix #3411: enum values should honor JsonProperty annotations during CRD generation
* Fix #3431: required list properly uses renamed properties during CRD generation
* Fix #3429: KubernetesCrudDispatcher throw ConcurrentModificationException when using WatchEventsListener

#### Improvements
* Fix #3414: Add equals and hashCode implementations for CustomResource
* Fix #3287: Add support for field descriptions in CRD Generator

### 5.7.0 (2021-08-12)

#### Bugs
* Fix #3325: All Cluster Scoped Kubernetes resources should use NonNamespacedOperation
* Fix #3346: https configuration ignored for OpenShiftServer in CRUD mode
* Fix #3347: OpenShiftConfig missing some configurations from provided Config
* Fix #3379: using updateStatus rather than patchStatus in the Raw logic

#### Improvements
* Fix #3390: Make mock server to work again with updateStatus by handling JSON_MERGE_PATCH
* Fix #3316: allow locking deletion to resource version
* Fix #3350: Replace references to impls with interfaces in several places in the the dsl
* Fix #3327: Removed generated ResourceHandlers
* Fix #3349: ensuring that dsl context values always are applied over user ListOptions
* Fix #3372: Add generatePackageSuffix option to Model Generator to allow flexible package names for generated model
* Fix #3336: Add ConversionReview in Kubernetes API Extensions model
* Fix #3367: Let CRDGenerator clients handle output (#3366, #3371)

#### New Features
* Fix #3380: Update chaos-mesh extension to v1.2.3. Add AwsChaos.

#### _**Note**_: Breaking changes in the API
##### DSL Changes:
- #3327 DSL methods mentioning customResources have been deprecated: `KubernetesClient.customResources`, `SharedIndexInformerFactory.sharedIndexInformerForCustomResource`.  See replacement resources and sharedIndexInformerFor methods instead.  Also `CustomeResourceDefinitionContext` has been replaced by `ResourceDefinitionContext` - for example in `KubernetesClient.genericKubernetesResources`.
- #3358 DSL return type replacements - `NamespacedCreateOnlyResourceOperationsImpl` has been replaced by `NamespacedInOutCreateable`, `ImageSignatureOperationsImpl` has been replaced by `NameableCreateOrDeleteable`
- #3364 `VisitFromServerGetWatchDeleteRecreateWaitApplicable` now implements `Editable` to replace the `Visitable` methods.  `ApplicableAnd` and `Recreatable` have also been deprecated.
- #3386 `KubernetesClient.customResource(CustomResourceDefinitionContext)` has been deprecated.  Please use the GenericKubernetesResource via `KubernetesClient.genericKubernetesResource(ResourceDefinitionContext)`

### 5.6.0 (2021-07-21)

#### Bugs
* Fix #3304: Prevent NPE in after informer stop
* Fix #3083: CertificateException due to PEM being decoded in CertUtils
* Fix #3295: Fix wrong kind getting registered in KubernetesDeserializer in SharedInformerFactory
* Fix #3318: Informer relist add/update should not always be sync events
* Fix #3328: Allow for generic watches of known types
* Fix #3240: MicroTime serialises incorrectly; add custom serializer/deserializer for MicroTime
* Fix #3329: Moved the parsing of resource(String) to the common base client
* Fix #3330: Added usage of the openshift specific handlers for resource(String/HasMetadata) to pickup the right Readiness

#### Improvements
* Fix #3285: adding waiting for list contexts `Informable.informOnCondition`
* Fix #3284: refined how builders are obtained / used by HasMetadataOperation
* Fix #3314: Add more detailed information about what is generated by the CRD generator
* Fix #3307: refined the support for `Readiable.isReady`
* Fix #2887: Create Docker Registry secrets
* Fix #3314: add detailed information on CRD generation

#### Dependency Upgrade
* Fix #3290: Update Tekton Pipeline Model to v0.25.0

#### New Features
* Fix #3291: Retrying the HTTP operation in case of IOException too
* Fix #2712: Add support for watching logs in multi-container Controller resources (Deployments, StatefulSets, ReplicaSet etc)

#### _**Note**_: Breaking changes in the API
##### DSL Changes:
- #3307 `Readiable.isReady` returns a boolean rather than a Boolean

### 5.5.0 (2021-06-30)

#### Bugs
* Fix #3064: KubernetesMockServer should not read local `.kube/config` while initializing client
* Fix #3126: a KubernetesClientException will be thrown from patch/replace rather than a null being returned when the item does not exist
* Fix #3121: ServiceOperationImpl replace will throw a KubernetesClientException rather than a NPE if the item doesn't exist
* Fix #3189: VersionInfo contains null data in OpenShift 4.6
* Fix #3190: Ignore fields with name "-" when using the Go to JSON schema generator
* Fix #3144: walking back the assumption that resource/status should be a subresource for the crud mock server, now it will be only if a registered crd indicates that it should be
* Fix #3194: the mock server will now infer the namespace from the path
* Fix #3076: the MetadataObject for CustomResource is now seen as Buildable
* Fix #3216: made the mock server aware of apiVersions
* Fix #3225: Pod metric does not have corresponding label selector variant
* Fix #3243: pipes provided to exec command are no longer closed on connection close, so that client can fully read the buffer after the command finishes.
* Fix #3272: prevent index npe after informer sees an empty list
* Fix #3275: filter related dsl methods withLabel, withField, etc. should not modify the current context.  If you need similar behavior to the previous use `Filterable.withNewFilter`.
* Fix #3271: waitUntilReady and waitUntilCondition should handle resource too old
* Fix #3278: `Waitable` methods should not be available at a list context

#### Improvements
* Fix #3078: adding javadocs to further clarify patch, edit, replace, etc. and note the possibility of items being modified.
* Fix #3149: replace(item) will consult the item's resourceVersion for the first PUT attempt when not specifically locked on a resourceVersion
* Fix #3135: added mock crud support for patch status, and will return exceptions for unsupported patch types
* Fix #3072: various changes to refine how threads are handled by informers.  Note that the SharedInformer.run call is now blocking when starting the informer.
* Fix #3143: a new SharedInformerEventListener.onException(SharedIndexInformer, Exception) method is available to determine which informer could not start.
* Fix #3170: made HttpClientUtils.createHttpClient(Config, Consumer<OkHttpClient.Builder>) public to allow overriding custom http client properties 
* Fix #3202: make pod upload connection and request timeouts configurable
* Fix #3185: Introduce GenericKubernetesResource, used as delegate in RawCustomResourceOperationsImpl
* Fix #3001: WatchConnectionManager logs that provide little information are now logged at a lower level
* Fix #3186: WebSockets and HTTP connections are closed as soon as possible for Watches.
* Fix #2937: Add `SharedInformerFactory#getExistingSharedIndexInformers` method to return list of registered informers
* Fix #3239: Add the `Informable` interface for context specific dsl methods to create `SharedIndexInformer`s.
* Fix #3101: making isWatching a health check for the informer

#### Dependency Upgrade
* Fix #2741: Update Knative Model to v0.23.0

#### New Features
* Fix #3133: Add DSL Support for `authorization.openshift.io/v1` resources in OpenShiftClient
* Fix #3166: Add DSL Support for `machineconfiguration.openshift.io/v1` resources in OpenShiftClient
* Fix #3142: Add DSL support for missing resources in `operator.openshift.io` and `monitoring.coreos.com` apiGroups
* Fix #2565: Add support for CertManager extension
* Fix #3150: Add DSL support for missing resources in `template.openshift.io`, `helm.openshift.io`, `network.openshift.io`, `user.openshift.io` apigroups
* Fix #3087: Support HTTP operation retry with exponential backoff (for status code >= 500)
* Fix #3193:Add DSL support for `autoscaling.openshift.io` resources in OpenShiftClient
* Fix #3209: Add DSL support for PodSecurityPolicySubjectReview, PodSecurityPolicyReview, PodSecurityPolicySelfSubjectReview in `security.openshift.io/v1` apiGroup to OpenShiftClient
* Fix #3207: Add DSL support for OperatorCondition, Operator, PackageManifest in `operators.coreos.com` apiGroup to OpenShiftClient 
* Fix #3201: Add support for `tuned.openshift.io` apiGroup in OpenShiftClient DSL
* Fix #3205: Add DSL support for ConsolePlugin and ConsoleQuickStart in `console.openshift.io` apiGroup
* Fix #3222: Add DSL support for `user.openshift.io/v1` Identity in OpenShiftClient DSL
* Fix #3222: Add DSL support for OpenShift Whereabouts CNI Model `whereabouts.cni.cncf.io` to OpenShiftClient DSL
* Fix #3224: Add DSL support for OpenShift Kube Storage Version Migrator resources in OpenShiftClient DSL
* Fix #3228: Add support for Dynamic informers for custom resources in KubernetesClient
* Fix #3270: Add DSL support for ClusterInterceptors to TektonClient

#### _**Note**_: Breaking changes in the API
##### DSL Changes:
- #3127 `StatusUpdatable.updateStatus` deprecated, please use patchStatus, editStatus, or replaceStatus
- #3239 deprecated methods on SharedInformerFactory directly dealing with the OperationContext, withName, and withNamespace - the Informable interface should be used instead.
- #3271 `Waitable.waitUntilReady` and `Waitable.waitUntilCondition` with throw a KubernetesClientTimeoutException instead of an IllegalArgumentException on timeout.  The methods will also no longer throw an interrupted exception.
  `Waitable.withWaitRetryBackoff` and the associated constants are now deprecated.

##### Util Changes:
- #3197 `Utils.waitUntilReady` now accepts a Future, rather than a BlockingQueue
- #3169 `Utils.shutdownExecutorService` removed in favor of direct usage of shutdownNow where appropriate.  
  The stream pumper related classes were also simplified to utility methods on InputStreamPumper.

### 5.4.1 (2021-06-01)

#### Bugs
* Fix #3181: Properly handling of JsonProperty when generating CRDs
* Fix #3172: Use File.toURI() to create the generated CRD URI
* Fix #3152: Retry only Non-Restful Create-only resources in OpenShiftOAuthInterceptor
* Fix #3189: VersionInfo contains null data in OpenShift 4.6

### 5.4.0 (2021-05-19)

#### Bugs
* Fix #3040: Consistently order printer columns by JSON path to prevent undue changes in generated CRDs
* Fix #3041: Properly output `additionalProperties` field for Maps, output warning for unsupported complex maps
* Fix #3036: Fix file descriptor leak when loading cacerts file
* Fix #3038: Upgrade TLS versions in mock servers to 1.2.
* Fix #3037: Account for JsonProperty annotations when computing properties' name
* Fix #3014: Resync Future is canceled and resync executor is shutdown on informer stop
* Fix #2529: SelfSubjectAccessReview not working with OpenShiftClient
* Fix #2978: Fix SharedInformer NPE on initial requests while syncing
* Fix #2989: serialization will generate valid yaml when using subtypes
* Fix #2991: reduced the level of ReflectWatcher event received log
* Fix #2992: allowing Watch auto-reconnect for shared informers
* Fix #2994: updating the SharedIndexInformer indexer state for a delete event generated by resync
* Fix #2996: Generating CRDs from the API should now properly work
* Fix #3000: Set `no_proxy` in the okhttp builder in case the `proxy_url` is null
* Fix #3011: properly handle enum types for additional printer columns
* Fix #3020: annotations should now properly have their associated values when processing CRDs from the API
* Fix #3016: Use scheduleWithFixedDelay for resync task execution
* Fix #2991: reduced the level of ReflectWatcher event received log
* Fix #3027: fix NPE when sorting events in KubernetesResourceUtil
* Fix #3054:  missing entry for Trigger in TektonTriggersResourceMappingProvider
* Fix #3047: NPE when getting version when there is no build date
* Fix #3024: stopAllRegisteredInformers will not call startWatcher
* Fix #3067: Added a patch(PatchContext, item) operation to be more explicit about patching and diffing behavior
* Fix #3097: refresh token with autoconfigure even if authprovider is null

#### Improvements
* Fix #2788: Support FIPS mode in kubernetes-client with BouncyCastleFipsProvider
* Fix #2910: Move crd-generator tests from kubernetes-itests to kubernetes-tests
* Fix #3005: Make it possible to select which CRD version is generated / improve output
* Fix #3015: Thread interruption in a nominal case (like closing the client) are now logged in debug
* Fix #3057: Removed debug calls for CustomResource during deserialization
* Fix #3050: More enforcement of the informer lifecycle
* Fix #3061: Removed the deltafifo from the informer logic
* Fix #3081: Use apiGroupName in generated package for OpenShiftClient Handler/OperationsImpl classes
* Fix #3089: Allowing patch/edit to infer context from the item
* Fix #3066: Added replaceStatus (PUT), editStatus (JSON PATCH), and patchStatus (JSON MERGE PATCH) methods to support non-locking status updates

#### Dependency Upgrade
* Fix #2979: Update Kubernetes Model to v1.21.0
* Fix #3099: Update Tekton Triggers Model to v0.13.0
* Fix #3118: Update to sundrio 0.40.1

#### New Features
* Fix #2984: Add support for `flowcontrol.apiserver.k8s.io/v1beta1` FlowSchema and PriorityLevelConfiguration
* Fix #2980: Add DSL Support for `apps/v1#ControllerRevision` resource
* Fix #2981: Add DSL support for `storage.k8s.io/v1beta1` CSIDriver, CSINode and VolumeAttachment
* Fix #2912: Add DSL support for `storage.k8s.io/v1beta1` CSIStorageCapacity
* Fix #2701: Better support for patching in KuberntesClient
* Fix #3034: Added a SharedInformer.isRunning method
* Fix #3088: mock server will assume /status is a subresource, and other refinements to match kube behavior
* Fix #3111: Add DSL Support for `config.openshift.io/v1` resources in OpenShiftClient 

#### _**Note**_: Breaking changes in the API
##### DSL Changes:
- `client.batch().jobs()` deprecated, suggestion to move to `client.batch().v1().jobs()`
- `client.batch().cronjobs()` deprecated, suggestion to move to `client.batch().v1().cronjobs()` or `client.batch().v1beta1().cronjobs()`
- `client.policy().podSecurityPolicies()` deprecated, suggestion to move to `client.policy().v1beta1().podSecurityPolicies()`
- `client.policy().podDisruptionBudget()` deprecated, suggestion to move to `client.policy().v1().podDisruptionBudget()` or `client.policy().v1beta1().podDisruptionBudget()`

##### Model Changes:
- Classes in `io.fabric8.kubernetes.api.model.batch` have been moved to `io.fabric8.kubernetes.api.model.batch.v1` and `io.fabric8.kubernetes.api.model.batch.v1beta1`
- Classes in `io.fabric8.kubernetes.api.model.policy` have been moved to `io.fabric8.kubernetes.api.model.policy.v1` and `io.fabric8.kubernetes.api.model.policy.v1beta1`

### 5.3.1 (2021-04-26)

#### Bugs
* Fix #2991: reduced the level of ReflectWatcher event recieved log
* Fix #2992: allowing Watch auto-reconnect for shared informers
* Fix #2994: updating the SharedIndexInformer indexer state for a delete event generated by resync
* Fix #2910: Move crd-generator tests from kubernetes-itests to kubernetes-tests
* Fix #3005: Make it possible to select which CRD version is generated / improve output
* Fix #3011: properly handle enum types for additional printer columns
* Fix #3020: annotations should now properly have their associated values when processing CRDs from the API

### 4.13.3 (2021-04-22)

#### Bugs
* Fix: Set no_proxy in the okhttp builder in case the proxy_url is null
* Fix #3027: fix NPE when sorting events in KubernetesResourceUtil

### 5.3.0 (2021-04-08)

#### Bugs
* Fix #2620: Add support for `config.openshift.io/v1` Ingress
* Fix #2784: Not able to deserialize ClusterServiceVersion
* Fix #2935: CRD generator no longer treat enum values as properties (performance)
* Fix #2812: SharedIndexInformer EventHandler sees double updates at resync interval
* Fix #2937: SharedInformerFactory#getExistingSharedIndexInformer returns null when @Kind is configured
* Fix #2924: Creating a CustomResourceInfo from a class doesn't result in the expected information
* Fix #2967: Copy to/from pods: fixed error message; removed debug output
* Fix #2923: Edit a CustomResource should result in a patch

#### Improvements
* Fix #2950: RawCustomResourceOperationsImpl should also work with standard resources
* Fix #2938: Make it possible to manage Tekton Triggers directly
* Fix #2921: Kubernetes server mock will generate missing metadata fields
* Fix #2946: Kubernetes server mock watch will generate initial `ADDED` events
* Fix #2925: Add CustomResource.getShortNames(Class) method

#### Dependency Upgrade
* Fix #2971: Upgrade to sundrio 0.30.0

#### New Features
* Fix #2837: Add Support for `events.k8s.io` APIGroup DSL
* Fix #2854: Introduce CamelK extension

### 5.2.1 (2021-03-16)

#### Bugs
* Fix #2905: NullPointerException when attempting to generate non-parameterized CustomResources
* Fix #2900: Improve handling of complex CR hierarchies, falling back to ignoring status replicas instead of skipping CRD generation altogether

### 5.2.0 (2021-03-12)

#### Bugs
* Fix #2802: NullPointerException in HasMetadataOperation patch/replace when using KubernetesMockServer
* Fix #2828: Remove automatic instantiation of CustomResource spec and status as this feature was causing more issues than it was solving
* Fix #2857: Fix the log of an unexpected error from an Informer's EventHandler
* Fix #2853: Cannot change the type of the Service from ClusterIP to ExternalName with PATCH
* Fix #2855: `.withPropagationPolicy` and `.withGracePeriod` DSL methods can't be combined for Resource API deletion operations
* Fix #2783: OpenIDConnectionUtils#persistKubeConfigWithUpdatedToken persists access token instead of refresh token
* Fix #2871: Change longFileMode to LONGFILE\_POSIX for creating tar in PodUpload, improve exception handling in PodUpload.
* Fix #2746: SharedInformerFactory should use key formed from OperationContext
* Fix #2736: Move CRD annotations to kubernetes-model-common module for greater coherence
* Fix #2836: Make CRD generation usable at runtime, split the generator into api and apt modules, 
  the `crd-generator-apt` artifact corresponding to the previous `crd-generator` artifact, while the
  `crd-generator-api` artifact can be consumed directly to generate the CRDs at runtime.

#### Improvements
* Fix #2781: RawCustomResourceOperationsImpl#delete now returns a boolean value for deletion status
* Fix #2780: Refactor RawCustomResourceOperationsImpl#delete(String)

#### New Features
* Fix #2818: Update chaos-mesh extension to v1.1.1. Add PodIoChaos, JVMChaos, HTTPChaos and DNSChaos.
* Fix #2699: Add support for `@EnableOpenShiftMockClient` for OpenShiftClient
* Fix #2588: Support for Server side dry runs

### 5.1.1 (2021-02-24)

#### Bugs
* Fix #2747: Apiextensions DSL should use NonNamespaceOperation for CustomResourceDefinitions
* Fix #2819: simple enums are now supported when generating CRDs
* Fix #2827: CNFE when initializing CustomResource instances
* Fix #2815: `client.isAdaptable(OpenShiftClient.class)` doesn't work on OpenShift 4
* Fix #2833: Knative model generator is now aligned with all other generators

### 5.1.0 (2021-02-17)

#### Bugs
* Fix #2748: Pass custom headers in kubernetes-client to watch api by modify WatchConnectionManager
* Fix #2745: Filtering Operations can't configure PropagationPolicy
* Fix #2672: WaitUntilReady for Service resource throws IllegalArgumentException

#### Improvements
* Fix #2662: Allow option to containerize Go Model Schema generation builds 
* Fix #2717: Remove edit() methods from RawCustomResourceOperationsImpl taking InputStream arguments
* Fix #2757: add `storage` and `served` to `Version` annotation
* Fix #2759: add `ShortNames` annotation to specify short names for CRD generation
* Fix #2694: Remove deprecated methods from KubernetesClient DSL
* Fix #2716: Add a property to disable BackwardCompatibilityInterceptor

#### Dependency Upgrade
* Fix #2706: update Tekton Triggers model to v0.11.1
* Fix #2684: Upgrade Kubernetes Model to v1.20.2

#### New Features
* Fix #2702: Add support for discovery.k8s.io/v1beta1 EndpointSlice in KubernetesClient DSL
* Fix #2703: Add support for `certificates.k8s.io` v1 and v1beta1 API in KubernetesClient DSL
* Fix #2708: Update CSI Volume Snapshot API to v1
* Fix #2789: Use thread context class loader instead of `Class.forName`
* Fix #2779: Add DSL support for `scheduling.k8s.io` `v1` and `v1beta1` to SchedulingAPIGroupDSL
* Fix #2776: Preview release of CRD generator based on annotations
  - Classes extending the `CustomResource` class can now be used as the basis for CRD generation
  - Several annotations are available to override the default behavior if it doesn't fit your needs
  - Validation schema is automatically derived from your class' spec implementation (or from the CR
    class, if no spec is present)
  - CRDs are automatically generated at compile-time if you include the `io.fabric8:crd-generator`
    dependency to your project (with the suggested `compile` scope)
  - CRDs are generated for both `v1beta1` and `v1` versions of the specification at this point
  - One CRD manifest is generated per CRD using the CRD name (e.g. `mycrplural.group.example.com`)
    suffixed with the specification version, e.g. `mycrplural.group.example.com-v1.yml`
  - The CRD files are generated in the `target/META-INF/fabric8` directory of your project

#### _**Note**_: Breaking changes in the API
##### DSL Changes:
- `client.settings()` DSL has been removed since PodPreset v1alpha1 API is no longer present in Kubernetes 1.20.x
- `client.customResourceDefinitions()` has been removed. Use `client.apiextensions().v1beta1().customResourceDefinitions()` instead
- `client.events()` has been removed. Use `client.v1().events()` instead
- `client.customResource(...)` method is removed. Use `client.customResources(...)` with CustomResource configuration in annotations inside POJOs

##### Model Changes:
- Classes in `io.fabric8.kubernetes.api.model.scheduling` have been moved to `io.fabric8.kubernetes.api.model.scheduling.v1` and `io.fabric8.kubernetes.api.model.scheduling.v1beta1`
- Classes in `io.fabric8.kubernetes.api.model.admission` have been moved to `io.fabric8.kubernetes.api.model.admission.v1` and `io.fabric8.kubernetes.api.model.admission.v1beta1`
- Classes in `io.fabric8.kubernetes.api.model.certificates` have been moved to `io.fabric8.kubernetes.api.model.certificates.v1` and `io.fabric8.kubernetes.api.model.certificates.v1beta1`
- Classes in `io.fabric8.kubernetes.api.model.events` have been moved to `io.fabric8.kubernetes.api.model.events.v1` and `io.fabric8.kubernetes.api.model.events.v1beta1`

### 4.11.2 (2021-02-09)

#### Bugs
* Fix #2715: CVE-2021-20218 vulnerable to a path traversal leading to integrity and availability compromise

### 4.7.2 (2021-02-09)

#### Bugs
* Fix #2715: CVE-2021-20218 vulnerable to a path traversal leading to integrity and availability compromise

### 5.0.2 (2021-02-08)

#### Bugs
* Fix #2715: CVE-2021-20218 vulnerable to a path traversal leading to integrity and availability compromise

### 4.13.2 (2021-02-05)

#### Bugs
* Fix #2715: CVE-2021-20218 vulnerable to a path traversal leading to integrity and availability compromise

### 5.0.1 (2021-01-27)

#### Bugs
* Fix #2687: RawCustomResourceOperationsImpl ignores config
* Fix #2612: add support for checking latest kubeconfig in Interceptor

#### Improvements

* Fix #2723: Dependency cleanup
 - Remove javax.annotation-api 
 - Remove jaxb-api
 - Remove jackson-module-jaxb-annotations
* Fix #2744: Automatically instantiates spec and status fields on `CustomResource` when possible.
  `initSpec` and `initStatus` methods are also provided to allow for overriding of the default implementation.

#### Dependency Upgrade

* Fix #2723: Upgrade sundrio.version to 0.24.1

### 4.13.1 (2021-01-20)

#### Bugs
* Fix #2734: (Backport #2596) Add buildable ref for container, port and volume

### 5.0.0 (2020-12-30)

#### Bugs
* Fix #2695: fromCustomResourceType should be of type `CustomResource`

### 5.0.0-beta-1 (2020-12-21)

#### Bugs
* Fix #2671: Reliability improvements to watchers
* Fix #2592: ConcurrentModificationException in CRUD KubernetesMockServer
* Fix #2510: Yaml containing aliases rejected due to FasterXML bug
* Fix #2651: SharedInformers should ignore resync on zero resyncPeriod
* Fix #2656: Binding operations can be instantiated

#### Improvements
* Fix #2676: Allow specifying PropagationPolicy when using deleteExisting
* Fix #2678: Adds a convenience method for referring to Cache keys by namespace and name rather than item
* Fix #2665: CustomResourceDefinitionContext.fromCrd support for v1 CustomResourceDefinition
* Fix #2642: Update kubernetes-examples to use apps/v1 Deployment rather than extensions/v1beta1
* Fix #2666: Align SharedIndexInformer API with Custom Resource Improvements

#### New Features
* Fix #2611: Support for Custom Resource and Custom Resource Definitions has been improved
  - New annotations have been introduced for users to specify group, version, singular and plural
    properties for `CustomResource` instances
  - `CustomResource` instances must now be annotated with `@Version` and `@Group` so that the 
    associated information can be automatically computed
  - `HasMetadata` provides default implementations for `getApiVersion` and `getKind` based on the 
    presence (or not) of annotations on the target class
  - Static methods have been introduced on `HasMetadata` and `CustomResource` to encapsulate the 
    logic used to resolve `Kind`, `ApiVersion`, `Group`, `Version`, `Plural`, `Singular` and `CRD Name`
    properties
  - New `v1CRDFromCustomResourceType` and `v1beta1CRDFromCustomResourceType` methods have been 
    introduced on `CustomResourceDefinitionContext` to initialize a `CustomResourceDefinitionBuilder`
    with the information provided by a specific `CustomResource` implementation, making it much 
    easier to create CRDs if you already have defined your custom resource type
  - `CustomResource` is now parameterized by the spec and status types that it uses which further 
    removes boiler plate
* Rename `@ApiVersion` and `@ApiGroup` to simply `@Version` and `@Group`, respectively. This was done
  to unify annotations and also remove potential confusion between values provided to `@ApiVersion` 
  and what is returned by `HasMetadata#getApiVersion`

### 5.0.0-alpha-3 (2020-12-10)

#### Bugs
* Fix #2519: Generated schemas contains a valid meta-schema URI reference (`http://json-schema.org/draft-05/schema#`)
* Fix #2631: Handle null values when getting current context on OIDC interceptors
* Fix #2610: Remove deprecated module kubernetes-model-generator/model-generator-app

#### Improvements
* Fix #2628: Add `isFinalizerValid` method on `HasMetadata` to encapsulate validation logic
* Fix #2640: Edit method accepts Visitors

#### Dependency Upgrade
* Fix #2636: Upgrade sundrio.version to 0.23.0

### 5.0.0-alpha-2 (2020-11-24)

#### Improvements
* Fix #2614: Watcher.onClose has dedicated WatcherException as parameter.

### 5.0.0-alpha-1 (2020-11-18)

#### Bugs
* Fix #2596: Add buildable references for Container, Port and Volume

#### Improvements
* Fix #2571: Eliminated the use of Doneables and simplified the internal DSL implementation.
* Fix #2607: add isMarkedForDeletion and finalizer-related default methods to HasMetadata (@metacosm)
* Fix #2605: Provide a `customResources` alternative that simply accepts the resource type as an argument.

#### New Features
* Fix #2556: Chaos Mesh model based on Chaos Mesh v1.0.1

### 4.13.0 (2020-11-10)

#### Bugs
* Fix #2517: Replace does not work in CRUD mockwebserver
* Fix #2537: Checking for Readiness of DeploymentConfig
* Fix #2300: Remove job extensions/v1beta1 from backward compatibiliy interceptor
* Fix #2514: SharedIndexInformer watches only pods of its own namespace when run in the cluster

#### Improvements
* Fix #2507: Add a test for creating a Job with generateName
* Fix #2509: Reversed order + Add Kubernetes 1.16.0 + OpenShift 4.5.14 to Compatibility matrix
* Add cache in github actions for integration tests

#### Dependency Upgrade
* Fix #2513: Update Kubernetes Model to v1.19.1

#### New Features
* Fix #2531: Allow setting the maximum concurrent requests via system property / environment variable
* Fix #2534: Tekton model based on Tekton Pipeline 0.17.0
* Fix #2574: Add support for Condition type

_**Note**_: Breaking changes in the API
* Tekton Pipeline v1beta1 *sidecars* field from a task step is now a list of `io.fabric8.tekton.pipeline.v1beta1.Sidecar` instead of a list of `io.fabric8.tekton.pipeline.v1beta1.Step`

* `NetworkPolicy` moved to `io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicy` from
  `io.fabric8.kubernetes.api.model.networking.NetworkPolicy`
* Fix #2557: add missing `OpenShiftReadiness.isReadinessApplicable`

### 4.12.0 (2020-10-02)

#### Bugs
* Fix #2442: Wrong resource kind in `ProjectRequestHandler` causes ClassCastException when handling Project resources.
* Fix #2467: OpenShiftClient cannot replace existing resource with API version =! v1
* Fix #2458: Creating new instance of the DefaultKubernetesClient is hanging
* Fix #2474: Config.fromKubeconfig throws NullPointerException
* Fix #2399: Cannot change the type of the Service from ClusterIP to ExternalName
* Fix #2479: KuberentesDeserializer works on OSGi runtime environments
* Fix #2488: Unable to derive module descriptors for kubernetes-model jars

#### Improvements
* Enable user to select custom address and port for KubernetesMockServer
* Fix #2473: Removed unused ValidationMessages.properties
* Fix #2408: Add documentation for Pod log options
* Fix #2141: Decouple OpenShift Model from Kubernetes Client
* Fix #2452: Make Readiness.isReady publicly available from a wrapper method in KubernetesResourceUtil

#### Dependency Upgrade
* Bump Knative Serving to v0.17.2 & Knative Eventing to v0.17.3 

#### New Features
* Fix #2340: Adding support for Knative Eventing Contrib 
* Fix #2111: Support automatic refreshing for expired OIDC tokens
* Fix #2146: Add Support for specifying CustomResourceDefinitionContext while initializing KubernetesServer
* Fix #2314: Fetch logs should wait for the job's associated pod to be ready
* Fix #2043: Support for Tekton Triggers
* Fix #2460: Querying for an event based on InvolvedObject fields

_**Note**_ Minor breaking changes:
* PR #2424 (#2414) slightly changes the API by adding the new `WatchAndWaitable` "combiner" interface.
  Most projects shouldn't require any additional changes.

### 4.11.1 (2020-09-02)

#### Bugs
* Fix #2445: ConfigMap and other resources are replaced

### 4.11.0 (2020-08-26)
#### Bugs
* Fix #2373: Unable to create a Template on OCP3
* Fix #2308: Fix kubernetes client `Config` loading KUBECONFIG with external authentication command
* Fix #2316: Cannot load resource from stream without apiVersion
* Fix #2354: Fix NullPointerException in ResourceCompare when no resource is returned from fromServer.get()
* Fix #2389: KubernetesServer does not use value from https in crud mode
* Fix #2306: Make KubernetesServer CRUD mode work with informers
* Fix #2418: CertificateSigningRequest doesn't implement Namespaced
* Fix #2265: InAnyNamespace uses invalid api endpoint for SelfSubjectAccessReviews
* Fix #2404: Readiness.isReady doesn't handle extensions/v1beta1 Deployment
* Fix #2389: KubernetesServer JUnit rule ignores value of https when using crud mode

#### Improvements
* Fix #2331: Fixed documentation for namespaced informer for all custom types implementing `Namespaced` interface
* Fix #2406: Add documentation for serializing resources to YAML
* Fix #2414: Allow withResourceVersion() to be followed by waitUntilCondition(), enabling recovery from HTTP 410 GONE errors.

#### Dependency Upgrade
* Fix #2360: bump mockito-core from 3.4.0 to 3.4.2
* Fix #2355: bump jandex from 2.1.3.Final to 2.2.0.Final 
* Fix #2353: chore: bump workflow action-setup versions + kubernetes to 1.18.6
* Fix #2292: Update createOrReplace to do replace when create fails with conflict
* Fix: Bump SnakeYaml to version 1.26 (as required for OSGi bundle for jackson-dataformat-yaml)
* Fix #2401: bump maven-resources-plugin from 3.1.0 to 3.2.0
* Fix #2405: bump mockito-core from 3.4.4 to 3.5.0

#### New Features
* CSI Volume Snapshot extension
* Fix #2311: Add Support for creating bootstrap project template
* Fix #2287: Add support for V1 and V1Beta1 CustomResourceDefinition
* Fix #2319: Create Config without using auto-configure functionality or setting env variables
* Fix #2284: Supports create and run a particular image in a pod operation using client
* Fix #2321: Add Support for new resources in OpenShift Model

_**Note**_: Some classes have been moved to other packages:
- CustomResourceDefinition has been moved to `io.fabric8.kubernetes.api.model.apiextensions.v1` and `io.fabric8.kubernetes.api.model.apiextensions.v1beta1`
- SubjectAccessReview, SelfSubjectAccessReview, LocalSubjectAccessReview and SelfSubjectRulesReview have been moved to `io.fabric8.kubernetes.api.model.authorization.v1` and `io.fabric8.kubernetes.api.model.authorization.v1beta1`
- `io.fabric8.tekton.pipeline.v1beta1.WorkspacePipelineDeclaration` is now `io.fabric8.tekton.pipeline.v1beta1.PipelineWorkspaceDeclaration`

### 4.10.3 (2020-07-14)
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
* Fix #2342: watchLogs for deployment is broken
* Fix #2309: Move HasMetadataComparator to exported package

#### Improvements
* Fix #2233: client.service().getUrl(..) should be able to fetch URL for ClusterIP based services
* Fix #2278: Added type parameters for KubernetesList in KubernetesClient + test verifying waitUntilCondition **always** retrieves resource from server
* Fix #2336: Test and fix for the wrong "Kind" declared on KubernetesListHandle
* Fix #2320: Added JUnit5 extension for mocking KubernetesClient in tests using @EnableKubernetesMockClient
* Fix #2332: Added PodExecOptions model
* Improve error handling on stream closing errors in S2I binary builds(#2032)
* Fix #2288: Adds configurable serializers and deserializers to json schema codegen

#### Dependency Upgrade
* Fix #2333: bump bouncycastle.version from 1.65 to 1.66
* Fix #2262: bump maven-shade-plugin from 3.2.3 to 3.2.4
* Fix #2261: bump exec-maven-plugin from 1.6.0 to 3.0.0
* Fix #2345: bump mockito-core from 3.3.3 to 3.4.0
* Fix #2260: bump tektoncd pipeline to v0.12.1

#### New Features
* Fix #1868: Add Support for rolling update
* Fix #2266: Support for APIServices in Kubernetes Client
* Fix #2215: `io.fabric8.kubernetes.client.Config` should expose all and the current context defined in kubeconfig

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

_**Note**_:
- Some classes have been renamed:
   - `io.fabric8.tekton.pipeline.v1beta1.WorkspacePipelineDeclaration` is now `io.fabric8.tekton.pipeline.v1beta1.PipelineWorkspaceDeclaration`
- Breaking changes in `KubernetesClient` `customResource()` typed API:
  - We've introduced a major breaking change in customResource(...) typed API. We have introduced a new interface `io.fabric8.kubernetes.api.model.Namespaced` which needs to
    be added to your Custom Types using typed API. For example, for a custom resource named `Animals` which is a [Namespaced](https://kubernetes.io/docs/concepts/overview/working-with-objects/namespaces/) resource; It should be declared like this:
    ```
    public class Animals extends CustomResource implements Namespaced { ... }
    ```
    You can also checkout an example in our test suite for this: [PodSet.java](https://github.com/fabric8io/kubernetes-client/blob/master/kubernetes-tests/src/test/java/io/fabric8/kubernetes/client/mock/crd/PodSet.java#L22)

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
