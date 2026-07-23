package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterPoolConditionBuilder extends ClusterPoolConditionFluent<ClusterPoolConditionBuilder> implements VisitableBuilder<ClusterPoolCondition,ClusterPoolConditionBuilder>{

  ClusterPoolConditionFluent<?> fluent;

  public ClusterPoolConditionBuilder() {
    this(new ClusterPoolCondition());
  }
  
  public ClusterPoolConditionBuilder(ClusterPoolConditionFluent<?> fluent) {
    this(fluent, new ClusterPoolCondition());
  }
  
  public ClusterPoolConditionBuilder(ClusterPoolCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterPoolConditionBuilder(ClusterPoolConditionFluent<?> fluent,ClusterPoolCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterPoolCondition build() {
    ClusterPoolCondition buildable = new ClusterPoolCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}