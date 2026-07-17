package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BMCEventSubscriptionBuilder extends BMCEventSubscriptionFluent<BMCEventSubscriptionBuilder> implements VisitableBuilder<BMCEventSubscription,BMCEventSubscriptionBuilder>{

  BMCEventSubscriptionFluent<?> fluent;

  public BMCEventSubscriptionBuilder() {
    this(new BMCEventSubscription());
  }
  
  public BMCEventSubscriptionBuilder(BMCEventSubscriptionFluent<?> fluent) {
    this(fluent, new BMCEventSubscription());
  }
  
  public BMCEventSubscriptionBuilder(BMCEventSubscription instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BMCEventSubscriptionBuilder(BMCEventSubscriptionFluent<?> fluent,BMCEventSubscription instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BMCEventSubscription build() {
    BMCEventSubscription buildable = new BMCEventSubscription(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}