package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateInstanceListBuilder extends TemplateInstanceListFluent<TemplateInstanceListBuilder> implements VisitableBuilder<TemplateInstanceList,TemplateInstanceListBuilder>{

  TemplateInstanceListFluent<?> fluent;

  public TemplateInstanceListBuilder() {
    this(new TemplateInstanceList());
  }
  
  public TemplateInstanceListBuilder(TemplateInstanceListFluent<?> fluent) {
    this(fluent, new TemplateInstanceList());
  }
  
  public TemplateInstanceListBuilder(TemplateInstanceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateInstanceListBuilder(TemplateInstanceListFluent<?> fluent,TemplateInstanceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TemplateInstanceList build() {
    TemplateInstanceList buildable = new TemplateInstanceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}