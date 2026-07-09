package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllocatedDeviceStatusBuilder extends AllocatedDeviceStatusFluent<AllocatedDeviceStatusBuilder> implements VisitableBuilder<AllocatedDeviceStatus,AllocatedDeviceStatusBuilder>{

  AllocatedDeviceStatusFluent<?> fluent;

  public AllocatedDeviceStatusBuilder() {
    this(new AllocatedDeviceStatus());
  }
  
  public AllocatedDeviceStatusBuilder(AllocatedDeviceStatusFluent<?> fluent) {
    this(fluent, new AllocatedDeviceStatus());
  }
  
  public AllocatedDeviceStatusBuilder(AllocatedDeviceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllocatedDeviceStatusBuilder(AllocatedDeviceStatusFluent<?> fluent,AllocatedDeviceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllocatedDeviceStatus build() {
    AllocatedDeviceStatus buildable = new AllocatedDeviceStatus(fluent.getConditions(), fluent.getData(), fluent.getDevice(), fluent.getDriver(), fluent.buildNetworkData(), fluent.getPool(), fluent.getShareID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}