package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeRuntimeHandlerBuilder extends NodeRuntimeHandlerFluent<NodeRuntimeHandlerBuilder> implements VisitableBuilder<NodeRuntimeHandler,NodeRuntimeHandlerBuilder>{

  NodeRuntimeHandlerFluent<?> fluent;

  public NodeRuntimeHandlerBuilder() {
    this(new NodeRuntimeHandler());
  }
  
  public NodeRuntimeHandlerBuilder(NodeRuntimeHandlerFluent<?> fluent) {
    this(fluent, new NodeRuntimeHandler());
  }
  
  public NodeRuntimeHandlerBuilder(NodeRuntimeHandler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeRuntimeHandlerBuilder(NodeRuntimeHandlerFluent<?> fluent,NodeRuntimeHandler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeRuntimeHandler build() {
    NodeRuntimeHandler buildable = new NodeRuntimeHandler(fluent.buildFeatures(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}