package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineDeclaredResourceBuilder extends PipelineDeclaredResourceFluent<PipelineDeclaredResourceBuilder> implements VisitableBuilder<PipelineDeclaredResource,PipelineDeclaredResourceBuilder>{

  PipelineDeclaredResourceFluent<?> fluent;

  public PipelineDeclaredResourceBuilder() {
    this(new PipelineDeclaredResource());
  }
  
  public PipelineDeclaredResourceBuilder(PipelineDeclaredResourceFluent<?> fluent) {
    this(fluent, new PipelineDeclaredResource());
  }
  
  public PipelineDeclaredResourceBuilder(PipelineDeclaredResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineDeclaredResourceBuilder(PipelineDeclaredResourceFluent<?> fluent,PipelineDeclaredResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineDeclaredResource build() {
    PipelineDeclaredResource buildable = new PipelineDeclaredResource(fluent.getName(), fluent.getOptional(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}