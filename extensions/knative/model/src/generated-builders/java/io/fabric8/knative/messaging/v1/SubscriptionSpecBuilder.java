package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionSpecBuilder extends SubscriptionSpecFluent<SubscriptionSpecBuilder> implements VisitableBuilder<SubscriptionSpec,SubscriptionSpecBuilder>{

  SubscriptionSpecFluent<?> fluent;

  public SubscriptionSpecBuilder() {
    this(new SubscriptionSpec());
  }
  
  public SubscriptionSpecBuilder(SubscriptionSpecFluent<?> fluent) {
    this(fluent, new SubscriptionSpec());
  }
  
  public SubscriptionSpecBuilder(SubscriptionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionSpecBuilder(SubscriptionSpecFluent<?> fluent,SubscriptionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionSpec build() {
    SubscriptionSpec buildable = new SubscriptionSpec(fluent.buildChannel(), fluent.buildDelivery(), fluent.buildReply(), fluent.buildSubscriber());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}