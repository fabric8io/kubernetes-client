package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionUnitStatusBuilder extends SubscriptionUnitStatusFluent<SubscriptionUnitStatusBuilder> implements VisitableBuilder<SubscriptionUnitStatus,SubscriptionUnitStatusBuilder>{

  SubscriptionUnitStatusFluent<?> fluent;

  public SubscriptionUnitStatusBuilder() {
    this(new SubscriptionUnitStatus());
  }
  
  public SubscriptionUnitStatusBuilder(SubscriptionUnitStatusFluent<?> fluent) {
    this(fluent, new SubscriptionUnitStatus());
  }
  
  public SubscriptionUnitStatusBuilder(SubscriptionUnitStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionUnitStatusBuilder(SubscriptionUnitStatusFluent<?> fluent,SubscriptionUnitStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionUnitStatus build() {
    SubscriptionUnitStatus buildable = new SubscriptionUnitStatus(fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getPhase(), fluent.getReason(), fluent.getResourceStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}