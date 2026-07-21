package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineTaskOutputResourceBuilder extends PipelineTaskOutputResourceFluent<PipelineTaskOutputResourceBuilder> implements VisitableBuilder<PipelineTaskOutputResource,PipelineTaskOutputResourceBuilder>{

  PipelineTaskOutputResourceFluent<?> fluent;

  public PipelineTaskOutputResourceBuilder() {
    this(new PipelineTaskOutputResource());
  }
  
  public PipelineTaskOutputResourceBuilder(PipelineTaskOutputResourceFluent<?> fluent) {
    this(fluent, new PipelineTaskOutputResource());
  }
  
  public PipelineTaskOutputResourceBuilder(PipelineTaskOutputResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineTaskOutputResourceBuilder(PipelineTaskOutputResourceFluent<?> fluent,PipelineTaskOutputResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineTaskOutputResource build() {
    PipelineTaskOutputResource buildable = new PipelineTaskOutputResource(fluent.getName(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}