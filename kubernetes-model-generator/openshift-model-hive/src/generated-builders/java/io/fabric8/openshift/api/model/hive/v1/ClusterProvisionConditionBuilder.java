package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterProvisionConditionBuilder extends ClusterProvisionConditionFluent<ClusterProvisionConditionBuilder> implements VisitableBuilder<ClusterProvisionCondition,ClusterProvisionConditionBuilder>{

  ClusterProvisionConditionFluent<?> fluent;

  public ClusterProvisionConditionBuilder() {
    this(new ClusterProvisionCondition());
  }
  
  public ClusterProvisionConditionBuilder(ClusterProvisionConditionFluent<?> fluent) {
    this(fluent, new ClusterProvisionCondition());
  }
  
  public ClusterProvisionConditionBuilder(ClusterProvisionCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterProvisionConditionBuilder(ClusterProvisionConditionFluent<?> fluent,ClusterProvisionCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterProvisionCondition build() {
    ClusterProvisionCondition buildable = new ClusterProvisionCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}