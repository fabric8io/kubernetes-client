package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventPolicySpecBuilder extends EventPolicySpecFluent<EventPolicySpecBuilder> implements VisitableBuilder<EventPolicySpec,EventPolicySpecBuilder>{

  EventPolicySpecFluent<?> fluent;

  public EventPolicySpecBuilder() {
    this(new EventPolicySpec());
  }
  
  public EventPolicySpecBuilder(EventPolicySpecFluent<?> fluent) {
    this(fluent, new EventPolicySpec());
  }
  
  public EventPolicySpecBuilder(EventPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventPolicySpecBuilder(EventPolicySpecFluent<?> fluent,EventPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventPolicySpec build() {
    EventPolicySpec buildable = new EventPolicySpec(fluent.buildFilters(), fluent.buildFrom(), fluent.buildTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}