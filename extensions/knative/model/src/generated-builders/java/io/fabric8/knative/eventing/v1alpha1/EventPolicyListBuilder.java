package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventPolicyListBuilder extends EventPolicyListFluent<EventPolicyListBuilder> implements VisitableBuilder<EventPolicyList,EventPolicyListBuilder>{

  EventPolicyListFluent<?> fluent;

  public EventPolicyListBuilder() {
    this(new EventPolicyList());
  }
  
  public EventPolicyListBuilder(EventPolicyListFluent<?> fluent) {
    this(fluent, new EventPolicyList());
  }
  
  public EventPolicyListBuilder(EventPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventPolicyListBuilder(EventPolicyListFluent<?> fluent,EventPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventPolicyList build() {
    EventPolicyList buildable = new EventPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}