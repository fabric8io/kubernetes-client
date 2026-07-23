package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterClaimConditionBuilder extends ClusterClaimConditionFluent<ClusterClaimConditionBuilder> implements VisitableBuilder<ClusterClaimCondition,ClusterClaimConditionBuilder>{

  ClusterClaimConditionFluent<?> fluent;

  public ClusterClaimConditionBuilder() {
    this(new ClusterClaimCondition());
  }
  
  public ClusterClaimConditionBuilder(ClusterClaimConditionFluent<?> fluent) {
    this(fluent, new ClusterClaimCondition());
  }
  
  public ClusterClaimConditionBuilder(ClusterClaimCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterClaimConditionBuilder(ClusterClaimConditionFluent<?> fluent,ClusterClaimCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterClaimCondition build() {
    ClusterClaimCondition buildable = new ClusterClaimCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}