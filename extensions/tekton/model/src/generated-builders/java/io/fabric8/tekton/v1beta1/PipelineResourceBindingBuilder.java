package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineResourceBindingBuilder extends PipelineResourceBindingFluent<PipelineResourceBindingBuilder> implements VisitableBuilder<PipelineResourceBinding,PipelineResourceBindingBuilder>{

  PipelineResourceBindingFluent<?> fluent;

  public PipelineResourceBindingBuilder() {
    this(new PipelineResourceBinding());
  }
  
  public PipelineResourceBindingBuilder(PipelineResourceBindingFluent<?> fluent) {
    this(fluent, new PipelineResourceBinding());
  }
  
  public PipelineResourceBindingBuilder(PipelineResourceBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineResourceBindingBuilder(PipelineResourceBindingFluent<?> fluent,PipelineResourceBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineResourceBinding build() {
    PipelineResourceBinding buildable = new PipelineResourceBinding(fluent.getName(), fluent.buildResourceRef(), fluent.buildResourceSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}