package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3MachineTemplateResourceBuilder extends Metal3MachineTemplateResourceFluent<Metal3MachineTemplateResourceBuilder> implements VisitableBuilder<Metal3MachineTemplateResource,Metal3MachineTemplateResourceBuilder>{

  Metal3MachineTemplateResourceFluent<?> fluent;

  public Metal3MachineTemplateResourceBuilder() {
    this(new Metal3MachineTemplateResource());
  }
  
  public Metal3MachineTemplateResourceBuilder(Metal3MachineTemplateResourceFluent<?> fluent) {
    this(fluent, new Metal3MachineTemplateResource());
  }
  
  public Metal3MachineTemplateResourceBuilder(Metal3MachineTemplateResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3MachineTemplateResourceBuilder(Metal3MachineTemplateResourceFluent<?> fluent,Metal3MachineTemplateResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3MachineTemplateResource build() {
    Metal3MachineTemplateResource buildable = new Metal3MachineTemplateResource(fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}