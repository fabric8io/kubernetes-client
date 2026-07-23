package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicyStatusFileBuilder extends NodeDisruptionPolicyStatusFileFluent<NodeDisruptionPolicyStatusFileBuilder> implements VisitableBuilder<NodeDisruptionPolicyStatusFile,NodeDisruptionPolicyStatusFileBuilder>{

  NodeDisruptionPolicyStatusFileFluent<?> fluent;

  public NodeDisruptionPolicyStatusFileBuilder() {
    this(new NodeDisruptionPolicyStatusFile());
  }
  
  public NodeDisruptionPolicyStatusFileBuilder(NodeDisruptionPolicyStatusFileFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicyStatusFile());
  }
  
  public NodeDisruptionPolicyStatusFileBuilder(NodeDisruptionPolicyStatusFile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicyStatusFileBuilder(NodeDisruptionPolicyStatusFileFluent<?> fluent,NodeDisruptionPolicyStatusFile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicyStatusFile build() {
    NodeDisruptionPolicyStatusFile buildable = new NodeDisruptionPolicyStatusFile(fluent.buildActions(), fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}