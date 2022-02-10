# Migration from 5.x to 6.x

## Contents:
- [IntOrString changes](#intorstring-changes)


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
