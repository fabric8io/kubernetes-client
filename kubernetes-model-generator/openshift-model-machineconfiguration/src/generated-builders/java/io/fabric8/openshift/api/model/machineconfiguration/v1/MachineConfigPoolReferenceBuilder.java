package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigPoolReferenceBuilder extends MachineConfigPoolReferenceFluent<MachineConfigPoolReferenceBuilder> implements VisitableBuilder<MachineConfigPoolReference,MachineConfigPoolReferenceBuilder>{

  MachineConfigPoolReferenceFluent<?> fluent;

  public MachineConfigPoolReferenceBuilder() {
    this(new MachineConfigPoolReference());
  }
  
  public MachineConfigPoolReferenceBuilder(MachineConfigPoolReferenceFluent<?> fluent) {
    this(fluent, new MachineConfigPoolReference());
  }
  
  public MachineConfigPoolReferenceBuilder(MachineConfigPoolReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigPoolReferenceBuilder(MachineConfigPoolReferenceFluent<?> fluent,MachineConfigPoolReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigPoolReference build() {
    MachineConfigPoolReference buildable = new MachineConfigPoolReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}