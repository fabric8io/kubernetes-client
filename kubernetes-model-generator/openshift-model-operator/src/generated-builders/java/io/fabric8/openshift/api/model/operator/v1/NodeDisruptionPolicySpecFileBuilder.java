package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicySpecFileBuilder extends NodeDisruptionPolicySpecFileFluent<NodeDisruptionPolicySpecFileBuilder> implements VisitableBuilder<NodeDisruptionPolicySpecFile,NodeDisruptionPolicySpecFileBuilder>{

  NodeDisruptionPolicySpecFileFluent<?> fluent;

  public NodeDisruptionPolicySpecFileBuilder() {
    this(new NodeDisruptionPolicySpecFile());
  }
  
  public NodeDisruptionPolicySpecFileBuilder(NodeDisruptionPolicySpecFileFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicySpecFile());
  }
  
  public NodeDisruptionPolicySpecFileBuilder(NodeDisruptionPolicySpecFile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicySpecFileBuilder(NodeDisruptionPolicySpecFileFluent<?> fluent,NodeDisruptionPolicySpecFile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicySpecFile build() {
    NodeDisruptionPolicySpecFile buildable = new NodeDisruptionPolicySpecFile(fluent.buildActions(), fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}