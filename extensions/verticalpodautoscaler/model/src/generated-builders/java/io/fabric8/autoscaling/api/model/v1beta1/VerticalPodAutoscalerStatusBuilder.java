package io.fabric8.autoscaling.api.model.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerStatusBuilder extends VerticalPodAutoscalerStatusFluent<VerticalPodAutoscalerStatusBuilder> implements VisitableBuilder<VerticalPodAutoscalerStatus,VerticalPodAutoscalerStatusBuilder>{

  VerticalPodAutoscalerStatusFluent<?> fluent;

  public VerticalPodAutoscalerStatusBuilder() {
    this(new VerticalPodAutoscalerStatus());
  }
  
  public VerticalPodAutoscalerStatusBuilder(VerticalPodAutoscalerStatusFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscalerStatus());
  }
  
  public VerticalPodAutoscalerStatusBuilder(VerticalPodAutoscalerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerStatusBuilder(VerticalPodAutoscalerStatusFluent<?> fluent,VerticalPodAutoscalerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscalerStatus build() {
    VerticalPodAutoscalerStatus buildable = new VerticalPodAutoscalerStatus(fluent.buildConditions(), fluent.buildRecommendation());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}