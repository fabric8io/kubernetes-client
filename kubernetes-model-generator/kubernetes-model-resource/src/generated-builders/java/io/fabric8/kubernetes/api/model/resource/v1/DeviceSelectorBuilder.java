package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceSelectorBuilder extends DeviceSelectorFluent<DeviceSelectorBuilder> implements VisitableBuilder<DeviceSelector,DeviceSelectorBuilder>{

  DeviceSelectorFluent<?> fluent;

  public DeviceSelectorBuilder() {
    this(new DeviceSelector());
  }
  
  public DeviceSelectorBuilder(DeviceSelectorFluent<?> fluent) {
    this(fluent, new DeviceSelector());
  }
  
  public DeviceSelectorBuilder(DeviceSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceSelectorBuilder(DeviceSelectorFluent<?> fluent,DeviceSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceSelector build() {
    DeviceSelector buildable = new DeviceSelector(fluent.buildCel());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}