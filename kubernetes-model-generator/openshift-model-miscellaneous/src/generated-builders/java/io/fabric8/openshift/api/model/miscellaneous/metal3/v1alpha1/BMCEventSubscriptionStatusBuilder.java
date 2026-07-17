package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BMCEventSubscriptionStatusBuilder extends BMCEventSubscriptionStatusFluent<BMCEventSubscriptionStatusBuilder> implements VisitableBuilder<BMCEventSubscriptionStatus,BMCEventSubscriptionStatusBuilder>{

  BMCEventSubscriptionStatusFluent<?> fluent;

  public BMCEventSubscriptionStatusBuilder() {
    this(new BMCEventSubscriptionStatus());
  }
  
  public BMCEventSubscriptionStatusBuilder(BMCEventSubscriptionStatusFluent<?> fluent) {
    this(fluent, new BMCEventSubscriptionStatus());
  }
  
  public BMCEventSubscriptionStatusBuilder(BMCEventSubscriptionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BMCEventSubscriptionStatusBuilder(BMCEventSubscriptionStatusFluent<?> fluent,BMCEventSubscriptionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BMCEventSubscriptionStatus build() {
    BMCEventSubscriptionStatus buildable = new BMCEventSubscriptionStatus(fluent.getError(), fluent.getSubscriptionID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}