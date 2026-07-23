package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventPolicyToReferenceBuilder extends EventPolicyToReferenceFluent<EventPolicyToReferenceBuilder> implements VisitableBuilder<EventPolicyToReference,EventPolicyToReferenceBuilder>{

  EventPolicyToReferenceFluent<?> fluent;

  public EventPolicyToReferenceBuilder() {
    this(new EventPolicyToReference());
  }
  
  public EventPolicyToReferenceBuilder(EventPolicyToReferenceFluent<?> fluent) {
    this(fluent, new EventPolicyToReference());
  }
  
  public EventPolicyToReferenceBuilder(EventPolicyToReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventPolicyToReferenceBuilder(EventPolicyToReferenceFluent<?> fluent,EventPolicyToReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventPolicyToReference build() {
    EventPolicyToReference buildable = new EventPolicyToReference(fluent.getApiVersion(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}