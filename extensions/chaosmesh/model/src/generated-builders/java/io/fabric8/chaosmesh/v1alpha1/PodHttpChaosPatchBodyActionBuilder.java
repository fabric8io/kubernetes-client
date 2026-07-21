package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosPatchBodyActionBuilder extends PodHttpChaosPatchBodyActionFluent<PodHttpChaosPatchBodyActionBuilder> implements VisitableBuilder<PodHttpChaosPatchBodyAction,PodHttpChaosPatchBodyActionBuilder>{

  PodHttpChaosPatchBodyActionFluent<?> fluent;

  public PodHttpChaosPatchBodyActionBuilder() {
    this(new PodHttpChaosPatchBodyAction());
  }
  
  public PodHttpChaosPatchBodyActionBuilder(PodHttpChaosPatchBodyActionFluent<?> fluent) {
    this(fluent, new PodHttpChaosPatchBodyAction());
  }
  
  public PodHttpChaosPatchBodyActionBuilder(PodHttpChaosPatchBodyAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosPatchBodyActionBuilder(PodHttpChaosPatchBodyActionFluent<?> fluent,PodHttpChaosPatchBodyAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosPatchBodyAction build() {
    PodHttpChaosPatchBodyAction buildable = new PodHttpChaosPatchBodyAction(fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}