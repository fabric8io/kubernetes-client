package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventListenerTriggerSelectorBuilder extends EventListenerTriggerSelectorFluent<EventListenerTriggerSelectorBuilder> implements VisitableBuilder<EventListenerTriggerSelector,EventListenerTriggerSelectorBuilder>{

  EventListenerTriggerSelectorFluent<?> fluent;

  public EventListenerTriggerSelectorBuilder() {
    this(new EventListenerTriggerSelector());
  }
  
  public EventListenerTriggerSelectorBuilder(EventListenerTriggerSelectorFluent<?> fluent) {
    this(fluent, new EventListenerTriggerSelector());
  }
  
  public EventListenerTriggerSelectorBuilder(EventListenerTriggerSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventListenerTriggerSelectorBuilder(EventListenerTriggerSelectorFluent<?> fluent,EventListenerTriggerSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventListenerTriggerSelector build() {
    EventListenerTriggerSelector buildable = new EventListenerTriggerSelector(fluent.buildLabelSelector(), fluent.buildNamespaceSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}