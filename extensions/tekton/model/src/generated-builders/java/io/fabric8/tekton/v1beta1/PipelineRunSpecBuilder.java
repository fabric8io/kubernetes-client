package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineRunSpecBuilder extends PipelineRunSpecFluent<PipelineRunSpecBuilder> implements VisitableBuilder<PipelineRunSpec,PipelineRunSpecBuilder>{

  PipelineRunSpecFluent<?> fluent;

  public PipelineRunSpecBuilder() {
    this(new PipelineRunSpec());
  }
  
  public PipelineRunSpecBuilder(PipelineRunSpecFluent<?> fluent) {
    this(fluent, new PipelineRunSpec());
  }
  
  public PipelineRunSpecBuilder(PipelineRunSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineRunSpecBuilder(PipelineRunSpecFluent<?> fluent,PipelineRunSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineRunSpec build() {
    PipelineRunSpec buildable = new PipelineRunSpec(fluent.getManagedBy(), fluent.buildParams(), fluent.buildPipelineRef(), fluent.buildPipelineSpec(), fluent.buildPodTemplate(), fluent.buildResources(), fluent.getServiceAccountName(), fluent.getStatus(), fluent.buildTaskRunSpecs(), fluent.getTimeout(), fluent.buildTimeouts(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}