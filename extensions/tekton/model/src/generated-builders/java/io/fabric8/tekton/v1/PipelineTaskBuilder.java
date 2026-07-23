package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineTaskBuilder extends PipelineTaskFluent<PipelineTaskBuilder> implements VisitableBuilder<PipelineTask,PipelineTaskBuilder>{

  PipelineTaskFluent<?> fluent;

  public PipelineTaskBuilder() {
    this(new PipelineTask());
  }
  
  public PipelineTaskBuilder(PipelineTaskFluent<?> fluent) {
    this(fluent, new PipelineTask());
  }
  
  public PipelineTaskBuilder(PipelineTask instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineTaskBuilder(PipelineTaskFluent<?> fluent,PipelineTask instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineTask build() {
    PipelineTask buildable = new PipelineTask(fluent.getDescription(), fluent.getDisplayName(), fluent.buildMatrix(), fluent.getName(), fluent.getOnError(), fluent.buildParams(), fluent.buildPipelineRef(), fluent.buildPipelineSpec(), fluent.getRetries(), fluent.getRunAfter(), fluent.buildTaskRef(), fluent.buildTaskSpec(), fluent.getTimeout(), fluent.buildWhen(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}