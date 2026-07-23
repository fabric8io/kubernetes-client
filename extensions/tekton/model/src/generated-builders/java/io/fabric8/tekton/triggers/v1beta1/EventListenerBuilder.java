package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventListenerBuilder extends EventListenerFluent<EventListenerBuilder> implements VisitableBuilder<EventListener,EventListenerBuilder>{

  EventListenerFluent<?> fluent;

  public EventListenerBuilder() {
    this(new EventListener());
  }
  
  public EventListenerBuilder(EventListenerFluent<?> fluent) {
    this(fluent, new EventListener());
  }
  
  public EventListenerBuilder(EventListener instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventListenerBuilder(EventListenerFluent<?> fluent,EventListener instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventListener build() {
    EventListener buildable = new EventListener(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}