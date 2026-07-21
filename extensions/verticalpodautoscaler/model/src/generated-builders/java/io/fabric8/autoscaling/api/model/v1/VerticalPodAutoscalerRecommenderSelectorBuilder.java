package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerRecommenderSelectorBuilder extends VerticalPodAutoscalerRecommenderSelectorFluent<VerticalPodAutoscalerRecommenderSelectorBuilder> implements VisitableBuilder<VerticalPodAutoscalerRecommenderSelector,VerticalPodAutoscalerRecommenderSelectorBuilder>{

  VerticalPodAutoscalerRecommenderSelectorFluent<?> fluent;

  public VerticalPodAutoscalerRecommenderSelectorBuilder() {
    this(new VerticalPodAutoscalerRecommenderSelector());
  }
  
  public VerticalPodAutoscalerRecommenderSelectorBuilder(VerticalPodAutoscalerRecommenderSelectorFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscalerRecommenderSelector());
  }
  
  public VerticalPodAutoscalerRecommenderSelectorBuilder(VerticalPodAutoscalerRecommenderSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerRecommenderSelectorBuilder(VerticalPodAutoscalerRecommenderSelectorFluent<?> fluent,VerticalPodAutoscalerRecommenderSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscalerRecommenderSelector build() {
    VerticalPodAutoscalerRecommenderSelector buildable = new VerticalPodAutoscalerRecommenderSelector(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}