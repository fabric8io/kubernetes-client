package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSchedulingContextListBuilder extends PodSchedulingContextListFluent<PodSchedulingContextListBuilder> implements VisitableBuilder<PodSchedulingContextList,PodSchedulingContextListBuilder>{

  PodSchedulingContextListFluent<?> fluent;

  public PodSchedulingContextListBuilder() {
    this(new PodSchedulingContextList());
  }
  
  public PodSchedulingContextListBuilder(PodSchedulingContextListFluent<?> fluent) {
    this(fluent, new PodSchedulingContextList());
  }
  
  public PodSchedulingContextListBuilder(PodSchedulingContextList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSchedulingContextListBuilder(PodSchedulingContextListFluent<?> fluent,PodSchedulingContextList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSchedulingContextList build() {
    PodSchedulingContextList buildable = new PodSchedulingContextList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}