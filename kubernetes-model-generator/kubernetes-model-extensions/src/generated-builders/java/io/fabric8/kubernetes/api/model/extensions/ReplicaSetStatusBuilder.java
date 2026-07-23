package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicaSetStatusBuilder extends ReplicaSetStatusFluent<ReplicaSetStatusBuilder> implements VisitableBuilder<ReplicaSetStatus,ReplicaSetStatusBuilder>{

  ReplicaSetStatusFluent<?> fluent;

  public ReplicaSetStatusBuilder() {
    this(new ReplicaSetStatus());
  }
  
  public ReplicaSetStatusBuilder(ReplicaSetStatusFluent<?> fluent) {
    this(fluent, new ReplicaSetStatus());
  }
  
  public ReplicaSetStatusBuilder(ReplicaSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicaSetStatusBuilder(ReplicaSetStatusFluent<?> fluent,ReplicaSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicaSetStatus build() {
    ReplicaSetStatus buildable = new ReplicaSetStatus(fluent.getAvailableReplicas(), fluent.buildConditions(), fluent.getFullyLabeledReplicas(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}