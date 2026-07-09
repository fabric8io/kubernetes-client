package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkPolicyPortBuilder extends NetworkPolicyPortFluent<NetworkPolicyPortBuilder> implements VisitableBuilder<NetworkPolicyPort,NetworkPolicyPortBuilder>{

  NetworkPolicyPortFluent<?> fluent;

  public NetworkPolicyPortBuilder() {
    this(new NetworkPolicyPort());
  }
  
  public NetworkPolicyPortBuilder(NetworkPolicyPortFluent<?> fluent) {
    this(fluent, new NetworkPolicyPort());
  }
  
  public NetworkPolicyPortBuilder(NetworkPolicyPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkPolicyPortBuilder(NetworkPolicyPortFluent<?> fluent,NetworkPolicyPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkPolicyPort build() {
    NetworkPolicyPort buildable = new NetworkPolicyPort(fluent.getEndPort(), fluent.buildPort(), fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}