package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineBuilder extends PipelineFluent<PipelineBuilder> implements VisitableBuilder<Pipeline,PipelineBuilder>{

  PipelineFluent<?> fluent;

  public PipelineBuilder() {
    this(new Pipeline());
  }
  
  public PipelineBuilder(PipelineFluent<?> fluent) {
    this(fluent, new Pipeline());
  }
  
  public PipelineBuilder(Pipeline instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineBuilder(PipelineFluent<?> fluent,Pipeline instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Pipeline build() {
    Pipeline buildable = new Pipeline(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}