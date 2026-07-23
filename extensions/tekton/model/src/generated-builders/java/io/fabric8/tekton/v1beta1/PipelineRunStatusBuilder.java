package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineRunStatusBuilder extends PipelineRunStatusFluent<PipelineRunStatusBuilder> implements VisitableBuilder<PipelineRunStatus,PipelineRunStatusBuilder>{

  PipelineRunStatusFluent<?> fluent;

  public PipelineRunStatusBuilder() {
    this(new PipelineRunStatus());
  }
  
  public PipelineRunStatusBuilder(PipelineRunStatusFluent<?> fluent) {
    this(fluent, new PipelineRunStatus());
  }
  
  public PipelineRunStatusBuilder(PipelineRunStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineRunStatusBuilder(PipelineRunStatusFluent<?> fluent,PipelineRunStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineRunStatus build() {
    PipelineRunStatus buildable = new PipelineRunStatus(fluent.getAnnotations(), fluent.buildChildReferences(), fluent.getCompletionTime(), fluent.getConditions(), fluent.getFinallyStartTime(), fluent.getObservedGeneration(), fluent.buildPipelineResults(), fluent.buildPipelineSpec(), fluent.buildProvenance(), fluent.getRuns(), fluent.buildSkippedTasks(), fluent.getSpanContext(), fluent.getStartTime(), fluent.getTaskRuns());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}