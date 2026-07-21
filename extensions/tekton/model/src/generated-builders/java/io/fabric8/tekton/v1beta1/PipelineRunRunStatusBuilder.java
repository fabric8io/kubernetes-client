package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineRunRunStatusBuilder extends PipelineRunRunStatusFluent<PipelineRunRunStatusBuilder> implements VisitableBuilder<PipelineRunRunStatus,PipelineRunRunStatusBuilder>{

  PipelineRunRunStatusFluent<?> fluent;

  public PipelineRunRunStatusBuilder() {
    this(new PipelineRunRunStatus());
  }
  
  public PipelineRunRunStatusBuilder(PipelineRunRunStatusFluent<?> fluent) {
    this(fluent, new PipelineRunRunStatus());
  }
  
  public PipelineRunRunStatusBuilder(PipelineRunRunStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineRunRunStatusBuilder(PipelineRunRunStatusFluent<?> fluent,PipelineRunRunStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineRunRunStatus build() {
    PipelineRunRunStatus buildable = new PipelineRunRunStatus(fluent.getPipelineTaskName(), fluent.buildStatus(), fluent.buildWhenExpressions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}