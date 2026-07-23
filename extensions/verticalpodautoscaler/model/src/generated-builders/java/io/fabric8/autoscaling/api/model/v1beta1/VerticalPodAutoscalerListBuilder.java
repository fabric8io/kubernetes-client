package io.fabric8.autoscaling.api.model.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerListBuilder extends VerticalPodAutoscalerListFluent<VerticalPodAutoscalerListBuilder> implements VisitableBuilder<VerticalPodAutoscalerList,VerticalPodAutoscalerListBuilder>{

  VerticalPodAutoscalerListFluent<?> fluent;

  public VerticalPodAutoscalerListBuilder() {
    this(new VerticalPodAutoscalerList());
  }
  
  public VerticalPodAutoscalerListBuilder(VerticalPodAutoscalerListFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscalerList());
  }
  
  public VerticalPodAutoscalerListBuilder(VerticalPodAutoscalerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerListBuilder(VerticalPodAutoscalerListFluent<?> fluent,VerticalPodAutoscalerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscalerList build() {
    VerticalPodAutoscalerList buildable = new VerticalPodAutoscalerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}