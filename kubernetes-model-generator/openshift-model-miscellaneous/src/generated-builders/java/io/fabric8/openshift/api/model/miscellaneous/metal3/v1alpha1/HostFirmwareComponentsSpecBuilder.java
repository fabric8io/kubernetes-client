package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostFirmwareComponentsSpecBuilder extends HostFirmwareComponentsSpecFluent<HostFirmwareComponentsSpecBuilder> implements VisitableBuilder<HostFirmwareComponentsSpec,HostFirmwareComponentsSpecBuilder>{

  HostFirmwareComponentsSpecFluent<?> fluent;

  public HostFirmwareComponentsSpecBuilder() {
    this(new HostFirmwareComponentsSpec());
  }
  
  public HostFirmwareComponentsSpecBuilder(HostFirmwareComponentsSpecFluent<?> fluent) {
    this(fluent, new HostFirmwareComponentsSpec());
  }
  
  public HostFirmwareComponentsSpecBuilder(HostFirmwareComponentsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostFirmwareComponentsSpecBuilder(HostFirmwareComponentsSpecFluent<?> fluent,HostFirmwareComponentsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostFirmwareComponentsSpec build() {
    HostFirmwareComponentsSpec buildable = new HostFirmwareComponentsSpec(fluent.buildUpdates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}