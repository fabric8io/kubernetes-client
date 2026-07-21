package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineTaskRunSpecBuilder extends PipelineTaskRunSpecFluent<PipelineTaskRunSpecBuilder> implements VisitableBuilder<PipelineTaskRunSpec,PipelineTaskRunSpecBuilder>{

  PipelineTaskRunSpecFluent<?> fluent;

  public PipelineTaskRunSpecBuilder() {
    this(new PipelineTaskRunSpec());
  }
  
  public PipelineTaskRunSpecBuilder(PipelineTaskRunSpecFluent<?> fluent) {
    this(fluent, new PipelineTaskRunSpec());
  }
  
  public PipelineTaskRunSpecBuilder(PipelineTaskRunSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineTaskRunSpecBuilder(PipelineTaskRunSpecFluent<?> fluent,PipelineTaskRunSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineTaskRunSpec build() {
    PipelineTaskRunSpec buildable = new PipelineTaskRunSpec(fluent.buildComputeResources(), fluent.buildMetadata(), fluent.getPipelineTaskName(), fluent.buildSidecarOverrides(), fluent.buildStepOverrides(), fluent.buildTaskPodTemplate(), fluent.getTaskServiceAccountName(), fluent.getTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}