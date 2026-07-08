package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeAddressBuilder extends NodeAddressFluent<NodeAddressBuilder> implements VisitableBuilder<NodeAddress,NodeAddressBuilder>{

  NodeAddressFluent<?> fluent;

  public NodeAddressBuilder() {
    this(new NodeAddress());
  }
  
  public NodeAddressBuilder(NodeAddressFluent<?> fluent) {
    this(fluent, new NodeAddress());
  }
  
  public NodeAddressBuilder(NodeAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeAddressBuilder(NodeAddressFluent<?> fluent,NodeAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeAddress build() {
    NodeAddress buildable = new NodeAddress(fluent.getAddress(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}