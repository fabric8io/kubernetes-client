package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceCapacityBuilder extends DeviceCapacityFluent<DeviceCapacityBuilder> implements VisitableBuilder<DeviceCapacity,DeviceCapacityBuilder>{

  DeviceCapacityFluent<?> fluent;

  public DeviceCapacityBuilder() {
    this(new DeviceCapacity());
  }
  
  public DeviceCapacityBuilder(DeviceCapacityFluent<?> fluent) {
    this(fluent, new DeviceCapacity());
  }
  
  public DeviceCapacityBuilder(DeviceCapacity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceCapacityBuilder(DeviceCapacityFluent<?> fluent,DeviceCapacity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceCapacity build() {
    DeviceCapacity buildable = new DeviceCapacity(fluent.buildRequestPolicy(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}