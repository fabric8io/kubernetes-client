package io.fabric8.knative.eventing.v1beta3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventTypeListBuilder extends EventTypeListFluent<EventTypeListBuilder> implements VisitableBuilder<EventTypeList,EventTypeListBuilder>{

  EventTypeListFluent<?> fluent;

  public EventTypeListBuilder() {
    this(new EventTypeList());
  }
  
  public EventTypeListBuilder(EventTypeListFluent<?> fluent) {
    this(fluent, new EventTypeList());
  }
  
  public EventTypeListBuilder(EventTypeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventTypeListBuilder(EventTypeListFluent<?> fluent,EventTypeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventTypeList build() {
    EventTypeList buildable = new EventTypeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}