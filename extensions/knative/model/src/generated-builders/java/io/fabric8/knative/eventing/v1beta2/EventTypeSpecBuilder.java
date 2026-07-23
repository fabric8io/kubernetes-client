package io.fabric8.knative.eventing.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventTypeSpecBuilder extends EventTypeSpecFluent<EventTypeSpecBuilder> implements VisitableBuilder<EventTypeSpec,EventTypeSpecBuilder>{

  EventTypeSpecFluent<?> fluent;

  public EventTypeSpecBuilder() {
    this(new EventTypeSpec());
  }
  
  public EventTypeSpecBuilder(EventTypeSpecFluent<?> fluent) {
    this(fluent, new EventTypeSpec());
  }
  
  public EventTypeSpecBuilder(EventTypeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventTypeSpecBuilder(EventTypeSpecFluent<?> fluent,EventTypeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventTypeSpec build() {
    EventTypeSpec buildable = new EventTypeSpec(fluent.getBroker(), fluent.getDescription(), fluent.buildReference(), fluent.getSchema(), fluent.getSchemaData(), fluent.getSource(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}