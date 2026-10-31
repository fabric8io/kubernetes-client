package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositePodGroupTemplateBuilder extends CompositePodGroupTemplateFluent<CompositePodGroupTemplateBuilder> implements VisitableBuilder<CompositePodGroupTemplate,CompositePodGroupTemplateBuilder>{

  CompositePodGroupTemplateFluent<?> fluent;

  public CompositePodGroupTemplateBuilder() {
    this(new CompositePodGroupTemplate());
  }
  
  public CompositePodGroupTemplateBuilder(CompositePodGroupTemplateFluent<?> fluent) {
    this(fluent, new CompositePodGroupTemplate());
  }
  
  public CompositePodGroupTemplateBuilder(CompositePodGroupTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositePodGroupTemplateBuilder(CompositePodGroupTemplateFluent<?> fluent,CompositePodGroupTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositePodGroupTemplate build() {
    CompositePodGroupTemplate buildable = new CompositePodGroupTemplate(fluent.buildCompositePodGroupTemplates(), fluent.buildDisruptionMode(), fluent.getName(), fluent.buildPodGroupTemplates(), fluent.getPreemptionPolicy(), fluent.getPriority(), fluent.getPriorityClassName(), fluent.buildSchedulingConstraints(), fluent.buildSchedulingPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}