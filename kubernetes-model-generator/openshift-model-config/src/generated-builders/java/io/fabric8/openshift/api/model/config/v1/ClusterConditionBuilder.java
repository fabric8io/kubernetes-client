package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterConditionBuilder extends ClusterConditionFluent<ClusterConditionBuilder> implements VisitableBuilder<ClusterCondition,ClusterConditionBuilder>{

  ClusterConditionFluent<?> fluent;

  public ClusterConditionBuilder() {
    this(new ClusterCondition());
  }
  
  public ClusterConditionBuilder(ClusterConditionFluent<?> fluent) {
    this(fluent, new ClusterCondition());
  }
  
  public ClusterConditionBuilder(ClusterCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterConditionBuilder(ClusterConditionFluent<?> fluent,ClusterCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterCondition build() {
    ClusterCondition buildable = new ClusterCondition(fluent.buildPromql(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}