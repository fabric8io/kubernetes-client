package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicySpecSSHKeyBuilder extends NodeDisruptionPolicySpecSSHKeyFluent<NodeDisruptionPolicySpecSSHKeyBuilder> implements VisitableBuilder<NodeDisruptionPolicySpecSSHKey,NodeDisruptionPolicySpecSSHKeyBuilder>{

  NodeDisruptionPolicySpecSSHKeyFluent<?> fluent;

  public NodeDisruptionPolicySpecSSHKeyBuilder() {
    this(new NodeDisruptionPolicySpecSSHKey());
  }
  
  public NodeDisruptionPolicySpecSSHKeyBuilder(NodeDisruptionPolicySpecSSHKeyFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicySpecSSHKey());
  }
  
  public NodeDisruptionPolicySpecSSHKeyBuilder(NodeDisruptionPolicySpecSSHKey instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicySpecSSHKeyBuilder(NodeDisruptionPolicySpecSSHKeyFluent<?> fluent,NodeDisruptionPolicySpecSSHKey instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicySpecSSHKey build() {
    NodeDisruptionPolicySpecSSHKey buildable = new NodeDisruptionPolicySpecSSHKey(fluent.buildActions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}