package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SequenceSubscriptionStatusBuilder extends SequenceSubscriptionStatusFluent<SequenceSubscriptionStatusBuilder> implements VisitableBuilder<SequenceSubscriptionStatus,SequenceSubscriptionStatusBuilder>{

  SequenceSubscriptionStatusFluent<?> fluent;

  public SequenceSubscriptionStatusBuilder() {
    this(new SequenceSubscriptionStatus());
  }
  
  public SequenceSubscriptionStatusBuilder(SequenceSubscriptionStatusFluent<?> fluent) {
    this(fluent, new SequenceSubscriptionStatus());
  }
  
  public SequenceSubscriptionStatusBuilder(SequenceSubscriptionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SequenceSubscriptionStatusBuilder(SequenceSubscriptionStatusFluent<?> fluent,SequenceSubscriptionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SequenceSubscriptionStatus build() {
    SequenceSubscriptionStatus buildable = new SequenceSubscriptionStatus(fluent.buildReady(), fluent.buildSubscription());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}