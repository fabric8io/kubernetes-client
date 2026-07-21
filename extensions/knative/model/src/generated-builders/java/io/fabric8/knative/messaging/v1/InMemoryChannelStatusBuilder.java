package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InMemoryChannelStatusBuilder extends InMemoryChannelStatusFluent<InMemoryChannelStatusBuilder> implements VisitableBuilder<InMemoryChannelStatus,InMemoryChannelStatusBuilder>{

  InMemoryChannelStatusFluent<?> fluent;

  public InMemoryChannelStatusBuilder() {
    this(new InMemoryChannelStatus());
  }
  
  public InMemoryChannelStatusBuilder(InMemoryChannelStatusFluent<?> fluent) {
    this(fluent, new InMemoryChannelStatus());
  }
  
  public InMemoryChannelStatusBuilder(InMemoryChannelStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InMemoryChannelStatusBuilder(InMemoryChannelStatusFluent<?> fluent,InMemoryChannelStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InMemoryChannelStatus build() {
    InMemoryChannelStatus buildable = new InMemoryChannelStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getDeadLetterSinkAudience(), fluent.getDeadLetterSinkCACerts(), fluent.getDeadLetterSinkUri(), fluent.getObservedGeneration(), fluent.buildPolicies(), fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}