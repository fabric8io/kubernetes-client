package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSConfigReferenceBuilder extends MachineOSConfigReferenceFluent<MachineOSConfigReferenceBuilder> implements VisitableBuilder<MachineOSConfigReference,MachineOSConfigReferenceBuilder>{

  MachineOSConfigReferenceFluent<?> fluent;

  public MachineOSConfigReferenceBuilder() {
    this(new MachineOSConfigReference());
  }
  
  public MachineOSConfigReferenceBuilder(MachineOSConfigReferenceFluent<?> fluent) {
    this(fluent, new MachineOSConfigReference());
  }
  
  public MachineOSConfigReferenceBuilder(MachineOSConfigReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSConfigReferenceBuilder(MachineOSConfigReferenceFluent<?> fluent,MachineOSConfigReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSConfigReference build() {
    MachineOSConfigReference buildable = new MachineOSConfigReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}