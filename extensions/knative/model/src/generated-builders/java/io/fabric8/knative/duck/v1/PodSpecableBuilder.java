package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSpecableBuilder extends PodSpecableFluent<PodSpecableBuilder> implements VisitableBuilder<PodSpecable,PodSpecableBuilder>{

  PodSpecableFluent<?> fluent;

  public PodSpecableBuilder() {
    this(new PodSpecable());
  }
  
  public PodSpecableBuilder(PodSpecableFluent<?> fluent) {
    this(fluent, new PodSpecable());
  }
  
  public PodSpecableBuilder(PodSpecable instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSpecableBuilder(PodSpecableFluent<?> fluent,PodSpecable instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSpecable build() {
    PodSpecable buildable = new PodSpecable(fluent.buildMetadata(), fluent.getSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}