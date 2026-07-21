package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineResourceBuilder extends PipelineResourceFluent<PipelineResourceBuilder> implements VisitableBuilder<PipelineResource,PipelineResourceBuilder>{

  PipelineResourceFluent<?> fluent;

  public PipelineResourceBuilder() {
    this(new PipelineResource());
  }
  
  public PipelineResourceBuilder(PipelineResourceFluent<?> fluent) {
    this(fluent, new PipelineResource());
  }
  
  public PipelineResourceBuilder(PipelineResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineResourceBuilder(PipelineResourceFluent<?> fluent,PipelineResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineResource build() {
    PipelineResource buildable = new PipelineResource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}