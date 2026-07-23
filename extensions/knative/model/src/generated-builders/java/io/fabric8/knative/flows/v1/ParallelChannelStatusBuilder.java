package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParallelChannelStatusBuilder extends ParallelChannelStatusFluent<ParallelChannelStatusBuilder> implements VisitableBuilder<ParallelChannelStatus,ParallelChannelStatusBuilder>{

  ParallelChannelStatusFluent<?> fluent;

  public ParallelChannelStatusBuilder() {
    this(new ParallelChannelStatus());
  }
  
  public ParallelChannelStatusBuilder(ParallelChannelStatusFluent<?> fluent) {
    this(fluent, new ParallelChannelStatus());
  }
  
  public ParallelChannelStatusBuilder(ParallelChannelStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParallelChannelStatusBuilder(ParallelChannelStatusFluent<?> fluent,ParallelChannelStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParallelChannelStatus build() {
    ParallelChannelStatus buildable = new ParallelChannelStatus(fluent.buildChannel(), fluent.buildReady());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}