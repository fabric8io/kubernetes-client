package io.fabric8.autoscaling.api.model.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerCheckpointBuilder extends VerticalPodAutoscalerCheckpointFluent<VerticalPodAutoscalerCheckpointBuilder> implements VisitableBuilder<VerticalPodAutoscalerCheckpoint,VerticalPodAutoscalerCheckpointBuilder>{

  VerticalPodAutoscalerCheckpointFluent<?> fluent;

  public VerticalPodAutoscalerCheckpointBuilder() {
    this(new VerticalPodAutoscalerCheckpoint());
  }
  
  public VerticalPodAutoscalerCheckpointBuilder(VerticalPodAutoscalerCheckpointFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscalerCheckpoint());
  }
  
  public VerticalPodAutoscalerCheckpointBuilder(VerticalPodAutoscalerCheckpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerCheckpointBuilder(VerticalPodAutoscalerCheckpointFluent<?> fluent,VerticalPodAutoscalerCheckpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscalerCheckpoint build() {
    VerticalPodAutoscalerCheckpoint buildable = new VerticalPodAutoscalerCheckpoint(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}