package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeliverySpecBuilder extends DeliverySpecFluent<DeliverySpecBuilder> implements VisitableBuilder<DeliverySpec,DeliverySpecBuilder>{

  DeliverySpecFluent<?> fluent;

  public DeliverySpecBuilder() {
    this(new DeliverySpec());
  }
  
  public DeliverySpecBuilder(DeliverySpecFluent<?> fluent) {
    this(fluent, new DeliverySpec());
  }
  
  public DeliverySpecBuilder(DeliverySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeliverySpecBuilder(DeliverySpecFluent<?> fluent,DeliverySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeliverySpec build() {
    DeliverySpec buildable = new DeliverySpec(fluent.getBackoffDelay(), fluent.getBackoffPolicy(), fluent.buildDeadLetterSink(), fluent.getRetry(), fluent.getTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}