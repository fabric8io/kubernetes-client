package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SequenceChannelStatusBuilder extends SequenceChannelStatusFluent<SequenceChannelStatusBuilder> implements VisitableBuilder<SequenceChannelStatus,SequenceChannelStatusBuilder>{

  SequenceChannelStatusFluent<?> fluent;

  public SequenceChannelStatusBuilder() {
    this(new SequenceChannelStatus());
  }
  
  public SequenceChannelStatusBuilder(SequenceChannelStatusFluent<?> fluent) {
    this(fluent, new SequenceChannelStatus());
  }
  
  public SequenceChannelStatusBuilder(SequenceChannelStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SequenceChannelStatusBuilder(SequenceChannelStatusFluent<?> fluent,SequenceChannelStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SequenceChannelStatus build() {
    SequenceChannelStatus buildable = new SequenceChannelStatus(fluent.buildChannel(), fluent.buildReady());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}