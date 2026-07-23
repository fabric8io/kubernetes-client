package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineSpecBuilder extends PipelineSpecFluent<PipelineSpecBuilder> implements VisitableBuilder<PipelineSpec,PipelineSpecBuilder>{

  PipelineSpecFluent<?> fluent;

  public PipelineSpecBuilder() {
    this(new PipelineSpec());
  }
  
  public PipelineSpecBuilder(PipelineSpecFluent<?> fluent) {
    this(fluent, new PipelineSpec());
  }
  
  public PipelineSpecBuilder(PipelineSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineSpecBuilder(PipelineSpecFluent<?> fluent,PipelineSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineSpec build() {
    PipelineSpec buildable = new PipelineSpec(fluent.getDescription(), fluent.getDisplayName(), fluent.buildFinally(), fluent.buildParams(), fluent.buildResources(), fluent.buildResults(), fluent.buildTasks(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}