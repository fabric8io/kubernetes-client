package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostFirmwareComponentsBuilder extends HostFirmwareComponentsFluent<HostFirmwareComponentsBuilder> implements VisitableBuilder<HostFirmwareComponents,HostFirmwareComponentsBuilder>{

  HostFirmwareComponentsFluent<?> fluent;

  public HostFirmwareComponentsBuilder() {
    this(new HostFirmwareComponents());
  }
  
  public HostFirmwareComponentsBuilder(HostFirmwareComponentsFluent<?> fluent) {
    this(fluent, new HostFirmwareComponents());
  }
  
  public HostFirmwareComponentsBuilder(HostFirmwareComponents instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostFirmwareComponentsBuilder(HostFirmwareComponentsFluent<?> fluent,HostFirmwareComponents instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostFirmwareComponents build() {
    HostFirmwareComponents buildable = new HostFirmwareComponents(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}