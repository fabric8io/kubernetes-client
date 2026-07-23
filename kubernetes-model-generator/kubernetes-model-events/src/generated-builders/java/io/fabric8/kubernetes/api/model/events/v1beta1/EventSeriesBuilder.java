package io.fabric8.kubernetes.api.model.events.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventSeriesBuilder extends EventSeriesFluent<EventSeriesBuilder> implements VisitableBuilder<EventSeries,EventSeriesBuilder>{

  EventSeriesFluent<?> fluent;

  public EventSeriesBuilder() {
    this(new EventSeries());
  }
  
  public EventSeriesBuilder(EventSeriesFluent<?> fluent) {
    this(fluent, new EventSeries());
  }
  
  public EventSeriesBuilder(EventSeries instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventSeriesBuilder(EventSeriesFluent<?> fluent,EventSeries instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventSeries build() {
    EventSeries buildable = new EventSeries(fluent.getCount(), fluent.getLastObservedTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}