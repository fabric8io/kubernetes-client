package io.fabric8.autoscaling.api.model.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HistogramCheckpointBuilder extends HistogramCheckpointFluent<HistogramCheckpointBuilder> implements VisitableBuilder<HistogramCheckpoint,HistogramCheckpointBuilder>{

  HistogramCheckpointFluent<?> fluent;

  public HistogramCheckpointBuilder() {
    this(new HistogramCheckpoint());
  }
  
  public HistogramCheckpointBuilder(HistogramCheckpointFluent<?> fluent) {
    this(fluent, new HistogramCheckpoint());
  }
  
  public HistogramCheckpointBuilder(HistogramCheckpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HistogramCheckpointBuilder(HistogramCheckpointFluent<?> fluent,HistogramCheckpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HistogramCheckpoint build() {
    HistogramCheckpoint buildable = new HistogramCheckpoint(fluent.getBucketWeights(), fluent.getReferenceTimestamp(), fluent.getTotalWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}