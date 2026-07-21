package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineTaskRunTemplateBuilder extends PipelineTaskRunTemplateFluent<PipelineTaskRunTemplateBuilder> implements VisitableBuilder<PipelineTaskRunTemplate,PipelineTaskRunTemplateBuilder>{

  PipelineTaskRunTemplateFluent<?> fluent;

  public PipelineTaskRunTemplateBuilder() {
    this(new PipelineTaskRunTemplate());
  }
  
  public PipelineTaskRunTemplateBuilder(PipelineTaskRunTemplateFluent<?> fluent) {
    this(fluent, new PipelineTaskRunTemplate());
  }
  
  public PipelineTaskRunTemplateBuilder(PipelineTaskRunTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineTaskRunTemplateBuilder(PipelineTaskRunTemplateFluent<?> fluent,PipelineTaskRunTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineTaskRunTemplate build() {
    PipelineTaskRunTemplate buildable = new PipelineTaskRunTemplate(fluent.buildPodTemplate(), fluent.getServiceAccountName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}