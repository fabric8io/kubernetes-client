package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicyClusterStatusBuilder extends NodeDisruptionPolicyClusterStatusFluent<NodeDisruptionPolicyClusterStatusBuilder> implements VisitableBuilder<NodeDisruptionPolicyClusterStatus,NodeDisruptionPolicyClusterStatusBuilder>{

  NodeDisruptionPolicyClusterStatusFluent<?> fluent;

  public NodeDisruptionPolicyClusterStatusBuilder() {
    this(new NodeDisruptionPolicyClusterStatus());
  }
  
  public NodeDisruptionPolicyClusterStatusBuilder(NodeDisruptionPolicyClusterStatusFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicyClusterStatus());
  }
  
  public NodeDisruptionPolicyClusterStatusBuilder(NodeDisruptionPolicyClusterStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicyClusterStatusBuilder(NodeDisruptionPolicyClusterStatusFluent<?> fluent,NodeDisruptionPolicyClusterStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicyClusterStatus build() {
    NodeDisruptionPolicyClusterStatus buildable = new NodeDisruptionPolicyClusterStatus(fluent.buildFiles(), fluent.buildSshkey(), fluent.buildUnits());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}