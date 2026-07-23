package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventListenerTriggerBuilder extends EventListenerTriggerFluent<EventListenerTriggerBuilder> implements VisitableBuilder<EventListenerTrigger,EventListenerTriggerBuilder>{

  EventListenerTriggerFluent<?> fluent;

  public EventListenerTriggerBuilder() {
    this(new EventListenerTrigger());
  }
  
  public EventListenerTriggerBuilder(EventListenerTriggerFluent<?> fluent) {
    this(fluent, new EventListenerTrigger());
  }
  
  public EventListenerTriggerBuilder(EventListenerTrigger instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventListenerTriggerBuilder(EventListenerTriggerFluent<?> fluent,EventListenerTrigger instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventListenerTrigger build() {
    EventListenerTrigger buildable = new EventListenerTrigger(fluent.buildBindings(), fluent.buildInterceptors(), fluent.getName(), fluent.getServiceAccountName(), fluent.buildTemplate(), fluent.getTriggerRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}