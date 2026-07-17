package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineTemplateSpecBuilder extends MachineTemplateSpecFluent<MachineTemplateSpecBuilder> implements VisitableBuilder<MachineTemplateSpec,MachineTemplateSpecBuilder>{

  MachineTemplateSpecFluent<?> fluent;

  public MachineTemplateSpecBuilder() {
    this(new MachineTemplateSpec());
  }
  
  public MachineTemplateSpecBuilder(MachineTemplateSpecFluent<?> fluent) {
    this(fluent, new MachineTemplateSpec());
  }
  
  public MachineTemplateSpecBuilder(MachineTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineTemplateSpecBuilder(MachineTemplateSpecFluent<?> fluent,MachineTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineTemplateSpec build() {
    MachineTemplateSpec buildable = new MachineTemplateSpec(fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}