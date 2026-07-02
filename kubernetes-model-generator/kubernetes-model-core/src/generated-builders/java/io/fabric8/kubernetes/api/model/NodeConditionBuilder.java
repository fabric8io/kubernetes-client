package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeConditionBuilder extends NodeConditionFluent<NodeConditionBuilder> implements VisitableBuilder<NodeCondition,NodeConditionBuilder>{

  NodeConditionFluent<?> fluent;

  public NodeConditionBuilder() {
    this(new NodeCondition());
  }
  
  public NodeConditionBuilder(NodeConditionFluent<?> fluent) {
    this(fluent, new NodeCondition());
  }
  
  public NodeConditionBuilder(NodeCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeConditionBuilder(NodeConditionFluent<?> fluent,NodeCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeCondition build() {
    NodeCondition buildable = new NodeCondition(fluent.getLastHeartbeatTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}