package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicySpecActionBuilder extends NodeDisruptionPolicySpecActionFluent<NodeDisruptionPolicySpecActionBuilder> implements VisitableBuilder<NodeDisruptionPolicySpecAction,NodeDisruptionPolicySpecActionBuilder>{

  NodeDisruptionPolicySpecActionFluent<?> fluent;

  public NodeDisruptionPolicySpecActionBuilder() {
    this(new NodeDisruptionPolicySpecAction());
  }
  
  public NodeDisruptionPolicySpecActionBuilder(NodeDisruptionPolicySpecActionFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicySpecAction());
  }
  
  public NodeDisruptionPolicySpecActionBuilder(NodeDisruptionPolicySpecAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicySpecActionBuilder(NodeDisruptionPolicySpecActionFluent<?> fluent,NodeDisruptionPolicySpecAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicySpecAction build() {
    NodeDisruptionPolicySpecAction buildable = new NodeDisruptionPolicySpecAction(fluent.buildReload(), fluent.buildRestart(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}