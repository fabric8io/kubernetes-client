package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigReferenceBuilder extends MachineConfigReferenceFluent<MachineConfigReferenceBuilder> implements VisitableBuilder<MachineConfigReference,MachineConfigReferenceBuilder>{

  MachineConfigReferenceFluent<?> fluent;

  public MachineConfigReferenceBuilder() {
    this(new MachineConfigReference());
  }
  
  public MachineConfigReferenceBuilder(MachineConfigReferenceFluent<?> fluent) {
    this(fluent, new MachineConfigReference());
  }
  
  public MachineConfigReferenceBuilder(MachineConfigReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigReferenceBuilder(MachineConfigReferenceFluent<?> fluent,MachineConfigReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigReference build() {
    MachineConfigReference buildable = new MachineConfigReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}