package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterServiceVersionConditionBuilder extends ClusterServiceVersionConditionFluent<ClusterServiceVersionConditionBuilder> implements VisitableBuilder<ClusterServiceVersionCondition,ClusterServiceVersionConditionBuilder>{

  ClusterServiceVersionConditionFluent<?> fluent;

  public ClusterServiceVersionConditionBuilder() {
    this(new ClusterServiceVersionCondition());
  }
  
  public ClusterServiceVersionConditionBuilder(ClusterServiceVersionConditionFluent<?> fluent) {
    this(fluent, new ClusterServiceVersionCondition());
  }
  
  public ClusterServiceVersionConditionBuilder(ClusterServiceVersionCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterServiceVersionConditionBuilder(ClusterServiceVersionConditionFluent<?> fluent,ClusterServiceVersionCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterServiceVersionCondition build() {
    ClusterServiceVersionCondition buildable = new ClusterServiceVersionCondition(fluent.getLastTransitionTime(), fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getPhase(), fluent.getReason());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}