package io.fabric8.autoscaling.api.model.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerBuilder extends VerticalPodAutoscalerFluent<VerticalPodAutoscalerBuilder> implements VisitableBuilder<VerticalPodAutoscaler,VerticalPodAutoscalerBuilder>{

  VerticalPodAutoscalerFluent<?> fluent;

  public VerticalPodAutoscalerBuilder() {
    this(new VerticalPodAutoscaler());
  }
  
  public VerticalPodAutoscalerBuilder(VerticalPodAutoscalerFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscaler());
  }
  
  public VerticalPodAutoscalerBuilder(VerticalPodAutoscaler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerBuilder(VerticalPodAutoscalerFluent<?> fluent,VerticalPodAutoscaler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscaler build() {
    VerticalPodAutoscaler buildable = new VerticalPodAutoscaler(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}