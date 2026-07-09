package io.fabric8.kubernetes.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HorizontalPodAutoscalerListBuilder extends HorizontalPodAutoscalerListFluent<HorizontalPodAutoscalerListBuilder> implements VisitableBuilder<HorizontalPodAutoscalerList,HorizontalPodAutoscalerListBuilder>{

  HorizontalPodAutoscalerListFluent<?> fluent;

  public HorizontalPodAutoscalerListBuilder() {
    this(new HorizontalPodAutoscalerList());
  }
  
  public HorizontalPodAutoscalerListBuilder(HorizontalPodAutoscalerListFluent<?> fluent) {
    this(fluent, new HorizontalPodAutoscalerList());
  }
  
  public HorizontalPodAutoscalerListBuilder(HorizontalPodAutoscalerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HorizontalPodAutoscalerListBuilder(HorizontalPodAutoscalerListFluent<?> fluent,HorizontalPodAutoscalerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HorizontalPodAutoscalerList build() {
    HorizontalPodAutoscalerList buildable = new HorizontalPodAutoscalerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}