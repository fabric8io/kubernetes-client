package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventPolicyStatusBuilder extends EventPolicyStatusFluent<EventPolicyStatusBuilder> implements VisitableBuilder<EventPolicyStatus,EventPolicyStatusBuilder>{

  EventPolicyStatusFluent<?> fluent;

  public EventPolicyStatusBuilder() {
    this(new EventPolicyStatus());
  }
  
  public EventPolicyStatusBuilder(EventPolicyStatusFluent<?> fluent) {
    this(fluent, new EventPolicyStatus());
  }
  
  public EventPolicyStatusBuilder(EventPolicyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventPolicyStatusBuilder(EventPolicyStatusFluent<?> fluent,EventPolicyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventPolicyStatus build() {
    EventPolicyStatus buildable = new EventPolicyStatus(fluent.getAnnotations(), fluent.buildConditions(), fluent.getFrom(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}