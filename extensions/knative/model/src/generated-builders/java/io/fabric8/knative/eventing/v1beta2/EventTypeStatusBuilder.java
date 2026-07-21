package io.fabric8.knative.eventing.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventTypeStatusBuilder extends EventTypeStatusFluent<EventTypeStatusBuilder> implements VisitableBuilder<EventTypeStatus,EventTypeStatusBuilder>{

  EventTypeStatusFluent<?> fluent;

  public EventTypeStatusBuilder() {
    this(new EventTypeStatus());
  }
  
  public EventTypeStatusBuilder(EventTypeStatusFluent<?> fluent) {
    this(fluent, new EventTypeStatus());
  }
  
  public EventTypeStatusBuilder(EventTypeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventTypeStatusBuilder(EventTypeStatusFluent<?> fluent,EventTypeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventTypeStatus build() {
    EventTypeStatus buildable = new EventTypeStatus(fluent.getAnnotations(), fluent.buildConditions(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}