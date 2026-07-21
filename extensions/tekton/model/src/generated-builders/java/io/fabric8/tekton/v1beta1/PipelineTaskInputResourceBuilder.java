package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineTaskInputResourceBuilder extends PipelineTaskInputResourceFluent<PipelineTaskInputResourceBuilder> implements VisitableBuilder<PipelineTaskInputResource,PipelineTaskInputResourceBuilder>{

  PipelineTaskInputResourceFluent<?> fluent;

  public PipelineTaskInputResourceBuilder() {
    this(new PipelineTaskInputResource());
  }
  
  public PipelineTaskInputResourceBuilder(PipelineTaskInputResourceFluent<?> fluent) {
    this(fluent, new PipelineTaskInputResource());
  }
  
  public PipelineTaskInputResourceBuilder(PipelineTaskInputResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineTaskInputResourceBuilder(PipelineTaskInputResourceFluent<?> fluent,PipelineTaskInputResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineTaskInputResource build() {
    PipelineTaskInputResource buildable = new PipelineTaskInputResource(fluent.getFrom(), fluent.getName(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}