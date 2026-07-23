package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterPoolClaimLifetimeBuilder extends ClusterPoolClaimLifetimeFluent<ClusterPoolClaimLifetimeBuilder> implements VisitableBuilder<ClusterPoolClaimLifetime,ClusterPoolClaimLifetimeBuilder>{

  ClusterPoolClaimLifetimeFluent<?> fluent;

  public ClusterPoolClaimLifetimeBuilder() {
    this(new ClusterPoolClaimLifetime());
  }
  
  public ClusterPoolClaimLifetimeBuilder(ClusterPoolClaimLifetimeFluent<?> fluent) {
    this(fluent, new ClusterPoolClaimLifetime());
  }
  
  public ClusterPoolClaimLifetimeBuilder(ClusterPoolClaimLifetime instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterPoolClaimLifetimeBuilder(ClusterPoolClaimLifetimeFluent<?> fluent,ClusterPoolClaimLifetime instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterPoolClaimLifetime build() {
    ClusterPoolClaimLifetime buildable = new ClusterPoolClaimLifetime(fluent.getDefault(), fluent.getMaximum());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}