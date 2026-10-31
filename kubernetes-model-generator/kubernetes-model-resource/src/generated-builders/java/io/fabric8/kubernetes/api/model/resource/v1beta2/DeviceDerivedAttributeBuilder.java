package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceDerivedAttributeBuilder extends DeviceDerivedAttributeFluent<DeviceDerivedAttributeBuilder> implements VisitableBuilder<DeviceDerivedAttribute,DeviceDerivedAttributeBuilder>{

  DeviceDerivedAttributeFluent<?> fluent;

  public DeviceDerivedAttributeBuilder() {
    this(new DeviceDerivedAttribute());
  }
  
  public DeviceDerivedAttributeBuilder(DeviceDerivedAttributeFluent<?> fluent) {
    this(fluent, new DeviceDerivedAttribute());
  }
  
  public DeviceDerivedAttributeBuilder(DeviceDerivedAttribute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceDerivedAttributeBuilder(DeviceDerivedAttributeFluent<?> fluent,DeviceDerivedAttribute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceDerivedAttribute build() {
    DeviceDerivedAttribute buildable = new DeviceDerivedAttribute(fluent.getExpression(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}