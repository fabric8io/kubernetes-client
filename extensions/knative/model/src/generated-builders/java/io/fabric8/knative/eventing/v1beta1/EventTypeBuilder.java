package io.fabric8.knative.eventing.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventTypeBuilder extends EventTypeFluent<EventTypeBuilder> implements VisitableBuilder<EventType,EventTypeBuilder>{

  EventTypeFluent<?> fluent;

  public EventTypeBuilder() {
    this(new EventType());
  }
  
  public EventTypeBuilder(EventTypeFluent<?> fluent) {
    this(fluent, new EventType());
  }
  
  public EventTypeBuilder(EventType instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventTypeBuilder(EventTypeFluent<?> fluent,EventType instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventType build() {
    EventType buildable = new EventType(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}