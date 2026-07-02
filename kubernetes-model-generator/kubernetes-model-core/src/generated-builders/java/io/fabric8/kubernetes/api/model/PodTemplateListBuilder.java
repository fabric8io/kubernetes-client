package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodTemplateListBuilder extends PodTemplateListFluent<PodTemplateListBuilder> implements VisitableBuilder<PodTemplateList,PodTemplateListBuilder>{

  PodTemplateListFluent<?> fluent;

  public PodTemplateListBuilder() {
    this(new PodTemplateList());
  }
  
  public PodTemplateListBuilder(PodTemplateListFluent<?> fluent) {
    this(fluent, new PodTemplateList());
  }
  
  public PodTemplateListBuilder(PodTemplateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodTemplateListBuilder(PodTemplateListFluent<?> fluent,PodTemplateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodTemplateList build() {
    PodTemplateList buildable = new PodTemplateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}