package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicationControllerStatusBuilder extends ReplicationControllerStatusFluent<ReplicationControllerStatusBuilder> implements VisitableBuilder<ReplicationControllerStatus,ReplicationControllerStatusBuilder>{

  ReplicationControllerStatusFluent<?> fluent;

  public ReplicationControllerStatusBuilder() {
    this(new ReplicationControllerStatus());
  }
  
  public ReplicationControllerStatusBuilder(ReplicationControllerStatusFluent<?> fluent) {
    this(fluent, new ReplicationControllerStatus());
  }
  
  public ReplicationControllerStatusBuilder(ReplicationControllerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicationControllerStatusBuilder(ReplicationControllerStatusFluent<?> fluent,ReplicationControllerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicationControllerStatus build() {
    ReplicationControllerStatus buildable = new ReplicationControllerStatus(fluent.getAvailableReplicas(), fluent.buildConditions(), fluent.getFullyLabeledReplicas(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}