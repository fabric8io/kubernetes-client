package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventTransformListBuilder extends EventTransformListFluent<EventTransformListBuilder> implements VisitableBuilder<EventTransformList,EventTransformListBuilder>{

  EventTransformListFluent<?> fluent;

  public EventTransformListBuilder() {
    this(new EventTransformList());
  }
  
  public EventTransformListBuilder(EventTransformListFluent<?> fluent) {
    this(fluent, new EventTransformList());
  }
  
  public EventTransformListBuilder(EventTransformList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventTransformListBuilder(EventTransformListFluent<?> fluent,EventTransformList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventTransformList build() {
    EventTransformList buildable = new EventTransformList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}