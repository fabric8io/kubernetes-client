package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSchedulingContextStatusBuilder extends PodSchedulingContextStatusFluent<PodSchedulingContextStatusBuilder> implements VisitableBuilder<PodSchedulingContextStatus,PodSchedulingContextStatusBuilder>{

  PodSchedulingContextStatusFluent<?> fluent;

  public PodSchedulingContextStatusBuilder() {
    this(new PodSchedulingContextStatus());
  }
  
  public PodSchedulingContextStatusBuilder(PodSchedulingContextStatusFluent<?> fluent) {
    this(fluent, new PodSchedulingContextStatus());
  }
  
  public PodSchedulingContextStatusBuilder(PodSchedulingContextStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSchedulingContextStatusBuilder(PodSchedulingContextStatusFluent<?> fluent,PodSchedulingContextStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSchedulingContextStatus build() {
    PodSchedulingContextStatus buildable = new PodSchedulingContextStatus(fluent.buildResourceClaims());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}