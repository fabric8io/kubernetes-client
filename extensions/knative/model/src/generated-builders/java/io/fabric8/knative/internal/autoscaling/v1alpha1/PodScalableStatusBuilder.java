package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodScalableStatusBuilder extends PodScalableStatusFluent<PodScalableStatusBuilder> implements VisitableBuilder<PodScalableStatus,PodScalableStatusBuilder>{

  PodScalableStatusFluent<?> fluent;

  public PodScalableStatusBuilder() {
    this(new PodScalableStatus());
  }
  
  public PodScalableStatusBuilder(PodScalableStatusFluent<?> fluent) {
    this(fluent, new PodScalableStatus());
  }
  
  public PodScalableStatusBuilder(PodScalableStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodScalableStatusBuilder(PodScalableStatusFluent<?> fluent,PodScalableStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodScalableStatus build() {
    PodScalableStatus buildable = new PodScalableStatus(fluent.getReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}