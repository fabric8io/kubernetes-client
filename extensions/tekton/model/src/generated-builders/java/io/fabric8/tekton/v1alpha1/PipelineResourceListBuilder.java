package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineResourceListBuilder extends PipelineResourceListFluent<PipelineResourceListBuilder> implements VisitableBuilder<PipelineResourceList,PipelineResourceListBuilder>{

  PipelineResourceListFluent<?> fluent;

  public PipelineResourceListBuilder() {
    this(new PipelineResourceList());
  }
  
  public PipelineResourceListBuilder(PipelineResourceListFluent<?> fluent) {
    this(fluent, new PipelineResourceList());
  }
  
  public PipelineResourceListBuilder(PipelineResourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineResourceListBuilder(PipelineResourceListFluent<?> fluent,PipelineResourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineResourceList build() {
    PipelineResourceList buildable = new PipelineResourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}