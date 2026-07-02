package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventListBuilder extends EventListFluent<EventListBuilder> implements VisitableBuilder<EventList,EventListBuilder>{

  EventListFluent<?> fluent;

  public EventListBuilder() {
    this(new EventList());
  }
  
  public EventListBuilder(EventListFluent<?> fluent) {
    this(fluent, new EventList());
  }
  
  public EventListBuilder(EventList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventListBuilder(EventListFluent<?> fluent,EventList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventList build() {
    EventList buildable = new EventList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}