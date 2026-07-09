package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceClaimBuilder extends DeviceClaimFluent<DeviceClaimBuilder> implements VisitableBuilder<DeviceClaim,DeviceClaimBuilder>{

  DeviceClaimFluent<?> fluent;

  public DeviceClaimBuilder() {
    this(new DeviceClaim());
  }
  
  public DeviceClaimBuilder(DeviceClaimFluent<?> fluent) {
    this(fluent, new DeviceClaim());
  }
  
  public DeviceClaimBuilder(DeviceClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceClaimBuilder(DeviceClaimFluent<?> fluent,DeviceClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceClaim build() {
    DeviceClaim buildable = new DeviceClaim(fluent.buildConfig(), fluent.buildConstraints(), fluent.buildRequests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}