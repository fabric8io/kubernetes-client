package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineRunStatusFieldsBuilder extends PipelineRunStatusFieldsFluent<PipelineRunStatusFieldsBuilder> implements VisitableBuilder<PipelineRunStatusFields,PipelineRunStatusFieldsBuilder>{

  PipelineRunStatusFieldsFluent<?> fluent;

  public PipelineRunStatusFieldsBuilder() {
    this(new PipelineRunStatusFields());
  }
  
  public PipelineRunStatusFieldsBuilder(PipelineRunStatusFieldsFluent<?> fluent) {
    this(fluent, new PipelineRunStatusFields());
  }
  
  public PipelineRunStatusFieldsBuilder(PipelineRunStatusFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineRunStatusFieldsBuilder(PipelineRunStatusFieldsFluent<?> fluent,PipelineRunStatusFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineRunStatusFields build() {
    PipelineRunStatusFields buildable = new PipelineRunStatusFields(fluent.buildChildReferences(), fluent.getCompletionTime(), fluent.getFinallyStartTime(), fluent.buildPipelineResults(), fluent.buildPipelineSpec(), fluent.buildProvenance(), fluent.getRuns(), fluent.buildSkippedTasks(), fluent.getSpanContext(), fluent.getStartTime(), fluent.getTaskRuns());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}