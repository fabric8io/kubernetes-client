package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicyStatusSSHKeyBuilder extends NodeDisruptionPolicyStatusSSHKeyFluent<NodeDisruptionPolicyStatusSSHKeyBuilder> implements VisitableBuilder<NodeDisruptionPolicyStatusSSHKey,NodeDisruptionPolicyStatusSSHKeyBuilder>{

  NodeDisruptionPolicyStatusSSHKeyFluent<?> fluent;

  public NodeDisruptionPolicyStatusSSHKeyBuilder() {
    this(new NodeDisruptionPolicyStatusSSHKey());
  }
  
  public NodeDisruptionPolicyStatusSSHKeyBuilder(NodeDisruptionPolicyStatusSSHKeyFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicyStatusSSHKey());
  }
  
  public NodeDisruptionPolicyStatusSSHKeyBuilder(NodeDisruptionPolicyStatusSSHKey instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicyStatusSSHKeyBuilder(NodeDisruptionPolicyStatusSSHKeyFluent<?> fluent,NodeDisruptionPolicyStatusSSHKey instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicyStatusSSHKey build() {
    NodeDisruptionPolicyStatusSSHKey buildable = new NodeDisruptionPolicyStatusSSHKey(fluent.buildActions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}