package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineResourceStatusBuilder extends PipelineResourceStatusFluent<PipelineResourceStatusBuilder> implements VisitableBuilder<PipelineResourceStatus,PipelineResourceStatusBuilder>{

  PipelineResourceStatusFluent<?> fluent;

  public PipelineResourceStatusBuilder() {
    this(new PipelineResourceStatus());
  }
  
  public PipelineResourceStatusBuilder(PipelineResourceStatusFluent<?> fluent) {
    this(fluent, new PipelineResourceStatus());
  }
  
  public PipelineResourceStatusBuilder(PipelineResourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineResourceStatusBuilder(PipelineResourceStatusFluent<?> fluent,PipelineResourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineResourceStatus build() {
    PipelineResourceStatus buildable = new PipelineResourceStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}