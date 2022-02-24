# Migration from 5.x to 6.x

## Contents:
- [API/Impl split](#api-impl-split)
- [Deserialization Resolution](#deserialization-resolution)
- [Deprecation Removals](#deprecation-removals)
- [IntOrString changes](#intorstring-changes)
- [Object sorting](#object-sorting)

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
  
## Object Sorting

KubernetesList and Template will no longer automatically sort their objects by default.  You may use the HasMetadataComparator to sort the items as needed.
