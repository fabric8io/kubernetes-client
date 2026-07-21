package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerCheckpointSpecBuilder extends VerticalPodAutoscalerCheckpointSpecFluent<VerticalPodAutoscalerCheckpointSpecBuilder> implements VisitableBuilder<VerticalPodAutoscalerCheckpointSpec,VerticalPodAutoscalerCheckpointSpecBuilder>{

  VerticalPodAutoscalerCheckpointSpecFluent<?> fluent;

  public VerticalPodAutoscalerCheckpointSpecBuilder() {
    this(new VerticalPodAutoscalerCheckpointSpec());
  }
  
  public VerticalPodAutoscalerCheckpointSpecBuilder(VerticalPodAutoscalerCheckpointSpecFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscalerCheckpointSpec());
  }
  
  public VerticalPodAutoscalerCheckpointSpecBuilder(VerticalPodAutoscalerCheckpointSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerCheckpointSpecBuilder(VerticalPodAutoscalerCheckpointSpecFluent<?> fluent,VerticalPodAutoscalerCheckpointSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscalerCheckpointSpec build() {
    VerticalPodAutoscalerCheckpointSpec buildable = new VerticalPodAutoscalerCheckpointSpec(fluent.getContainerName(), fluent.getVpaObjectName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}