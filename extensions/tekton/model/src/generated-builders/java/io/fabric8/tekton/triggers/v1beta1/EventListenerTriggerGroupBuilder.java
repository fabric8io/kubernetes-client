package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventListenerTriggerGroupBuilder extends EventListenerTriggerGroupFluent<EventListenerTriggerGroupBuilder> implements VisitableBuilder<EventListenerTriggerGroup,EventListenerTriggerGroupBuilder>{

  EventListenerTriggerGroupFluent<?> fluent;

  public EventListenerTriggerGroupBuilder() {
    this(new EventListenerTriggerGroup());
  }
  
  public EventListenerTriggerGroupBuilder(EventListenerTriggerGroupFluent<?> fluent) {
    this(fluent, new EventListenerTriggerGroup());
  }
  
  public EventListenerTriggerGroupBuilder(EventListenerTriggerGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventListenerTriggerGroupBuilder(EventListenerTriggerGroupFluent<?> fluent,EventListenerTriggerGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventListenerTriggerGroup build() {
    EventListenerTriggerGroup buildable = new EventListenerTriggerGroup(fluent.buildInterceptors(), fluent.getName(), fluent.buildTriggerSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}