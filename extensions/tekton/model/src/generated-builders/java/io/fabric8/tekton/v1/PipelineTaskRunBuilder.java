package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineTaskRunBuilder extends PipelineTaskRunFluent<PipelineTaskRunBuilder> implements VisitableBuilder<PipelineTaskRun,PipelineTaskRunBuilder>{

  PipelineTaskRunFluent<?> fluent;

  public PipelineTaskRunBuilder() {
    this(new PipelineTaskRun());
  }
  
  public PipelineTaskRunBuilder(PipelineTaskRunFluent<?> fluent) {
    this(fluent, new PipelineTaskRun());
  }
  
  public PipelineTaskRunBuilder(PipelineTaskRun instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineTaskRunBuilder(PipelineTaskRunFluent<?> fluent,PipelineTaskRun instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineTaskRun build() {
    PipelineTaskRun buildable = new PipelineTaskRun(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}