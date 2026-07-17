package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeprovisionConditionBuilder extends ClusterDeprovisionConditionFluent<ClusterDeprovisionConditionBuilder> implements VisitableBuilder<ClusterDeprovisionCondition,ClusterDeprovisionConditionBuilder>{

  ClusterDeprovisionConditionFluent<?> fluent;

  public ClusterDeprovisionConditionBuilder() {
    this(new ClusterDeprovisionCondition());
  }
  
  public ClusterDeprovisionConditionBuilder(ClusterDeprovisionConditionFluent<?> fluent) {
    this(fluent, new ClusterDeprovisionCondition());
  }
  
  public ClusterDeprovisionConditionBuilder(ClusterDeprovisionCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeprovisionConditionBuilder(ClusterDeprovisionConditionFluent<?> fluent,ClusterDeprovisionCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeprovisionCondition build() {
    ClusterDeprovisionCondition buildable = new ClusterDeprovisionCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}