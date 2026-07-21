package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineRunListBuilder extends PipelineRunListFluent<PipelineRunListBuilder> implements VisitableBuilder<PipelineRunList,PipelineRunListBuilder>{

  PipelineRunListFluent<?> fluent;

  public PipelineRunListBuilder() {
    this(new PipelineRunList());
  }
  
  public PipelineRunListBuilder(PipelineRunListFluent<?> fluent) {
    this(fluent, new PipelineRunList());
  }
  
  public PipelineRunListBuilder(PipelineRunList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineRunListBuilder(PipelineRunListFluent<?> fluent,PipelineRunList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineRunList build() {
    PipelineRunList buildable = new PipelineRunList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}