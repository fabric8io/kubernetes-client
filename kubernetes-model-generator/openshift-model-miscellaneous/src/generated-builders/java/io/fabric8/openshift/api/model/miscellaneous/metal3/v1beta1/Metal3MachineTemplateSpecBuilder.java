package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3MachineTemplateSpecBuilder extends Metal3MachineTemplateSpecFluent<Metal3MachineTemplateSpecBuilder> implements VisitableBuilder<Metal3MachineTemplateSpec,Metal3MachineTemplateSpecBuilder>{

  Metal3MachineTemplateSpecFluent<?> fluent;

  public Metal3MachineTemplateSpecBuilder() {
    this(new Metal3MachineTemplateSpec());
  }
  
  public Metal3MachineTemplateSpecBuilder(Metal3MachineTemplateSpecFluent<?> fluent) {
    this(fluent, new Metal3MachineTemplateSpec());
  }
  
  public Metal3MachineTemplateSpecBuilder(Metal3MachineTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3MachineTemplateSpecBuilder(Metal3MachineTemplateSpecFluent<?> fluent,Metal3MachineTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3MachineTemplateSpec build() {
    Metal3MachineTemplateSpec buildable = new Metal3MachineTemplateSpec(fluent.getNodeReuse(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}