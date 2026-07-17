package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSBuilderReferenceBuilder extends MachineOSBuilderReferenceFluent<MachineOSBuilderReferenceBuilder> implements VisitableBuilder<MachineOSBuilderReference,MachineOSBuilderReferenceBuilder>{

  MachineOSBuilderReferenceFluent<?> fluent;

  public MachineOSBuilderReferenceBuilder() {
    this(new MachineOSBuilderReference());
  }
  
  public MachineOSBuilderReferenceBuilder(MachineOSBuilderReferenceFluent<?> fluent) {
    this(fluent, new MachineOSBuilderReference());
  }
  
  public MachineOSBuilderReferenceBuilder(MachineOSBuilderReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSBuilderReferenceBuilder(MachineOSBuilderReferenceFluent<?> fluent,MachineOSBuilderReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSBuilderReference build() {
    MachineOSBuilderReference buildable = new MachineOSBuilderReference(fluent.getImageBuilderType(), fluent.buildJob());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}