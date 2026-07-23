package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionStatusBuilder extends SubscriptionStatusFluent<SubscriptionStatusBuilder> implements VisitableBuilder<SubscriptionStatus,SubscriptionStatusBuilder>{

  SubscriptionStatusFluent<?> fluent;

  public SubscriptionStatusBuilder() {
    this(new SubscriptionStatus());
  }
  
  public SubscriptionStatusBuilder(SubscriptionStatusFluent<?> fluent) {
    this(fluent, new SubscriptionStatus());
  }
  
  public SubscriptionStatusBuilder(SubscriptionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionStatusBuilder(SubscriptionStatusFluent<?> fluent,SubscriptionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionStatus build() {
    SubscriptionStatus buildable = new SubscriptionStatus(fluent.buildCatalogHealth(), fluent.buildConditions(), fluent.getCurrentCSV(), fluent.getInstallPlanGeneration(), fluent.buildInstallPlanRef(), fluent.getInstalledCSV(), fluent.buildInstallplan(), fluent.getLastUpdated(), fluent.getReason(), fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}