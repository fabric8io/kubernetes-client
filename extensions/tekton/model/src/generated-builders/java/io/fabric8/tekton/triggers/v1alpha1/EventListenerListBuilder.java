package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventListenerListBuilder extends EventListenerListFluent<EventListenerListBuilder> implements VisitableBuilder<EventListenerList,EventListenerListBuilder>{

  EventListenerListFluent<?> fluent;

  public EventListenerListBuilder() {
    this(new EventListenerList());
  }
  
  public EventListenerListBuilder(EventListenerListFluent<?> fluent) {
    this(fluent, new EventListenerList());
  }
  
  public EventListenerListBuilder(EventListenerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventListenerListBuilder(EventListenerListFluent<?> fluent,EventListenerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventListenerList build() {
    EventListenerList buildable = new EventListenerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}