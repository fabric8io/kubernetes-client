package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupTemplateBuilder extends PodGroupTemplateFluent<PodGroupTemplateBuilder> implements VisitableBuilder<PodGroupTemplate,PodGroupTemplateBuilder>{

  PodGroupTemplateFluent<?> fluent;

  public PodGroupTemplateBuilder() {
    this(new PodGroupTemplate());
  }
  
  public PodGroupTemplateBuilder(PodGroupTemplateFluent<?> fluent) {
    this(fluent, new PodGroupTemplate());
  }
  
  public PodGroupTemplateBuilder(PodGroupTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupTemplateBuilder(PodGroupTemplateFluent<?> fluent,PodGroupTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupTemplate build() {
    PodGroupTemplate buildable = new PodGroupTemplate(fluent.getDisruptionMode(), fluent.getName(), fluent.getPriority(), fluent.getPriorityClassName(), fluent.buildResourceClaims(), fluent.buildSchedulingConstraints(), fluent.buildSchedulingPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}