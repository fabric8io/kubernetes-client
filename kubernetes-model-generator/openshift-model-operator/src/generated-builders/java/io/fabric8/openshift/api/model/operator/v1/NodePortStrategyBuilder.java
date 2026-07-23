package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodePortStrategyBuilder extends NodePortStrategyFluent<NodePortStrategyBuilder> implements VisitableBuilder<NodePortStrategy,NodePortStrategyBuilder>{

  NodePortStrategyFluent<?> fluent;

  public NodePortStrategyBuilder() {
    this(new NodePortStrategy());
  }
  
  public NodePortStrategyBuilder(NodePortStrategyFluent<?> fluent) {
    this(fluent, new NodePortStrategy());
  }
  
  public NodePortStrategyBuilder(NodePortStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodePortStrategyBuilder(NodePortStrategyFluent<?> fluent,NodePortStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodePortStrategy build() {
    NodePortStrategy buildable = new NodePortStrategy(fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}