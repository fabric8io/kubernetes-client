package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionConditionBuilder extends SubscriptionConditionFluent<SubscriptionConditionBuilder> implements VisitableBuilder<SubscriptionCondition,SubscriptionConditionBuilder>{

  SubscriptionConditionFluent<?> fluent;

  public SubscriptionConditionBuilder() {
    this(new SubscriptionCondition());
  }
  
  public SubscriptionConditionBuilder(SubscriptionConditionFluent<?> fluent) {
    this(fluent, new SubscriptionCondition());
  }
  
  public SubscriptionConditionBuilder(SubscriptionCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionConditionBuilder(SubscriptionConditionFluent<?> fluent,SubscriptionCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionCondition build() {
    SubscriptionCondition buildable = new SubscriptionCondition(fluent.getLastHeartbeatTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}