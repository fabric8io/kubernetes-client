package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3MachineTemplateBuilder extends Metal3MachineTemplateFluent<Metal3MachineTemplateBuilder> implements VisitableBuilder<Metal3MachineTemplate,Metal3MachineTemplateBuilder>{

  Metal3MachineTemplateFluent<?> fluent;

  public Metal3MachineTemplateBuilder() {
    this(new Metal3MachineTemplate());
  }
  
  public Metal3MachineTemplateBuilder(Metal3MachineTemplateFluent<?> fluent) {
    this(fluent, new Metal3MachineTemplate());
  }
  
  public Metal3MachineTemplateBuilder(Metal3MachineTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3MachineTemplateBuilder(Metal3MachineTemplateFluent<?> fluent,Metal3MachineTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3MachineTemplate build() {
    Metal3MachineTemplate buildable = new Metal3MachineTemplate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}