# Migration from 5.x to 6.x

## Contents:
- [Namespace Changes](#namespace-changes)
- [API/Impl split](#api-impl-split)
- [Deserialization Resolution](#deserialization-resolution)
- [Deprecation Removals](#deprecation-removals)
- [Resource Changes](#resource-changes)
- [lists Removal](#lists-removal)
- [GenericKubernetesClient Removal](#generickubernetesclient-removal)
- [IntOrString Changes](#intorstring-changes)
- [ServiceCatalog Changes](#service-catalog-changes)
- [Adapt Changes](#adapt-changes)
- [Deprecations](#deprecations)
- [Object sorting](#object-sorting)

## Namespace Changes

To match the behavior of kubectl the client will now consider any call to inNamespace as the namespace to use regardless of what is on a passed in item.  
Only if the client is left at the default namespace or a call has been made to inAnyNamespace will the item namespace be used.  
This applies to all calls to inNamespace - at the Client, Operation, or Resource level, and for all operations (load, create, delete, withItem, etc.)

The end result is that exceptions refering to mismatched namespaces will no longer be thrown.

Consider the following examples:

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

To track the namespace handling at the client level the Config has an additional boolean field defaultNamespace, you may set that to false to have the Client treat subsequent calls as if inNamespace had been called explicitly.

## API/Impl split

This release introduces kubernetes-client-api and openshift-client-api modules.  You may use them as compile dependencies in your application with the respective kubernetes-client and openshift-client as runtime dependencies.  This will keep you compile classpath cleaner of classes and libraries that are not intentionally exposed by the fabric8 client.

If you are directly relying on classes in the -client jars other than DefaultKubernetesClient and DefaultOpenShiftClient, please let us know your usage scenario.  Moving forward we'd like consider all classes in the -client jars internal.

When you rely solely on a compile dependency to the respective -api dependencies you will not be able to use DefaultKubernetesClient nor DefaultOpenShiftClient directly to create your client instances.  You should instead - TBD 

### OkHttp HttpClient

The -client dependencies still default to the OkHttp client If you are doing any customization to OkHttp clients directly, you'll need to include the kubernetes-httpclient-okhttp dependency in the compile scope - instead of the default runtime scope

### JDK HttpClient

The JDK client should be considered experimental, please consult the [README](../httpclient-jdk/README.md).

To use it, exclude the kubernetes-httpclient-okhttp dependency and add the kubernetes-httpclient-jdk dependency.

### Package Changes

- Readiness/OpenShiftReadiness moved from client.internal.readiness to client.readiness
- client.utils classes including Base64, CreateOrReplaceHelper, DeleteOrCreateHelper, OptionalDendencyWrapper, etc. are not in the -api jar, they are still in the -client jar under utils.internal.
- Some other effectively internal classes in dsl.base and other packages were moved to corresponding internal packages - it is unlikely this will affect you unless you developed a custom extension.

## Deserialization Resolution

The group on the object being deserialized is not required to match the prospective class - even for built-in types.  This prevents the unintentional parsing of custom types without a registered class as a built-in type of the same name.  This also means that you must ensure the apiVersion values are correct on the objects you are deserializing as they will no longer resolve to built-in type of the same name when there is a mistake.

## Deprecation Removals

- Removed KubernetesClient.customResource / RawCustomResourceOperationsImpl, please use the generic resource api instead 
- Removed HttpClientUtils.createHttpClient(final Config config, final Consumer<OkHttpClient.Builder> additionalConfig), please use the OkHttpClientFactory instead
- Removed methods on SharedInformerFactory dealing with the OperationContext
- Removed DefaultKubernetesClient and DefaultOpenShiftClient constructors directly referencing OkHttp - use OkHttpClientImpl to wrap the OkHttpClient, or the OkHttpClientFactory instead.

### Extension Development

Extension development may now be done using only the kubernetes-client-api dependency.  Please see the [extensions](../extensions).

## Resource Changes

KubernetesClient.resource no longer returns NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable, use NamespaceableResource instead.

This may require you to implement previously deprecated methods on your own.  For example, instead of:

client.resource(deployment).inNamespace(session.getNamespace()).deletingExisting().createOrReplace();
    
Use:

var resource = client.resource(deployment).inNamespace(session.getNamespace());
resource.delete();
resource.waitUntilCondition(Objects::isNull, 30, TimeUnit.SECONDS);
resource.create();

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

## Service Catalog Changes

io.fabric8.servicecatalog.client.internal.XXXResource interfaces moved to io.fabric8.servicecatalog.client.dsl.XXXResource to no longer be in an internal package.

## Adapt Changes

Client.isAdaptable and Client.adapt will check first if the existing instance is compatible with the desired type.

## Deprecations

- ApiVersionUtil classes in each extension have been deprecated, you should use io.fabric8.kubernetes.client.utils.ApiVersionUtil instead.

- Extension specific EnableXXXMockClient and XXXMockServer classes have been deprecated.  You can simply use EnableKubernetesMockClient and KubernetesMockServer instead. Dependencies on the xxx-mock jar are then no longer needed, just a dependency to kubernetes-server-mock.

## Object Sorting

KubernetesList and Template will no longer automatically sort their objects by default.  You may use the HasMetadataComparator to sort the items as needed.