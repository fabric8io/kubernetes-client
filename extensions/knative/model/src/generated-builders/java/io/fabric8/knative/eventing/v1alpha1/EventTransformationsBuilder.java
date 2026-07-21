package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventTransformationsBuilder extends EventTransformationsFluent<EventTransformationsBuilder> implements VisitableBuilder<EventTransformations,EventTransformationsBuilder>{

  EventTransformationsFluent<?> fluent;

  public EventTransformationsBuilder() {
    this(new EventTransformations());
  }
  
  public EventTransformationsBuilder(EventTransformationsFluent<?> fluent) {
    this(fluent, new EventTransformations());
  }
  
  public EventTransformationsBuilder(EventTransformations instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventTransformationsBuilder(EventTransformationsFluent<?> fluent,EventTransformations instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventTransformations build() {
    EventTransformations buildable = new EventTransformations(fluent.buildJsonata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}