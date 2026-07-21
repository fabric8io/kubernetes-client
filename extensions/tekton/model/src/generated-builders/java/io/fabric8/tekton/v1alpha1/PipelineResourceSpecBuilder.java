package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineResourceSpecBuilder extends PipelineResourceSpecFluent<PipelineResourceSpecBuilder> implements VisitableBuilder<PipelineResourceSpec,PipelineResourceSpecBuilder>{

  PipelineResourceSpecFluent<?> fluent;

  public PipelineResourceSpecBuilder() {
    this(new PipelineResourceSpec());
  }
  
  public PipelineResourceSpecBuilder(PipelineResourceSpecFluent<?> fluent) {
    this(fluent, new PipelineResourceSpec());
  }
  
  public PipelineResourceSpecBuilder(PipelineResourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineResourceSpecBuilder(PipelineResourceSpecFluent<?> fluent,PipelineResourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineResourceSpec build() {
    PipelineResourceSpec buildable = new PipelineResourceSpec(fluent.getDescription(), fluent.buildParams(), fluent.buildSecrets(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}