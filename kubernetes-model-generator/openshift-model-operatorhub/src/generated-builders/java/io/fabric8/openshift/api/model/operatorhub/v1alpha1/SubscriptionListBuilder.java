package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionListBuilder extends SubscriptionListFluent<SubscriptionListBuilder> implements VisitableBuilder<SubscriptionList,SubscriptionListBuilder>{

  SubscriptionListFluent<?> fluent;

  public SubscriptionListBuilder() {
    this(new SubscriptionList());
  }
  
  public SubscriptionListBuilder(SubscriptionListFluent<?> fluent) {
    this(fluent, new SubscriptionList());
  }
  
  public SubscriptionListBuilder(SubscriptionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionListBuilder(SubscriptionListFluent<?> fluent,SubscriptionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionList build() {
    SubscriptionList buildable = new SubscriptionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}