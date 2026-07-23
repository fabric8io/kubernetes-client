package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventTransformBuilder extends EventTransformFluent<EventTransformBuilder> implements VisitableBuilder<EventTransform,EventTransformBuilder>{

  EventTransformFluent<?> fluent;

  public EventTransformBuilder() {
    this(new EventTransform());
  }
  
  public EventTransformBuilder(EventTransformFluent<?> fluent) {
    this(fluent, new EventTransform());
  }
  
  public EventTransformBuilder(EventTransform instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventTransformBuilder(EventTransformFluent<?> fluent,EventTransform instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventTransform build() {
    EventTransform buildable = new EventTransform(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}