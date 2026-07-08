package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodTemplateBuilder extends PodTemplateFluent<PodTemplateBuilder> implements VisitableBuilder<PodTemplate,PodTemplateBuilder>{

  PodTemplateFluent<?> fluent;

  public PodTemplateBuilder() {
    this(new PodTemplate());
  }
  
  public PodTemplateBuilder(PodTemplateFluent<?> fluent) {
    this(fluent, new PodTemplate());
  }
  
  public PodTemplateBuilder(PodTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodTemplateBuilder(PodTemplateFluent<?> fluent,PodTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodTemplate build() {
    PodTemplate buildable = new PodTemplate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}