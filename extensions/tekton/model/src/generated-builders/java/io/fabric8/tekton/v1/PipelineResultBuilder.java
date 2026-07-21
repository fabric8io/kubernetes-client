package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineResultBuilder extends PipelineResultFluent<PipelineResultBuilder> implements VisitableBuilder<PipelineResult,PipelineResultBuilder>{

  PipelineResultFluent<?> fluent;

  public PipelineResultBuilder() {
    this(new PipelineResult());
  }
  
  public PipelineResultBuilder(PipelineResultFluent<?> fluent) {
    this(fluent, new PipelineResult());
  }
  
  public PipelineResultBuilder(PipelineResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineResultBuilder(PipelineResultFluent<?> fluent,PipelineResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineResult build() {
    PipelineResult buildable = new PipelineResult(fluent.getDescription(), fluent.getName(), fluent.getType(), fluent.buildValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}