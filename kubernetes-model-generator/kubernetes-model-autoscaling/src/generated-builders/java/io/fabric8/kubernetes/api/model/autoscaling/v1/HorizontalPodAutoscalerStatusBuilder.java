package io.fabric8.kubernetes.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HorizontalPodAutoscalerStatusBuilder extends HorizontalPodAutoscalerStatusFluent<HorizontalPodAutoscalerStatusBuilder> implements VisitableBuilder<HorizontalPodAutoscalerStatus,HorizontalPodAutoscalerStatusBuilder>{

  HorizontalPodAutoscalerStatusFluent<?> fluent;

  public HorizontalPodAutoscalerStatusBuilder() {
    this(new HorizontalPodAutoscalerStatus());
  }
  
  public HorizontalPodAutoscalerStatusBuilder(HorizontalPodAutoscalerStatusFluent<?> fluent) {
    this(fluent, new HorizontalPodAutoscalerStatus());
  }
  
  public HorizontalPodAutoscalerStatusBuilder(HorizontalPodAutoscalerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HorizontalPodAutoscalerStatusBuilder(HorizontalPodAutoscalerStatusFluent<?> fluent,HorizontalPodAutoscalerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HorizontalPodAutoscalerStatus build() {
    HorizontalPodAutoscalerStatus buildable = new HorizontalPodAutoscalerStatus(fluent.getCurrentCPUUtilizationPercentage(), fluent.getCurrentReplicas(), fluent.getDesiredReplicas(), fluent.getLastScaleTime(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}