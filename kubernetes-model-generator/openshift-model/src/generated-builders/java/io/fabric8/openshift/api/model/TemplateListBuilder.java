package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateListBuilder extends TemplateListFluent<TemplateListBuilder> implements VisitableBuilder<TemplateList,TemplateListBuilder>{

  TemplateListFluent<?> fluent;

  public TemplateListBuilder() {
    this(new TemplateList());
  }
  
  public TemplateListBuilder(TemplateListFluent<?> fluent) {
    this(fluent, new TemplateList());
  }
  
  public TemplateListBuilder(TemplateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateListBuilder(TemplateListFluent<?> fluent,TemplateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TemplateList build() {
    TemplateList buildable = new TemplateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}