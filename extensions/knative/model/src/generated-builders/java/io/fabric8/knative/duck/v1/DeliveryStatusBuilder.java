package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeliveryStatusBuilder extends DeliveryStatusFluent<DeliveryStatusBuilder> implements VisitableBuilder<DeliveryStatus,DeliveryStatusBuilder>{

  DeliveryStatusFluent<?> fluent;

  public DeliveryStatusBuilder() {
    this(new DeliveryStatus());
  }
  
  public DeliveryStatusBuilder(DeliveryStatusFluent<?> fluent) {
    this(fluent, new DeliveryStatus());
  }
  
  public DeliveryStatusBuilder(DeliveryStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeliveryStatusBuilder(DeliveryStatusFluent<?> fluent,DeliveryStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeliveryStatus build() {
    DeliveryStatus buildable = new DeliveryStatus(fluent.getDeadLetterSinkAudience(), fluent.getDeadLetterSinkCACerts(), fluent.getDeadLetterSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}