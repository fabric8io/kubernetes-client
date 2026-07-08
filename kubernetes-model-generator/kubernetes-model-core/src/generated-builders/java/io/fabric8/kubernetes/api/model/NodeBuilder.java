package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeBuilder extends NodeFluent<NodeBuilder> implements VisitableBuilder<Node,NodeBuilder>{

  NodeFluent<?> fluent;

  public NodeBuilder() {
    this(new Node());
  }
  
  public NodeBuilder(NodeFluent<?> fluent) {
    this(fluent, new Node());
  }
  
  public NodeBuilder(Node instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeBuilder(NodeFluent<?> fluent,Node instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Node build() {
    Node buildable = new Node(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}