package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventPolicySpecToBuilder extends EventPolicySpecToFluent<EventPolicySpecToBuilder> implements VisitableBuilder<EventPolicySpecTo,EventPolicySpecToBuilder>{

  EventPolicySpecToFluent<?> fluent;

  public EventPolicySpecToBuilder() {
    this(new EventPolicySpecTo());
  }
  
  public EventPolicySpecToBuilder(EventPolicySpecToFluent<?> fluent) {
    this(fluent, new EventPolicySpecTo());
  }
  
  public EventPolicySpecToBuilder(EventPolicySpecTo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventPolicySpecToBuilder(EventPolicySpecToFluent<?> fluent,EventPolicySpecTo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventPolicySpecTo build() {
    EventPolicySpecTo buildable = new EventPolicySpecTo(fluent.buildRef(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}