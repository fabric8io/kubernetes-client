package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterClaimStatusBuilder extends ClusterClaimStatusFluent<ClusterClaimStatusBuilder> implements VisitableBuilder<ClusterClaimStatus,ClusterClaimStatusBuilder>{

  ClusterClaimStatusFluent<?> fluent;

  public ClusterClaimStatusBuilder() {
    this(new ClusterClaimStatus());
  }
  
  public ClusterClaimStatusBuilder(ClusterClaimStatusFluent<?> fluent) {
    this(fluent, new ClusterClaimStatus());
  }
  
  public ClusterClaimStatusBuilder(ClusterClaimStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterClaimStatusBuilder(ClusterClaimStatusFluent<?> fluent,ClusterClaimStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterClaimStatus build() {
    ClusterClaimStatus buildable = new ClusterClaimStatus(fluent.buildConditions(), fluent.getLifetime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}