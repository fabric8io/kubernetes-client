package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionBuilder extends SubscriptionFluent<SubscriptionBuilder> implements VisitableBuilder<Subscription,SubscriptionBuilder>{

  SubscriptionFluent<?> fluent;

  public SubscriptionBuilder() {
    this(new Subscription());
  }
  
  public SubscriptionBuilder(SubscriptionFluent<?> fluent) {
    this(fluent, new Subscription());
  }
  
  public SubscriptionBuilder(Subscription instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionBuilder(SubscriptionFluent<?> fluent,Subscription instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Subscription build() {
    Subscription buildable = new Subscription(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}