package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostFirmwareComponentsStatusBuilder extends HostFirmwareComponentsStatusFluent<HostFirmwareComponentsStatusBuilder> implements VisitableBuilder<HostFirmwareComponentsStatus,HostFirmwareComponentsStatusBuilder>{

  HostFirmwareComponentsStatusFluent<?> fluent;

  public HostFirmwareComponentsStatusBuilder() {
    this(new HostFirmwareComponentsStatus());
  }
  
  public HostFirmwareComponentsStatusBuilder(HostFirmwareComponentsStatusFluent<?> fluent) {
    this(fluent, new HostFirmwareComponentsStatus());
  }
  
  public HostFirmwareComponentsStatusBuilder(HostFirmwareComponentsStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostFirmwareComponentsStatusBuilder(HostFirmwareComponentsStatusFluent<?> fluent,HostFirmwareComponentsStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostFirmwareComponentsStatus build() {
    HostFirmwareComponentsStatus buildable = new HostFirmwareComponentsStatus(fluent.buildComponents(), fluent.getConditions(), fluent.getLastUpdated(), fluent.buildUpdates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}