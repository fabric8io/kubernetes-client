package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerSpecBuilder extends VerticalPodAutoscalerSpecFluent<VerticalPodAutoscalerSpecBuilder> implements VisitableBuilder<VerticalPodAutoscalerSpec,VerticalPodAutoscalerSpecBuilder>{

  VerticalPodAutoscalerSpecFluent<?> fluent;

  public VerticalPodAutoscalerSpecBuilder() {
    this(new VerticalPodAutoscalerSpec());
  }
  
  public VerticalPodAutoscalerSpecBuilder(VerticalPodAutoscalerSpecFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscalerSpec());
  }
  
  public VerticalPodAutoscalerSpecBuilder(VerticalPodAutoscalerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerSpecBuilder(VerticalPodAutoscalerSpecFluent<?> fluent,VerticalPodAutoscalerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscalerSpec build() {
    VerticalPodAutoscalerSpec buildable = new VerticalPodAutoscalerSpec(fluent.buildRecommenders(), fluent.buildResourcePolicy(), fluent.buildStartupBoost(), fluent.getTargetRef(), fluent.buildUpdatePolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}