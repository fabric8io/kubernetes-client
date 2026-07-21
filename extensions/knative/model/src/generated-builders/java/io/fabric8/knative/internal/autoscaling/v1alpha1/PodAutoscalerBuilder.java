package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodAutoscalerBuilder extends PodAutoscalerFluent<PodAutoscalerBuilder> implements VisitableBuilder<PodAutoscaler,PodAutoscalerBuilder>{

  PodAutoscalerFluent<?> fluent;

  public PodAutoscalerBuilder() {
    this(new PodAutoscaler());
  }
  
  public PodAutoscalerBuilder(PodAutoscalerFluent<?> fluent) {
    this(fluent, new PodAutoscaler());
  }
  
  public PodAutoscalerBuilder(PodAutoscaler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodAutoscalerBuilder(PodAutoscalerFluent<?> fluent,PodAutoscaler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodAutoscaler build() {
    PodAutoscaler buildable = new PodAutoscaler(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}