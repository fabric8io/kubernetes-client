package io.fabric8.autoscaling.api.model.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerConditionBuilder extends VerticalPodAutoscalerConditionFluent<VerticalPodAutoscalerConditionBuilder> implements VisitableBuilder<VerticalPodAutoscalerCondition,VerticalPodAutoscalerConditionBuilder>{

  VerticalPodAutoscalerConditionFluent<?> fluent;

  public VerticalPodAutoscalerConditionBuilder() {
    this(new VerticalPodAutoscalerCondition());
  }
  
  public VerticalPodAutoscalerConditionBuilder(VerticalPodAutoscalerConditionFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscalerCondition());
  }
  
  public VerticalPodAutoscalerConditionBuilder(VerticalPodAutoscalerCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerConditionBuilder(VerticalPodAutoscalerConditionFluent<?> fluent,VerticalPodAutoscalerCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscalerCondition build() {
    VerticalPodAutoscalerCondition buildable = new VerticalPodAutoscalerCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}