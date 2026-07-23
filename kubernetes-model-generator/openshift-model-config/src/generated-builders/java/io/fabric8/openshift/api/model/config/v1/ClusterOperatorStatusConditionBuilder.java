package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterOperatorStatusConditionBuilder extends ClusterOperatorStatusConditionFluent<ClusterOperatorStatusConditionBuilder> implements VisitableBuilder<ClusterOperatorStatusCondition,ClusterOperatorStatusConditionBuilder>{

  ClusterOperatorStatusConditionFluent<?> fluent;

  public ClusterOperatorStatusConditionBuilder() {
    this(new ClusterOperatorStatusCondition());
  }
  
  public ClusterOperatorStatusConditionBuilder(ClusterOperatorStatusConditionFluent<?> fluent) {
    this(fluent, new ClusterOperatorStatusCondition());
  }
  
  public ClusterOperatorStatusConditionBuilder(ClusterOperatorStatusCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterOperatorStatusConditionBuilder(ClusterOperatorStatusConditionFluent<?> fluent,ClusterOperatorStatusCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterOperatorStatusCondition build() {
    ClusterOperatorStatusCondition buildable = new ClusterOperatorStatusCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}