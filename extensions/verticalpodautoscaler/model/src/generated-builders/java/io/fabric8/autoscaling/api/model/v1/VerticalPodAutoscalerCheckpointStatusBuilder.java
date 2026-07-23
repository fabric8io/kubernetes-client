package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerticalPodAutoscalerCheckpointStatusBuilder extends VerticalPodAutoscalerCheckpointStatusFluent<VerticalPodAutoscalerCheckpointStatusBuilder> implements VisitableBuilder<VerticalPodAutoscalerCheckpointStatus,VerticalPodAutoscalerCheckpointStatusBuilder>{

  VerticalPodAutoscalerCheckpointStatusFluent<?> fluent;

  public VerticalPodAutoscalerCheckpointStatusBuilder() {
    this(new VerticalPodAutoscalerCheckpointStatus());
  }
  
  public VerticalPodAutoscalerCheckpointStatusBuilder(VerticalPodAutoscalerCheckpointStatusFluent<?> fluent) {
    this(fluent, new VerticalPodAutoscalerCheckpointStatus());
  }
  
  public VerticalPodAutoscalerCheckpointStatusBuilder(VerticalPodAutoscalerCheckpointStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerticalPodAutoscalerCheckpointStatusBuilder(VerticalPodAutoscalerCheckpointStatusFluent<?> fluent,VerticalPodAutoscalerCheckpointStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerticalPodAutoscalerCheckpointStatus build() {
    VerticalPodAutoscalerCheckpointStatus buildable = new VerticalPodAutoscalerCheckpointStatus(fluent.buildCpuHistogram(), fluent.getFirstSampleStart(), fluent.getLastSampleStart(), fluent.getLastUpdateTime(), fluent.buildMemoryHistogram(), fluent.getTotalSamplesCount(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}