package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceTaintSelectorBuilder extends DeviceTaintSelectorFluent<DeviceTaintSelectorBuilder> implements VisitableBuilder<DeviceTaintSelector,DeviceTaintSelectorBuilder>{

  DeviceTaintSelectorFluent<?> fluent;

  public DeviceTaintSelectorBuilder() {
    this(new DeviceTaintSelector());
  }
  
  public DeviceTaintSelectorBuilder(DeviceTaintSelectorFluent<?> fluent) {
    this(fluent, new DeviceTaintSelector());
  }
  
  public DeviceTaintSelectorBuilder(DeviceTaintSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceTaintSelectorBuilder(DeviceTaintSelectorFluent<?> fluent,DeviceTaintSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceTaintSelector build() {
    DeviceTaintSelector buildable = new DeviceTaintSelector(fluent.getDevice(), fluent.getDriver(), fluent.getPool());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}