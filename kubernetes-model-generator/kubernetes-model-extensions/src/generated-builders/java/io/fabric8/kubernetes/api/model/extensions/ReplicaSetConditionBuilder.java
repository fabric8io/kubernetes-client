package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicaSetConditionBuilder extends ReplicaSetConditionFluent<ReplicaSetConditionBuilder> implements VisitableBuilder<ReplicaSetCondition,ReplicaSetConditionBuilder>{

  ReplicaSetConditionFluent<?> fluent;

  public ReplicaSetConditionBuilder() {
    this(new ReplicaSetCondition());
  }
  
  public ReplicaSetConditionBuilder(ReplicaSetConditionFluent<?> fluent) {
    this(fluent, new ReplicaSetCondition());
  }
  
  public ReplicaSetConditionBuilder(ReplicaSetCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicaSetConditionBuilder(ReplicaSetConditionFluent<?> fluent,ReplicaSetCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicaSetCondition build() {
    ReplicaSetCondition buildable = new ReplicaSetCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}