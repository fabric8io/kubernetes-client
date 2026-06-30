package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TCPSocketActionBuilder extends TCPSocketActionFluent<TCPSocketActionBuilder> implements VisitableBuilder<TCPSocketAction,TCPSocketActionBuilder>{

  TCPSocketActionFluent<?> fluent;

  public TCPSocketActionBuilder() {
    this(new TCPSocketAction());
  }
  
  public TCPSocketActionBuilder(TCPSocketActionFluent<?> fluent) {
    this(fluent, new TCPSocketAction());
  }
  
  public TCPSocketActionBuilder(TCPSocketAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TCPSocketActionBuilder(TCPSocketActionFluent<?> fluent,TCPSocketAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TCPSocketAction build() {
    TCPSocketAction buildable = new TCPSocketAction(fluent.getHost(), fluent.buildPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}