package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HorizontalPodAutoscalerConditionBuilder extends HorizontalPodAutoscalerConditionFluent<HorizontalPodAutoscalerConditionBuilder> implements VisitableBuilder<HorizontalPodAutoscalerCondition,HorizontalPodAutoscalerConditionBuilder>{

  HorizontalPodAutoscalerConditionFluent<?> fluent;

  public HorizontalPodAutoscalerConditionBuilder() {
    this(new HorizontalPodAutoscalerCondition());
  }
  
  public HorizontalPodAutoscalerConditionBuilder(HorizontalPodAutoscalerConditionFluent<?> fluent) {
    this(fluent, new HorizontalPodAutoscalerCondition());
  }
  
  public HorizontalPodAutoscalerConditionBuilder(HorizontalPodAutoscalerCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HorizontalPodAutoscalerConditionBuilder(HorizontalPodAutoscalerConditionFluent<?> fluent,HorizontalPodAutoscalerCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HorizontalPodAutoscalerCondition build() {
    HorizontalPodAutoscalerCondition buildable = new HorizontalPodAutoscalerCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}