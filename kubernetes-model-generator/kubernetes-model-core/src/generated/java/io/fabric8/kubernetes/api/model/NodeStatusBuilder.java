package io.fabric8.kubernetes.api.model;

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
    NodeStatus buildable = new NodeStatus(fluent.buildAddresses(), fluent.getAllocatable(), fluent.getCapacity(), fluent.buildConditions(), fluent.buildConfig(), fluent.buildDaemonEndpoints(), fluent.getDeclaredFeatures(), fluent.buildFeatures(), fluent.buildImages(), fluent.buildNodeInfo(), fluent.getPhase(), fluent.buildRuntimeHandlers(), fluent.buildVolumesAttached(), fluent.getVolumesInUse());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}