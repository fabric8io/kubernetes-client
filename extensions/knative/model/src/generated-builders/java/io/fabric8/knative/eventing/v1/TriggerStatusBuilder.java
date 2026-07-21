package io.fabric8.knative.eventing.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerStatusBuilder extends TriggerStatusFluent<TriggerStatusBuilder> implements VisitableBuilder<TriggerStatus,TriggerStatusBuilder>{

  TriggerStatusFluent<?> fluent;

  public TriggerStatusBuilder() {
    this(new TriggerStatus());
  }
  
  public TriggerStatusBuilder(TriggerStatusFluent<?> fluent) {
    this(fluent, new TriggerStatus());
  }
  
  public TriggerStatusBuilder(TriggerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerStatusBuilder(TriggerStatusFluent<?> fluent,TriggerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerStatus build() {
    TriggerStatus buildable = new TriggerStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildConditions(), fluent.getDeadLetterSinkAudience(), fluent.getDeadLetterSinkCACerts(), fluent.getDeadLetterSinkUri(), fluent.getObservedGeneration(), fluent.getSubscriberAudience(), fluent.getSubscriberCACerts(), fluent.getSubscriberUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}