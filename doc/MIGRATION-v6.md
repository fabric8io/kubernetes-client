# Migration from 5.x to 6.x

## Contents:
- [Default Maps](#default-maps)
- [Backwards Compatibility Interceptor](#backwards-compatibility-interceptor)
- [Namespace Changes](#namespace-changes)
- [API/Impl split](#api-impl-split)
- [Deserialization Resolution](#deserialization-resolution)
- [Deprecation Removals](#deprecation-removals)
- [Resource Changes](#resource-changes)
- [lists Removal](#lists-removal)
- [GenericKubernetesClient Removal](#generickubernetesclient-removal)
- [IntOrString Changes](#intorstring-changes)
- [Extension Changes](#extension-changes)
- [Adapt Changes](#adapt-changes)
- [Deprecations](#deprecations)
- [Object sorting](#object-sorting)
- [DSL Interface Changes](#dsl-interface-changes)
- [evict Changes](#evict-changes)
- [Delete Behavior](#delete-behavior)
- [Stream Changes](#stream-changes)

## Default Maps

All Maps in the generated object models, including ObjectMetadata.annotations and labels will also be non-null by default.  A small behavioral difference is that the default value will be omitted from serialization, previously if you did something like: 

```
Pod p = new PodBuilder().withNewMetadata().withLabels(new HashMap()).endMetadata().build();
```
p would serialize with 

```
metadata: 
  labels: {}
```

That empty map will now be omitted - which is the same as the existing behavior for arrays.

## Backwards Compatibility Interceptor

kubernetes.backwardsCompatibilityInterceptor.disable now defaults to true, rather than false.  If you need backwards compatibility support, please set this property to false.

## Namespace Changes

To match the behavior of kubectl the client will now consider any call to inNamespace as the namespace to use regardless of what is on a passed in item.  
Only if the client is left at the default namespace or a call has been made to inAnyNamespace will the item namespace be used.  
This applies to all calls to inNamespace - at the Client, Operation, or Resource level, and for all operations (load, create, delete, withItem, etc.)

The end result is that exceptions refering to mismatched namespaces will no longer be thrown.

Consider the following examples:

```
// inNamespace called at the client level with load
// Prior behavior - exception if item has a namespace that is not monitoring.  
// New behavior - the item namespace is monitoring
this.kubernetesClient.inNamespace("monitoring").configMaps().load(item)...

// inNamespace called at an operation level with load
// Prior behavior - exception if item has a namespace that is not monitoring.  
// New behavior - the item namespace is monitoring
this.kubernetesClient.configMaps().inNamespace("monitoring").load(item)...

// inNamespace called at the client level with resource
// Prior behavior - context namespace is changed to match the item.  
// New behavior - the item namespace is monitoring
this.kubernetesClient.inNamespace("monitoring").resource(item)...

// default namespace call to create
// Prior behavior - exception if item has a namespace that does not match the context.  
// New behavior - item will be created with its namespace, or the default if missing
this.kubernetesClient.configMaps().create(item); 

// default namespace call to load
// Prior behavior - exception if item has a namespace that does not match the context.  
// New behavior - item will be loaded with its namespace, or the default if missing
this.kubernetesClient.configMaps().load(item)...
```

To track the namespace handling at the client level the Config has an additional boolean field defaultNamespace, you may set that to false to have the Client treat subsequent calls as if inNamespace had been called explicitly.

## API/Impl split

This release introduces kubernetes-client-api and openshift-client-api modules.  You may use them as compile dependencies in your application with the respective kubernetes-client and openshift-client as runtime dependencies.  This will keep you compile classpath cleaner of classes and libraries that are not intentionally exposed by the fabric8 client.

If you are directly relying on classes in the -client jars other than DefaultKubernetesClient and DefaultOpenShiftClient, please let us know your usage scenario.  Moving forward we'd like consider all classes in the -client jars internal.

When you rely solely on a compile dependency to the respective -api dependencies you will not be able to use DefaultKubernetesClient nor DefaultOpenShiftClient directly to create your client instances.  You should instead use KubernetesClientBuilder.  Passing a configuration of HttpClient is instead done through builder methods - withConfig and withHttpClientFactory.  For example:

  ```java
  KubernetesClient client = new KubernetesClientBuilder().build();
  ...  
  ```
  ```java
  OpenShiftClient openShiftClient = new new KubernetesClientBuilder().withConfig(new OpenShiftConfigBuilder()...build()).build().adapt(OpenShiftClient.class);
  ...
  ```

### OkHttp HttpClient

The -client dependencies still default to the OkHttp client If you are doing any customization to OkHttp clients directly, you'll need to include the kubernetes-httpclient-okhttp dependency in the compile scope - instead of the default runtime scope

### JDK HttpClient

The JDK client should be considered experimental, please consult the [README](../httpclient-jdk/README.md).

To use it, exclude the kubernetes-httpclient-okhttp dependency and add the kubernetes-httpclient-jdk dependency.

### Package Changes

- Readiness/OpenShiftReadiness moved from client.internal.readiness to client.readiness
- client.utils classes including Base64, CreateOrReplaceHelper, DeleteOrCreateHelper, OptionalDendencyWrapper, etc. are not in the -api jar, they are still in the -client jar under utils.internal.
- Some other effectively internal classes in dsl.base and other packages were moved to corresponding internal packages - it is unlikely this will affect you unless you developed a custom extension.  Extension development can now be done exclusively against the api, please see the previous section.

## Deserialization Resolution

The apiVersion on an resource being deserialized is required.

If a version only is specified as the apiVersion, it may match kubernetes built-in types with an empty group (for example Pod), or OpenShift built in types (for example kind: Template apiVersion: v1 is allowed to match apiVersion: template.openshift.io/v1).

Otherwise with group and version specified, the resource match uniquely with a class.  This prevents the unintentional parsing of custom types without a registered class as a built-in type of the same name.  

This means that you must ensure the apiVersion values are correct on the objects you are deserializing as they will no longer resolve to built-in type of the same name when there is a mistake.

## Deprecation Removals

- Removed KubernetesClient.customResource / RawCustomResourceOperationsImpl, please use the generic resource api instead 
- Removed HttpClientUtils.createHttpClient(final Config config, final Consumer<OkHttpClient.Builder> additionalConfig), please use the OkHttpClientFactory instead
- Removed methods on SharedInformerFactory dealing with the OperationContext
- Removed DefaultKubernetesClient and DefaultOpenShiftClient constructors directly referencing OkHttp - use OkHttpClientImpl to wrap the OkHttpClient, or the OkHttpClientFactory instead.
- Removed the AutoAdaptableKubernetesClient, use the new KubernetesClientBuilder instead
- Removed OpenShiftConfig OpenshiftApiGroupsEnabled methods
- Removed Recreateable, RecreateApplicable, and ApplicableAnd from the hierarchy of ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable
- Removed Applicable, apply was just an alias for createOrReplace

### Extension Development

Extension development may now be done using only the kubernetes-client-api dependency.  Please see the [extensions](../extensions).

Of note:
- extension related classes are now in the package io.fabric8.kubernetes.client.extension, which means that you should now use META-INF/services/io.fabric8.kubernetes.client.extension.ExtensionAdapter
- Unless you need support for specific metadata to be returned by calls to rootPaths, apiGroups, or apiResources, you do not need to create a mock module.  The mocking logic can accomodate for based adapt/support checks.
- Do not include any check of support in ExtensionAdapter.adapt

## Resource Changes

KubernetesClient.resource no longer returns NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable, use NamespaceableResource instead.

This may require you to implement previously deprecated methods on your own.  For example, instead of:

client.resource(deployment).inNamespace(session.getNamespace()).deletingExisting().createOrReplace();
    
Use:

var resource = client.resource(deployment).inNamespace(session.getNamespace());
resource.delete();
resource.waitUntilCondition(Objects::isNull, 30, TimeUnit.SECONDS);
resource.create();

Similarly ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable had the Recreateable interface removed, which requires the same logic as above to implement the deletingExisting behavior

If you are simply trying to emulate the kubectl apply feature, consider instead using an edit or the new server side apply feature.

## lists Removal

KuberentesClient.lists was removed.  This entry point is effectively the same as KubernetesClient.resourceList or load.  Please use one of those methods instead.

For example:

Instead of KubernetesClient.lists().load, use KubernetesClient.resourceList or load
Instead of KubernetesClient.lists().create(list), use KubernetesClient.resourceList(list.getItems()).create()
Instead of KubernetesClient.lists().delete(list), use KubernetesClient.resourceList(list.getItems()).delete()

## GenericKubernetesClient Removal

GenericKubernetesClient has been removed.  Instead the relevant methods are on NamespacedKubernetesClient and NamespacedOpenShiftClient directly.

## IntOrString changes

We've removed setter methods `setIntVal`, `setKind`, `setStrVal` from the class. You'd need to rely on constructors or builders for creating `IntOrString` object. Here are some examples:

- Creating an Integer based object:
  ```java
  // Creating using Constructor
  IntOrString i1 = new IntOrString(3000);
  // Creating using Builder
  IntOrString i2 = new IntOrStringBuilder().withValue(89).build(); 
  ```
- Creating a String based object:
  ```java
  // Creating using Constructor
  IntOrString i1 = new IntOrString("3000");
  // Creating using Builder
  IntOrString i2 = new IntOrStringBuilder().withValue("89").build();
  ```
- You can rely on existing `getIntVal`, `getStrVal` methods to get Integer or String values respectively:
  ```java
  // Get Integer values:
  IntOrString i1 = new IntOrString(3000);
  Integer intValue = i1.getIntVal();
  
  // Get String values:
  IntOrString i2 = new IntOrString("3000");
  String strValue = i2.getStrVal();
  ```

## Extension Changes

- io.fabric8.servicecatalog.client.internal.XXXResource interfaces moved to io.fabric8.servicecatalog.client.dsl.XXXResource to no longer be in an internal package.

- io.fabric8.volumesnapshot.client.internal.XXXResource interfaces moved to io.fabric8.volumesnapshot.client.XXXResource to no longer be in an internal package.

- the jsonschema2pojo logic was consolidated with the built-in models.  This introduces some previously excluded fields, such as PipelineSpec._finally.  It will also manipulate properties to conform to expectations of the builder logic - so rather than JSONSchemaPropsBuilder.getxDescriptors there will be getXDescriptors.

## Adapt Changes

Client.isAdaptable and Client.adapt will check first if the existing client is an instance of the desired type.

Client.adapt will no longer perform the isAdaptable check - that is you may freely adapt from one Client to another as long as the extension exists.  If you need to make a specific check of support, please use the Client.supports method.

## Deprecations

- ApiVersionUtil classes in each extension have been deprecated, you should use io.fabric8.kubernetes.client.utils.ApiVersionUtil instead.
- HttpClientUtils.createHttpClient has been deprecated, you should create your own client factory instead.

- Extension specific EnableXXXMockClient and XXXMockServer classes have been deprecated.  You can simply use EnableKubernetesMockClient and KubernetesMockServer instead. Dependencies on the xxx-mock jar are then no longer needed, just a dependency to kubernetes-server-mock.
- Client.supportsApiPath and Client.isAdaptable have been deprecated.  Please use Client.supports and Client.hasApiGroup as needed.

- Informable.withIndexers has been deprecated.  Indexers can be added/removed after the creation of the informer.

- The methods provided by MultiDeleteable have moved to FilterWatchListMultiDeletable and have been deprecated.  You may use KubernetesClient.resourceList, or the individual resource methods to delete the items.

- DSL methods available off of a resource context involving a resource - client.configMaps().withName("name").create(configMap) - should instead use a no-argument method - client.configMaps().resource(configMap).create() or client.resource(configMap).create().

- DSL methods available off of a collection context involving a resource - client.configMaps().create(configMap) - should instead use a no-argument method - client.configMaps().resource(configMap).create() or client.resource(configMap).create().

The only exception to the above is patch(PatchContext, item) - it is valid to be called after withName. 

## Object Sorting

KubernetesList and Template will no longer automatically sort their objects by default.  You may use the HasMetadataComparator to sort the items as needed.

## DSL Interface Changes

- The usage of Boolean in the api was removed where it was not a nullable value.  Please expect a boolean primitive from methods such as delete, copy, or as an argument in Loggable.getLog

- WatchListDeletable now takes three type parameters to include the Resource type.

- PodResource, BuildResource, and interfaces related to containers and logging are no longer generic.

- SharedInformer was removed, there is now only SharedIndexInformer

- The following interfaces were removed: 
* CascadingEditReplacePatchDeletable
* CreateFromserverGettable
* EditReplacePatchDeletable
* Operation
* VersionWatchAndWaitable
* WatchListDeletable
* StatusUpdatable
* Cascading
* FilterWatchListMultiDeletable
* Creatable
* Editable
* Loadable
* Patchable
* Status*
* And many others

The logic was consolidated onto:
* AnyNamespaceOperation
* ItemWritableOperation
* ItemReplacable
* And the existing interfaces representing where the methods logically belong.

## Evict Changes

Evictable.evict will throw an exception rather than returning false if the pod is not found.  This ensures that false strictly means that the evict failed.

## Delete Behavior

Deleting a collection is now implemented using a single delete call, rather than for each item.  When the collection is namespaced and inAnyNamespace is used, in which case a call will be made to first determine the affected namespaces, and then a collection delete issued against each namespace.

The result of the delete calls will be a List of StatusDetails rather than a boolean value.  A best effort is made to process the response from the server to populate which items are deleted.  This information is generally useful if you wish to implement some kind of blocking delete behavior - that is ensure the returned resources based upon a matching uid have been deleted.

delete(List<T>) and delete(T[]) returning boolean have been deprecated.  They will always return true and 404s on individual items will simply be ignored.

## Stream Changes

The usage of Piped streams is no longer supported - they make assumptions about reading and writing threads, which the client no longer honors.  They should not be passed into 
the methods accepting InputStreams and OutputStreams.

ContainerResource.writingInput(PipedOutputStream in) and readingXXX(PipedInputStream out) have been removed - use the redirecting methods instead.

TtyExecErrorChannelable methods have been deprecated in favor of ExecWatch.exitCode and ExecListener.onExit.

ContainerResource.readingInput(InputStream in) has been deprecated - use redirectingInput instead.