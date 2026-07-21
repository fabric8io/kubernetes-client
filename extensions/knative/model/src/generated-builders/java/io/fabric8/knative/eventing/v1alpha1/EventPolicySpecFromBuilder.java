package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventPolicySpecFromBuilder extends EventPolicySpecFromFluent<EventPolicySpecFromBuilder> implements VisitableBuilder<EventPolicySpecFrom,EventPolicySpecFromBuilder>{

  EventPolicySpecFromFluent<?> fluent;

  public EventPolicySpecFromBuilder() {
    this(new EventPolicySpecFrom());
  }
  
  public EventPolicySpecFromBuilder(EventPolicySpecFromFluent<?> fluent) {
    this(fluent, new EventPolicySpecFrom());
  }
  
  public EventPolicySpecFromBuilder(EventPolicySpecFrom instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventPolicySpecFromBuilder(EventPolicySpecFromFluent<?> fluent,EventPolicySpecFrom instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventPolicySpecFrom build() {
    EventPolicySpecFrom buildable = new EventPolicySpecFrom(fluent.buildRef(), fluent.getSub());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}