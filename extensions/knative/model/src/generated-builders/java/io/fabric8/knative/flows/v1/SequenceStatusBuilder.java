package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SequenceStatusBuilder extends SequenceStatusFluent<SequenceStatusBuilder> implements VisitableBuilder<SequenceStatus,SequenceStatusBuilder>{

  SequenceStatusFluent<?> fluent;

  public SequenceStatusBuilder() {
    this(new SequenceStatus());
  }
  
  public SequenceStatusBuilder(SequenceStatusFluent<?> fluent) {
    this(fluent, new SequenceStatus());
  }
  
  public SequenceStatusBuilder(SequenceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SequenceStatusBuilder(SequenceStatusFluent<?> fluent,SequenceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SequenceStatus build() {
    SequenceStatus buildable = new SequenceStatus(fluent.buildAddress(), fluent.getAnnotations(), fluent.buildAuth(), fluent.buildChannelStatuses(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.buildPolicies(), fluent.buildSubscriptionStatuses());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}