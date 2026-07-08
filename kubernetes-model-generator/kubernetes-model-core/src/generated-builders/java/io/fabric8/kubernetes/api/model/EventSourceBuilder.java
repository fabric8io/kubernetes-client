package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventSourceBuilder extends EventSourceFluent<EventSourceBuilder> implements VisitableBuilder<EventSource,EventSourceBuilder>{

  EventSourceFluent<?> fluent;

  public EventSourceBuilder() {
    this(new EventSource());
  }
  
  public EventSourceBuilder(EventSourceFluent<?> fluent) {
    this(fluent, new EventSource());
  }
  
  public EventSourceBuilder(EventSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventSourceBuilder(EventSourceFluent<?> fluent,EventSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventSource build() {
    EventSource buildable = new EventSource(fluent.getComponent(), fluent.getHost());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}