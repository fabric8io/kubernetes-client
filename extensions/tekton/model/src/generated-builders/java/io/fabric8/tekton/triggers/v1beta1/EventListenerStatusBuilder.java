package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventListenerStatusBuilder extends EventListenerStatusFluent<EventListenerStatusBuilder> implements VisitableBuilder<EventListenerStatus,EventListenerStatusBuilder>{

  EventListenerStatusFluent<?> fluent;

  public EventListenerStatusBuilder() {
    this(new EventListenerStatus());
  }
  
  public EventListenerStatusBuilder(EventListenerStatusFluent<?> fluent) {
    this(fluent, new EventListenerStatus());
  }
  
  public EventListenerStatusBuilder(EventListenerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventListenerStatusBuilder(EventListenerStatusFluent<?> fluent,EventListenerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventListenerStatus build() {
    EventListenerStatus buildable = new EventListenerStatus(fluent.getAddress(), fluent.getAddresses(), fluent.getAnnotations(), fluent.getConditions(), fluent.buildConfiguration(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}