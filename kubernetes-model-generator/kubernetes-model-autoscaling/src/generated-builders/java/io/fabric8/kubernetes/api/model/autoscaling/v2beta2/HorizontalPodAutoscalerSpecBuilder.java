package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HorizontalPodAutoscalerSpecBuilder extends HorizontalPodAutoscalerSpecFluent<HorizontalPodAutoscalerSpecBuilder> implements VisitableBuilder<HorizontalPodAutoscalerSpec,HorizontalPodAutoscalerSpecBuilder>{

  HorizontalPodAutoscalerSpecFluent<?> fluent;

  public HorizontalPodAutoscalerSpecBuilder() {
    this(new HorizontalPodAutoscalerSpec());
  }
  
  public HorizontalPodAutoscalerSpecBuilder(HorizontalPodAutoscalerSpecFluent<?> fluent) {
    this(fluent, new HorizontalPodAutoscalerSpec());
  }
  
  public HorizontalPodAutoscalerSpecBuilder(HorizontalPodAutoscalerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HorizontalPodAutoscalerSpecBuilder(HorizontalPodAutoscalerSpecFluent<?> fluent,HorizontalPodAutoscalerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HorizontalPodAutoscalerSpec build() {
    HorizontalPodAutoscalerSpec buildable = new HorizontalPodAutoscalerSpec(fluent.buildBehavior(), fluent.getMaxReplicas(), fluent.buildMetrics(), fluent.getMinReplicas(), fluent.buildScaleTargetRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}