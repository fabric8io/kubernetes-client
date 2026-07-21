package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventPolicyFromReferenceBuilder extends EventPolicyFromReferenceFluent<EventPolicyFromReferenceBuilder> implements VisitableBuilder<EventPolicyFromReference,EventPolicyFromReferenceBuilder>{

  EventPolicyFromReferenceFluent<?> fluent;

  public EventPolicyFromReferenceBuilder() {
    this(new EventPolicyFromReference());
  }
  
  public EventPolicyFromReferenceBuilder(EventPolicyFromReferenceFluent<?> fluent) {
    this(fluent, new EventPolicyFromReference());
  }
  
  public EventPolicyFromReferenceBuilder(EventPolicyFromReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventPolicyFromReferenceBuilder(EventPolicyFromReferenceFluent<?> fluent,EventPolicyFromReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventPolicyFromReference build() {
    EventPolicyFromReference buildable = new EventPolicyFromReference(fluent.getApiVersion(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}