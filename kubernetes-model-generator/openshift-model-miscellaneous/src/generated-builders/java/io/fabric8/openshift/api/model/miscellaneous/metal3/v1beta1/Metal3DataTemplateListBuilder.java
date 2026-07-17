package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataTemplateListBuilder extends Metal3DataTemplateListFluent<Metal3DataTemplateListBuilder> implements VisitableBuilder<Metal3DataTemplateList,Metal3DataTemplateListBuilder>{

  Metal3DataTemplateListFluent<?> fluent;

  public Metal3DataTemplateListBuilder() {
    this(new Metal3DataTemplateList());
  }
  
  public Metal3DataTemplateListBuilder(Metal3DataTemplateListFluent<?> fluent) {
    this(fluent, new Metal3DataTemplateList());
  }
  
  public Metal3DataTemplateListBuilder(Metal3DataTemplateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataTemplateListBuilder(Metal3DataTemplateListFluent<?> fluent,Metal3DataTemplateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataTemplateList build() {
    Metal3DataTemplateList buildable = new Metal3DataTemplateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}