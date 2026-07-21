package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineTaskResourcesBuilder extends PipelineTaskResourcesFluent<PipelineTaskResourcesBuilder> implements VisitableBuilder<PipelineTaskResources,PipelineTaskResourcesBuilder>{

  PipelineTaskResourcesFluent<?> fluent;

  public PipelineTaskResourcesBuilder() {
    this(new PipelineTaskResources());
  }
  
  public PipelineTaskResourcesBuilder(PipelineTaskResourcesFluent<?> fluent) {
    this(fluent, new PipelineTaskResources());
  }
  
  public PipelineTaskResourcesBuilder(PipelineTaskResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineTaskResourcesBuilder(PipelineTaskResourcesFluent<?> fluent,PipelineTaskResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineTaskResources build() {
    PipelineTaskResources buildable = new PipelineTaskResources(fluent.buildInputs(), fluent.buildOutputs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}