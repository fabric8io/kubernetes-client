package io.fabric8.kubernetes.api.model.events.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventBuilder extends EventFluent<EventBuilder> implements VisitableBuilder<Event,EventBuilder>{

  EventFluent<?> fluent;

  public EventBuilder() {
    this(new Event());
  }
  
  public EventBuilder(EventFluent<?> fluent) {
    this(fluent, new Event());
  }
  
  public EventBuilder(Event instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventBuilder(EventFluent<?> fluent,Event instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Event build() {
    Event buildable = new Event(fluent.getAction(), fluent.getApiVersion(), fluent.getDeprecatedCount(), fluent.getDeprecatedFirstTimestamp(), fluent.getDeprecatedLastTimestamp(), fluent.getDeprecatedSource(), fluent.getEventTime(), fluent.getKind(), fluent.buildMetadata(), fluent.getNote(), fluent.getReason(), fluent.buildRegarding(), fluent.buildRelated(), fluent.getReportingController(), fluent.getReportingInstance(), fluent.buildSeries(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}