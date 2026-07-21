package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineResourceRefBuilder extends PipelineResourceRefFluent<PipelineResourceRefBuilder> implements VisitableBuilder<PipelineResourceRef,PipelineResourceRefBuilder>{

  PipelineResourceRefFluent<?> fluent;

  public PipelineResourceRefBuilder() {
    this(new PipelineResourceRef());
  }
  
  public PipelineResourceRefBuilder(PipelineResourceRefFluent<?> fluent) {
    this(fluent, new PipelineResourceRef());
  }
  
  public PipelineResourceRefBuilder(PipelineResourceRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineResourceRefBuilder(PipelineResourceRefFluent<?> fluent,PipelineResourceRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineResourceRef build() {
    PipelineResourceRef buildable = new PipelineResourceRef(fluent.getApiVersion(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}