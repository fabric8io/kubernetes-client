package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeConfigStatusBuilder extends NodeConfigStatusFluent<NodeConfigStatusBuilder> implements VisitableBuilder<NodeConfigStatus,NodeConfigStatusBuilder>{

  NodeConfigStatusFluent<?> fluent;

  public NodeConfigStatusBuilder() {
    this(new NodeConfigStatus());
  }
  
  public NodeConfigStatusBuilder(NodeConfigStatusFluent<?> fluent) {
    this(fluent, new NodeConfigStatus());
  }
  
  public NodeConfigStatusBuilder(NodeConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeConfigStatusBuilder(NodeConfigStatusFluent<?> fluent,NodeConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeConfigStatus build() {
    NodeConfigStatus buildable = new NodeConfigStatus(fluent.buildActive(), fluent.buildAssigned(), fluent.getError(), fluent.buildLastKnownGood());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}