package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodScalableBuilder extends PodScalableFluent<PodScalableBuilder> implements VisitableBuilder<PodScalable,PodScalableBuilder>{

  PodScalableFluent<?> fluent;

  public PodScalableBuilder() {
    this(new PodScalable());
  }
  
  public PodScalableBuilder(PodScalableFluent<?> fluent) {
    this(fluent, new PodScalable());
  }
  
  public PodScalableBuilder(PodScalable instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodScalableBuilder(PodScalableFluent<?> fluent,PodScalable instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodScalable build() {
    PodScalable buildable = new PodScalable(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}