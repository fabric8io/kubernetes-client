package io.fabric8.kubernetes.api.model.resource.v1beta2;

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
    Device buildable = new Device(fluent.getAllNodes(), fluent.getAllowMultipleAllocations(), fluent.getAttributes(), fluent.getBindingConditions(), fluent.getBindingFailureConditions(), fluent.getBindsToNode(), fluent.getCapacity(), fluent.buildConsumesCounters(), fluent.getName(), fluent.getNodeAllocatableResourceMappings(), fluent.getNodeName(), fluent.getNodeSelector(), fluent.buildTaints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}