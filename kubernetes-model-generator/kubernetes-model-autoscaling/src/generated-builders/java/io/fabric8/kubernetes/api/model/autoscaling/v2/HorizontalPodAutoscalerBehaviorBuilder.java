package io.fabric8.kubernetes.api.model.autoscaling.v2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HorizontalPodAutoscalerBehaviorBuilder extends HorizontalPodAutoscalerBehaviorFluent<HorizontalPodAutoscalerBehaviorBuilder> implements VisitableBuilder<HorizontalPodAutoscalerBehavior,HorizontalPodAutoscalerBehaviorBuilder>{

  HorizontalPodAutoscalerBehaviorFluent<?> fluent;

  public HorizontalPodAutoscalerBehaviorBuilder() {
    this(new HorizontalPodAutoscalerBehavior());
  }
  
  public HorizontalPodAutoscalerBehaviorBuilder(HorizontalPodAutoscalerBehaviorFluent<?> fluent) {
    this(fluent, new HorizontalPodAutoscalerBehavior());
  }
  
  public HorizontalPodAutoscalerBehaviorBuilder(HorizontalPodAutoscalerBehavior instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HorizontalPodAutoscalerBehaviorBuilder(HorizontalPodAutoscalerBehaviorFluent<?> fluent,HorizontalPodAutoscalerBehavior instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HorizontalPodAutoscalerBehavior build() {
    HorizontalPodAutoscalerBehavior buildable = new HorizontalPodAutoscalerBehavior(fluent.buildScaleDown(), fluent.buildScaleUp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}