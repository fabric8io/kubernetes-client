package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventTransformStatusBuilder extends EventTransformStatusFluent<EventTransformStatusBuilder> implements VisitableBuilder<EventTransformStatus,EventTransformStatusBuilder>{

  EventTransformStatusFluent<?> fluent;

  public EventTransformStatusBuilder() {
    this(new EventTransformStatus());
  }
  
  public EventTransformStatusBuilder(EventTransformStatusFluent<?> fluent) {
    this(fluent, new EventTransformStatus());
  }
  
  public EventTransformStatusBuilder(EventTransformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventTransformStatusBuilder(EventTransformStatusFluent<?> fluent,EventTransformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventTransformStatus build() {
    EventTransformStatus buildable = new EventTransformStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.buildJsonata(), fluent.getObservedGeneration(), fluent.buildPolicies(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}