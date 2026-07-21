package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionStatusPhysicalSubscriptionBuilder extends SubscriptionStatusPhysicalSubscriptionFluent<SubscriptionStatusPhysicalSubscriptionBuilder> implements VisitableBuilder<SubscriptionStatusPhysicalSubscription,SubscriptionStatusPhysicalSubscriptionBuilder>{

  SubscriptionStatusPhysicalSubscriptionFluent<?> fluent;

  public SubscriptionStatusPhysicalSubscriptionBuilder() {
    this(new SubscriptionStatusPhysicalSubscription());
  }
  
  public SubscriptionStatusPhysicalSubscriptionBuilder(SubscriptionStatusPhysicalSubscriptionFluent<?> fluent) {
    this(fluent, new SubscriptionStatusPhysicalSubscription());
  }
  
  public SubscriptionStatusPhysicalSubscriptionBuilder(SubscriptionStatusPhysicalSubscription instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionStatusPhysicalSubscriptionBuilder(SubscriptionStatusPhysicalSubscriptionFluent<?> fluent,SubscriptionStatusPhysicalSubscription instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionStatusPhysicalSubscription build() {
    SubscriptionStatusPhysicalSubscription buildable = new SubscriptionStatusPhysicalSubscription(fluent.getDeadLetterSinkAudience(), fluent.getDeadLetterSinkCACerts(), fluent.getDeadLetterSinkUri(), fluent.getReplyAudience(), fluent.getReplyCACerts(), fluent.getReplyUri(), fluent.getSubscriberAudience(), fluent.getSubscriberCACerts(), fluent.getSubscriberUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}