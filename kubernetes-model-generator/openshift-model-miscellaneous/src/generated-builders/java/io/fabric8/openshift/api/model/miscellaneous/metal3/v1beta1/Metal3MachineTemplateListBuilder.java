package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3MachineTemplateListBuilder extends Metal3MachineTemplateListFluent<Metal3MachineTemplateListBuilder> implements VisitableBuilder<Metal3MachineTemplateList,Metal3MachineTemplateListBuilder>{

  Metal3MachineTemplateListFluent<?> fluent;

  public Metal3MachineTemplateListBuilder() {
    this(new Metal3MachineTemplateList());
  }
  
  public Metal3MachineTemplateListBuilder(Metal3MachineTemplateListFluent<?> fluent) {
    this(fluent, new Metal3MachineTemplateList());
  }
  
  public Metal3MachineTemplateListBuilder(Metal3MachineTemplateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3MachineTemplateListBuilder(Metal3MachineTemplateListFluent<?> fluent,Metal3MachineTemplateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3MachineTemplateList build() {
    Metal3MachineTemplateList buildable = new Metal3MachineTemplateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}