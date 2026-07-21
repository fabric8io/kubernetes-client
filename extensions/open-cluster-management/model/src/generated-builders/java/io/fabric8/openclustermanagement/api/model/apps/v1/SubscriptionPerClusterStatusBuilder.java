package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionPerClusterStatusBuilder extends SubscriptionPerClusterStatusFluent<SubscriptionPerClusterStatusBuilder> implements VisitableBuilder<SubscriptionPerClusterStatus,SubscriptionPerClusterStatusBuilder>{

  SubscriptionPerClusterStatusFluent<?> fluent;

  public SubscriptionPerClusterStatusBuilder() {
    this(new SubscriptionPerClusterStatus());
  }
  
  public SubscriptionPerClusterStatusBuilder(SubscriptionPerClusterStatusFluent<?> fluent) {
    this(fluent, new SubscriptionPerClusterStatus());
  }
  
  public SubscriptionPerClusterStatusBuilder(SubscriptionPerClusterStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionPerClusterStatusBuilder(SubscriptionPerClusterStatusFluent<?> fluent,SubscriptionPerClusterStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionPerClusterStatus build() {
    SubscriptionPerClusterStatus buildable = new SubscriptionPerClusterStatus(fluent.getPackages());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}