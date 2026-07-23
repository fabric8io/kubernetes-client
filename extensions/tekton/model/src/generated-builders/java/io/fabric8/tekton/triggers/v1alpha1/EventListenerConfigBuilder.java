package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventListenerConfigBuilder extends EventListenerConfigFluent<EventListenerConfigBuilder> implements VisitableBuilder<EventListenerConfig,EventListenerConfigBuilder>{

  EventListenerConfigFluent<?> fluent;

  public EventListenerConfigBuilder() {
    this(new EventListenerConfig());
  }
  
  public EventListenerConfigBuilder(EventListenerConfigFluent<?> fluent) {
    this(fluent, new EventListenerConfig());
  }
  
  public EventListenerConfigBuilder(EventListenerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventListenerConfigBuilder(EventListenerConfigFluent<?> fluent,EventListenerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventListenerConfig build() {
    EventListenerConfig buildable = new EventListenerConfig(fluent.getGeneratedName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}