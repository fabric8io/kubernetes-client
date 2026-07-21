package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodBuilder extends PodFluent<PodBuilder> implements VisitableBuilder<Pod,PodBuilder>{

  PodFluent<?> fluent;

  public PodBuilder() {
    this(new Pod());
  }
  
  public PodBuilder(PodFluent<?> fluent) {
    this(fluent, new Pod());
  }
  
  public PodBuilder(Pod instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodBuilder(PodFluent<?> fluent,Pod instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Pod build() {
    Pod buildable = new Pod(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.getSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}