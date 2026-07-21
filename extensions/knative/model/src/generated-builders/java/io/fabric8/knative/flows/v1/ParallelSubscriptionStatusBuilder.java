package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParallelSubscriptionStatusBuilder extends ParallelSubscriptionStatusFluent<ParallelSubscriptionStatusBuilder> implements VisitableBuilder<ParallelSubscriptionStatus,ParallelSubscriptionStatusBuilder>{

  ParallelSubscriptionStatusFluent<?> fluent;

  public ParallelSubscriptionStatusBuilder() {
    this(new ParallelSubscriptionStatus());
  }
  
  public ParallelSubscriptionStatusBuilder(ParallelSubscriptionStatusFluent<?> fluent) {
    this(fluent, new ParallelSubscriptionStatus());
  }
  
  public ParallelSubscriptionStatusBuilder(ParallelSubscriptionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParallelSubscriptionStatusBuilder(ParallelSubscriptionStatusFluent<?> fluent,ParallelSubscriptionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParallelSubscriptionStatus build() {
    ParallelSubscriptionStatus buildable = new ParallelSubscriptionStatus(fluent.buildReady(), fluent.buildSubscription());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}