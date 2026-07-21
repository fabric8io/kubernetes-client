package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineRunResultBuilder extends PipelineRunResultFluent<PipelineRunResultBuilder> implements VisitableBuilder<PipelineRunResult,PipelineRunResultBuilder>{

  PipelineRunResultFluent<?> fluent;

  public PipelineRunResultBuilder() {
    this(new PipelineRunResult());
  }
  
  public PipelineRunResultBuilder(PipelineRunResultFluent<?> fluent) {
    this(fluent, new PipelineRunResult());
  }
  
  public PipelineRunResultBuilder(PipelineRunResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineRunResultBuilder(PipelineRunResultFluent<?> fluent,PipelineRunResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineRunResult build() {
    PipelineRunResult buildable = new PipelineRunResult(fluent.getName(), fluent.buildValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}