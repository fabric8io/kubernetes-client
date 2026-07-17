package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionCatalogHealthBuilder extends SubscriptionCatalogHealthFluent<SubscriptionCatalogHealthBuilder> implements VisitableBuilder<SubscriptionCatalogHealth,SubscriptionCatalogHealthBuilder>{

  SubscriptionCatalogHealthFluent<?> fluent;

  public SubscriptionCatalogHealthBuilder() {
    this(new SubscriptionCatalogHealth());
  }
  
  public SubscriptionCatalogHealthBuilder(SubscriptionCatalogHealthFluent<?> fluent) {
    this(fluent, new SubscriptionCatalogHealth());
  }
  
  public SubscriptionCatalogHealthBuilder(SubscriptionCatalogHealth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionCatalogHealthBuilder(SubscriptionCatalogHealthFluent<?> fluent,SubscriptionCatalogHealth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionCatalogHealth build() {
    SubscriptionCatalogHealth buildable = new SubscriptionCatalogHealth(fluent.buildCatalogSourceRef(), fluent.getHealthy(), fluent.getLastUpdated());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}