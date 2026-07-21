package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineRunTaskRunStatusBuilder extends PipelineRunTaskRunStatusFluent<PipelineRunTaskRunStatusBuilder> implements VisitableBuilder<PipelineRunTaskRunStatus,PipelineRunTaskRunStatusBuilder>{

  PipelineRunTaskRunStatusFluent<?> fluent;

  public PipelineRunTaskRunStatusBuilder() {
    this(new PipelineRunTaskRunStatus());
  }
  
  public PipelineRunTaskRunStatusBuilder(PipelineRunTaskRunStatusFluent<?> fluent) {
    this(fluent, new PipelineRunTaskRunStatus());
  }
  
  public PipelineRunTaskRunStatusBuilder(PipelineRunTaskRunStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineRunTaskRunStatusBuilder(PipelineRunTaskRunStatusFluent<?> fluent,PipelineRunTaskRunStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineRunTaskRunStatus build() {
    PipelineRunTaskRunStatus buildable = new PipelineRunTaskRunStatus(fluent.getPipelineTaskName(), fluent.buildStatus(), fluent.buildWhenExpressions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}