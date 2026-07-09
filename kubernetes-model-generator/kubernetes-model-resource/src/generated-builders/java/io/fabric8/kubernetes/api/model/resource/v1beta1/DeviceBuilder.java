package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceBuilder extends DeviceFluent<DeviceBuilder> implements VisitableBuilder<Device,DeviceBuilder>{

  DeviceFluent<?> fluent;

  public DeviceBuilder() {
    this(new Device());
  }
  
  public DeviceBuilder(DeviceFluent<?> fluent) {
    this(fluent, new Device());
  }
  
  public DeviceBuilder(Device instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceBuilder(DeviceFluent<?> fluent,Device instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Device build() {
    Device buildable = new Device(fluent.buildBasic(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}