package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineRefBuilder extends PipelineRefFluent<PipelineRefBuilder> implements VisitableBuilder<PipelineRef,PipelineRefBuilder>{

  PipelineRefFluent<?> fluent;

  public PipelineRefBuilder() {
    this(new PipelineRef());
  }
  
  public PipelineRefBuilder(PipelineRefFluent<?> fluent) {
    this(fluent, new PipelineRef());
  }
  
  public PipelineRefBuilder(PipelineRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineRefBuilder(PipelineRefFluent<?> fluent,PipelineRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineRef build() {
    PipelineRef buildable = new PipelineRef(fluent.getApiVersion(), fluent.getName(), fluent.buildParams(), fluent.getResolver());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}