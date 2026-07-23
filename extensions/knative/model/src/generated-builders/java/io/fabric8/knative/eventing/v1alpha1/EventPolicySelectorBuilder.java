package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventPolicySelectorBuilder extends EventPolicySelectorFluent<EventPolicySelectorBuilder> implements VisitableBuilder<EventPolicySelector,EventPolicySelectorBuilder>{

  EventPolicySelectorFluent<?> fluent;

  public EventPolicySelectorBuilder() {
    this(new EventPolicySelector());
  }
  
  public EventPolicySelectorBuilder(EventPolicySelectorFluent<?> fluent) {
    this(fluent, new EventPolicySelector());
  }
  
  public EventPolicySelectorBuilder(EventPolicySelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventPolicySelectorBuilder(EventPolicySelectorFluent<?> fluent,EventPolicySelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventPolicySelector build() {
    EventPolicySelector buildable = new EventPolicySelector(fluent.getApiVersion(), fluent.getKind(), fluent.getMatchExpressions(), fluent.getMatchLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}