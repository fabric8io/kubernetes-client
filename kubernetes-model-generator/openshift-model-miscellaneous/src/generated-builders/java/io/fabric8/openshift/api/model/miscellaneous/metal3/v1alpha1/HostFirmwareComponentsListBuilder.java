package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostFirmwareComponentsListBuilder extends HostFirmwareComponentsListFluent<HostFirmwareComponentsListBuilder> implements VisitableBuilder<HostFirmwareComponentsList,HostFirmwareComponentsListBuilder>{

  HostFirmwareComponentsListFluent<?> fluent;

  public HostFirmwareComponentsListBuilder() {
    this(new HostFirmwareComponentsList());
  }
  
  public HostFirmwareComponentsListBuilder(HostFirmwareComponentsListFluent<?> fluent) {
    this(fluent, new HostFirmwareComponentsList());
  }
  
  public HostFirmwareComponentsListBuilder(HostFirmwareComponentsList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostFirmwareComponentsListBuilder(HostFirmwareComponentsListFluent<?> fluent,HostFirmwareComponentsList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostFirmwareComponentsList build() {
    HostFirmwareComponentsList buildable = new HostFirmwareComponentsList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}