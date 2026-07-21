package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodAutoscalerListBuilder extends PodAutoscalerListFluent<PodAutoscalerListBuilder> implements VisitableBuilder<PodAutoscalerList,PodAutoscalerListBuilder>{

  PodAutoscalerListFluent<?> fluent;

  public PodAutoscalerListBuilder() {
    this(new PodAutoscalerList());
  }
  
  public PodAutoscalerListBuilder(PodAutoscalerListFluent<?> fluent) {
    this(fluent, new PodAutoscalerList());
  }
  
  public PodAutoscalerListBuilder(PodAutoscalerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodAutoscalerListBuilder(PodAutoscalerListFluent<?> fluent,PodAutoscalerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodAutoscalerList build() {
    PodAutoscalerList buildable = new PodAutoscalerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}