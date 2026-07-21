package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriberItemBuilder extends SubscriberItemFluent<SubscriberItemBuilder> implements VisitableBuilder<SubscriberItem,SubscriberItemBuilder>{

  SubscriberItemFluent<?> fluent;

  public SubscriberItemBuilder() {
    this(new SubscriberItem());
  }
  
  public SubscriberItemBuilder(SubscriberItemFluent<?> fluent) {
    this(fluent, new SubscriberItem());
  }
  
  public SubscriberItemBuilder(SubscriberItem instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriberItemBuilder(SubscriberItemFluent<?> fluent,SubscriberItem instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriberItem build() {
    SubscriberItem buildable = new SubscriberItem(fluent.buildChannel(), fluent.getChannelConfigMap(), fluent.getChannelSecret(), fluent.buildSecondaryChannel(), fluent.getSecondaryChannelConfigMap(), fluent.getSecondaryChannelSecret(), fluent.buildSubscription(), fluent.getSubscriptionConfigMap());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}