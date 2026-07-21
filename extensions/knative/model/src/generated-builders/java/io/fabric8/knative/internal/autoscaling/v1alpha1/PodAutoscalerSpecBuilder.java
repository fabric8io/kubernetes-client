package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodAutoscalerSpecBuilder extends PodAutoscalerSpecFluent<PodAutoscalerSpecBuilder> implements VisitableBuilder<PodAutoscalerSpec,PodAutoscalerSpecBuilder>{

  PodAutoscalerSpecFluent<?> fluent;

  public PodAutoscalerSpecBuilder() {
    this(new PodAutoscalerSpec());
  }
  
  public PodAutoscalerSpecBuilder(PodAutoscalerSpecFluent<?> fluent) {
    this(fluent, new PodAutoscalerSpec());
  }
  
  public PodAutoscalerSpecBuilder(PodAutoscalerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodAutoscalerSpecBuilder(PodAutoscalerSpecFluent<?> fluent,PodAutoscalerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodAutoscalerSpec build() {
    PodAutoscalerSpec buildable = new PodAutoscalerSpec(fluent.getContainerConcurrency(), fluent.getProtocolType(), fluent.getReachability(), fluent.buildScaleTargetRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}