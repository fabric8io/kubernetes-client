package io.fabric8.kubernetes.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HorizontalPodAutoscalerBuilder extends HorizontalPodAutoscalerFluent<HorizontalPodAutoscalerBuilder> implements VisitableBuilder<HorizontalPodAutoscaler,HorizontalPodAutoscalerBuilder>{

  HorizontalPodAutoscalerFluent<?> fluent;

  public HorizontalPodAutoscalerBuilder() {
    this(new HorizontalPodAutoscaler());
  }
  
  public HorizontalPodAutoscalerBuilder(HorizontalPodAutoscalerFluent<?> fluent) {
    this(fluent, new HorizontalPodAutoscaler());
  }
  
  public HorizontalPodAutoscalerBuilder(HorizontalPodAutoscaler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HorizontalPodAutoscalerBuilder(HorizontalPodAutoscalerFluent<?> fluent,HorizontalPodAutoscaler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HorizontalPodAutoscaler build() {
    HorizontalPodAutoscaler buildable = new HorizontalPodAutoscaler(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}