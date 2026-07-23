package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventTransformSpecBuilder extends EventTransformSpecFluent<EventTransformSpecBuilder> implements VisitableBuilder<EventTransformSpec,EventTransformSpecBuilder>{

  EventTransformSpecFluent<?> fluent;

  public EventTransformSpecBuilder() {
    this(new EventTransformSpec());
  }
  
  public EventTransformSpecBuilder(EventTransformSpecFluent<?> fluent) {
    this(fluent, new EventTransformSpec());
  }
  
  public EventTransformSpecBuilder(EventTransformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventTransformSpecBuilder(EventTransformSpecFluent<?> fluent,EventTransformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventTransformSpec build() {
    EventTransformSpec buildable = new EventTransformSpec(fluent.buildJsonata(), fluent.buildReply(), fluent.buildSink());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}