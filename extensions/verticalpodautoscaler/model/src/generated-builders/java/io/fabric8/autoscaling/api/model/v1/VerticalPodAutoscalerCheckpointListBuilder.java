package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerCheckpointListBuilder extends VerticalPodAutoscalerCheckpointListFluent<VerticalPodAutoscalerCheckpointListBuilder> implements VisitableBuilder<VerticalPodAutoscalerCheckpointList,VerticalPodAutoscalerCheckpointListBuilder>{

  VerticalPodAutoscalerCheckpointListFluent<?> fluent;

  public VerticalPodAutoscalerCheckpointListBuilder() {
    this(new VerticalPodAutoscalerCheckpointList());
  }
  
  public VerticalPodAutoscalerCheckpointListBuilder(VerticalPodAutoscalerCheckpointListFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscalerCheckpointList());
  }
  
  public VerticalPodAutoscalerCheckpointListBuilder(VerticalPodAutoscalerCheckpointList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerCheckpointListBuilder(VerticalPodAutoscalerCheckpointListFluent<?> fluent,VerticalPodAutoscalerCheckpointList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscalerCheckpointList build() {
    VerticalPodAutoscalerCheckpointList buildable = new VerticalPodAutoscalerCheckpointList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}