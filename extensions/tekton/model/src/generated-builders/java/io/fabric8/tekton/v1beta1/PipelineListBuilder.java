package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineListBuilder extends PipelineListFluent<PipelineListBuilder> implements VisitableBuilder<PipelineList,PipelineListBuilder>{

  PipelineListFluent<?> fluent;

  public PipelineListBuilder() {
    this(new PipelineList());
  }
  
  public PipelineListBuilder(PipelineListFluent<?> fluent) {
    this(fluent, new PipelineList());
  }
  
  public PipelineListBuilder(PipelineList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineListBuilder(PipelineListFluent<?> fluent,PipelineList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineList build() {
    PipelineList buildable = new PipelineList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}