package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeStatusBuilder extends NodeStatusFluent<NodeStatusBuilder> implements VisitableBuilder<NodeStatus,NodeStatusBuilder>{

  NodeStatusFluent<?> fluent;

  public NodeStatusBuilder() {
    this(new NodeStatus());
  }
  
  public NodeStatusBuilder(NodeStatusFluent<?> fluent) {
    this(fluent, new NodeStatus());
  }
  
  public NodeStatusBuilder(NodeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeStatusBuilder(NodeStatusFluent<?> fluent,NodeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeStatus build() {
    NodeStatus buildable = new NodeStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}