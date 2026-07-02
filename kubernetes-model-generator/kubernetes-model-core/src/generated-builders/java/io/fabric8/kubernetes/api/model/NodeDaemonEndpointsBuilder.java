package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDaemonEndpointsBuilder extends NodeDaemonEndpointsFluent<NodeDaemonEndpointsBuilder> implements VisitableBuilder<NodeDaemonEndpoints,NodeDaemonEndpointsBuilder>{

  NodeDaemonEndpointsFluent<?> fluent;

  public NodeDaemonEndpointsBuilder() {
    this(new NodeDaemonEndpoints());
  }
  
  public NodeDaemonEndpointsBuilder(NodeDaemonEndpointsFluent<?> fluent) {
    this(fluent, new NodeDaemonEndpoints());
  }
  
  public NodeDaemonEndpointsBuilder(NodeDaemonEndpoints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDaemonEndpointsBuilder(NodeDaemonEndpointsFluent<?> fluent,NodeDaemonEndpoints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDaemonEndpoints build() {
    NodeDaemonEndpoints buildable = new NodeDaemonEndpoints(fluent.buildKubeletEndpoint());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}