package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceRequestAllocationResultBuilder extends DeviceRequestAllocationResultFluent<DeviceRequestAllocationResultBuilder> implements VisitableBuilder<DeviceRequestAllocationResult,DeviceRequestAllocationResultBuilder>{

  DeviceRequestAllocationResultFluent<?> fluent;

  public DeviceRequestAllocationResultBuilder() {
    this(new DeviceRequestAllocationResult());
  }
  
  public DeviceRequestAllocationResultBuilder(DeviceRequestAllocationResultFluent<?> fluent) {
    this(fluent, new DeviceRequestAllocationResult());
  }
  
  public DeviceRequestAllocationResultBuilder(DeviceRequestAllocationResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceRequestAllocationResultBuilder(DeviceRequestAllocationResultFluent<?> fluent,DeviceRequestAllocationResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceRequestAllocationResult build() {
    DeviceRequestAllocationResult buildable = new DeviceRequestAllocationResult(fluent.getAdminAccess(), fluent.getBindingConditions(), fluent.getBindingFailureConditions(), fluent.getConsumedCapacity(), fluent.getDevice(), fluent.getDriver(), fluent.getPool(), fluent.getRequest(), fluent.getShareID(), fluent.buildTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}