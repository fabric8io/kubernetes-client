package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicationControllerConditionBuilder extends ReplicationControllerConditionFluent<ReplicationControllerConditionBuilder> implements VisitableBuilder<ReplicationControllerCondition,ReplicationControllerConditionBuilder>{

  ReplicationControllerConditionFluent<?> fluent;

  public ReplicationControllerConditionBuilder() {
    this(new ReplicationControllerCondition());
  }
  
  public ReplicationControllerConditionBuilder(ReplicationControllerConditionFluent<?> fluent) {
    this(fluent, new ReplicationControllerCondition());
  }
  
  public ReplicationControllerConditionBuilder(ReplicationControllerCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicationControllerConditionBuilder(ReplicationControllerConditionFluent<?> fluent,ReplicationControllerCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicationControllerCondition build() {
    ReplicationControllerCondition buildable = new ReplicationControllerCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}