package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkPolicyBuilder extends NetworkPolicyFluent<NetworkPolicyBuilder> implements VisitableBuilder<NetworkPolicy,NetworkPolicyBuilder>{

  NetworkPolicyFluent<?> fluent;

  public NetworkPolicyBuilder() {
    this(new NetworkPolicy());
  }
  
  public NetworkPolicyBuilder(NetworkPolicyFluent<?> fluent) {
    this(fluent, new NetworkPolicy());
  }
  
  public NetworkPolicyBuilder(NetworkPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkPolicyBuilder(NetworkPolicyFluent<?> fluent,NetworkPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkPolicy build() {
    NetworkPolicy buildable = new NetworkPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}