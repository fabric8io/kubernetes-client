package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventListenerSpecBuilder extends EventListenerSpecFluent<EventListenerSpecBuilder> implements VisitableBuilder<EventListenerSpec,EventListenerSpecBuilder>{

  EventListenerSpecFluent<?> fluent;

  public EventListenerSpecBuilder() {
    this(new EventListenerSpec());
  }
  
  public EventListenerSpecBuilder(EventListenerSpecFluent<?> fluent) {
    this(fluent, new EventListenerSpec());
  }
  
  public EventListenerSpecBuilder(EventListenerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventListenerSpecBuilder(EventListenerSpecFluent<?> fluent,EventListenerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventListenerSpec build() {
    EventListenerSpec buildable = new EventListenerSpec(fluent.buildLabelSelector(), fluent.buildNamespaceSelector(), fluent.buildResources(), fluent.getServiceAccountName(), fluent.buildTriggers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}