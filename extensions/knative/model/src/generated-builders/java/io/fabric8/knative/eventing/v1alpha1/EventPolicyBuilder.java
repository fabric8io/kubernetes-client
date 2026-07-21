package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventPolicyBuilder extends EventPolicyFluent<EventPolicyBuilder> implements VisitableBuilder<EventPolicy,EventPolicyBuilder>{

  EventPolicyFluent<?> fluent;

  public EventPolicyBuilder() {
    this(new EventPolicy());
  }
  
  public EventPolicyBuilder(EventPolicyFluent<?> fluent) {
    this(fluent, new EventPolicy());
  }
  
  public EventPolicyBuilder(EventPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventPolicyBuilder(EventPolicyFluent<?> fluent,EventPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventPolicy build() {
    EventPolicy buildable = new EventPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}