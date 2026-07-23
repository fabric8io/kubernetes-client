package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProvisionStatusBuilder extends ProvisionStatusFluent<ProvisionStatusBuilder> implements VisitableBuilder<ProvisionStatus,ProvisionStatusBuilder>{

  ProvisionStatusFluent<?> fluent;

  public ProvisionStatusBuilder() {
    this(new ProvisionStatus());
  }
  
  public ProvisionStatusBuilder(ProvisionStatusFluent<?> fluent) {
    this(fluent, new ProvisionStatus());
  }
  
  public ProvisionStatusBuilder(ProvisionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProvisionStatusBuilder(ProvisionStatusFluent<?> fluent,ProvisionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProvisionStatus build() {
    ProvisionStatus buildable = new ProvisionStatus(fluent.getID(), fluent.getBootMode(), fluent.buildCustomDeploy(), fluent.buildFirmware(), fluent.buildImage(), fluent.buildRaid(), fluent.buildRootDeviceHints(), fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}