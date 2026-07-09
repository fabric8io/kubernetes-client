package io.fabric8.kubernetes.api.model.autoscaling.v1;

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
    HorizontalPodAutoscalerSpec buildable = new HorizontalPodAutoscalerSpec(fluent.getMaxReplicas(), fluent.getMinReplicas(), fluent.buildScaleTargetRef(), fluent.getTargetCPUUtilizationPercentage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}