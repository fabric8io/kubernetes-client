package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodAutoscalerStatusBuilder extends PodAutoscalerStatusFluent<PodAutoscalerStatusBuilder> implements VisitableBuilder<PodAutoscalerStatus,PodAutoscalerStatusBuilder>{

  PodAutoscalerStatusFluent<?> fluent;

  public PodAutoscalerStatusBuilder() {
    this(new PodAutoscalerStatus());
  }
  
  public PodAutoscalerStatusBuilder(PodAutoscalerStatusFluent<?> fluent) {
    this(fluent, new PodAutoscalerStatus());
  }
  
  public PodAutoscalerStatusBuilder(PodAutoscalerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodAutoscalerStatusBuilder(PodAutoscalerStatusFluent<?> fluent,PodAutoscalerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodAutoscalerStatus build() {
    PodAutoscalerStatus buildable = new PodAutoscalerStatus(fluent.getActualScale(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getDesiredScale(), fluent.getMetricsServiceName(), fluent.getObservedGeneration(), fluent.getServiceName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}