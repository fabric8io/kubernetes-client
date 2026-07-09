package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceAttributeBuilder extends DeviceAttributeFluent<DeviceAttributeBuilder> implements VisitableBuilder<DeviceAttribute,DeviceAttributeBuilder>{

  DeviceAttributeFluent<?> fluent;

  public DeviceAttributeBuilder() {
    this(new DeviceAttribute());
  }
  
  public DeviceAttributeBuilder(DeviceAttributeFluent<?> fluent) {
    this(fluent, new DeviceAttribute());
  }
  
  public DeviceAttributeBuilder(DeviceAttribute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceAttributeBuilder(DeviceAttributeFluent<?> fluent,DeviceAttribute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceAttribute build() {
    DeviceAttribute buildable = new DeviceAttribute(fluent.getBool(), fluent.getBools(), fluent.getInt(), fluent.getInts(), fluent.getString(), fluent.getStrings(), fluent.getVersion(), fluent.getVersions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}