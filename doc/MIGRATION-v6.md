# Migration from 5.x to 6.x

## Contents:
- [API/Impl split](#api-impl-split)
- [Deprecation Removals](#deprecation-removals)
- [IntOrString changes](#intorstring-changes)

## API/Impl split

This release introduces kubernetes-client-api and openshift-client-api modules.  You may use them as compile dependencies in your application with the respective kubernetes-client and openshift-client as runtime dependencies.  This will keep you compile classpath cleaner of classes and libraries that are not intentionally exposed by the fabric8 client.

If you are directly relying on classes in the -client jars other than DefaultKubernetesClient and DefaultOpenShiftClient, please let us know your usage scenario.  Moving forward we'd like consider all classes in the -client jars internal.

When you rely solely on a compile dependency to the respective -api dependencies you will not be able to use DefaultKubernetesClient nor DefaultOpenShiftClient directly to create your client instances.  You should instead - TBD 

### Package Changes

- Readiness/OpenShiftReadiness moved from client.internal.readiness to client.readiness
- client.utils classes including Base64, CreateOrReplaceHelper, DeleteOrCreateHelper, OptionalDendencyWrapper, etc. are not in the -api jar, they are still in the -client jar under utils.internal.
- Some other effectively internal classes in dsl.base and other packages were moved to corresponding internal packages - it is unlikely this will affect you unless you developed a custom extension.

## Deprecation Removals

- Removed KubernetesClient.customResource / RawCustomResourceOperationsImpl, please use the generic resource api instead 
- Removed deprecatedHttpClientUtils.createHttpClient(final Config config, final Consumer<OkHttpClient.Builder> additionalConfig), please use the OkHttpClientFactory instead
- Removed deprecated methods on SharedInformerFactory dealing with the OperationContext

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
