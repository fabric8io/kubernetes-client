package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeploymentConditionBuilder extends ClusterDeploymentConditionFluent<ClusterDeploymentConditionBuilder> implements VisitableBuilder<ClusterDeploymentCondition,ClusterDeploymentConditionBuilder>{

  ClusterDeploymentConditionFluent<?> fluent;

  public ClusterDeploymentConditionBuilder() {
    this(new ClusterDeploymentCondition());
  }
  
  public ClusterDeploymentConditionBuilder(ClusterDeploymentConditionFluent<?> fluent) {
    this(fluent, new ClusterDeploymentCondition());
  }
  
  public ClusterDeploymentConditionBuilder(ClusterDeploymentCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeploymentConditionBuilder(ClusterDeploymentConditionFluent<?> fluent,ClusterDeploymentCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeploymentCondition build() {
    ClusterDeploymentCondition buildable = new ClusterDeploymentCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}