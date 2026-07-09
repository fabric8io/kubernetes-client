package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceAllocationResultBuilder extends DeviceAllocationResultFluent<DeviceAllocationResultBuilder> implements VisitableBuilder<DeviceAllocationResult,DeviceAllocationResultBuilder>{

  DeviceAllocationResultFluent<?> fluent;

  public DeviceAllocationResultBuilder() {
    this(new DeviceAllocationResult());
  }
  
  public DeviceAllocationResultBuilder(DeviceAllocationResultFluent<?> fluent) {
    this(fluent, new DeviceAllocationResult());
  }
  
  public DeviceAllocationResultBuilder(DeviceAllocationResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceAllocationResultBuilder(DeviceAllocationResultFluent<?> fluent,DeviceAllocationResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceAllocationResult build() {
    DeviceAllocationResult buildable = new DeviceAllocationResult(fluent.buildConfig(), fluent.buildResults());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}