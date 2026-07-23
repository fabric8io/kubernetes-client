package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkPolicyPeerBuilder extends NetworkPolicyPeerFluent<NetworkPolicyPeerBuilder> implements VisitableBuilder<NetworkPolicyPeer,NetworkPolicyPeerBuilder>{

  NetworkPolicyPeerFluent<?> fluent;

  public NetworkPolicyPeerBuilder() {
    this(new NetworkPolicyPeer());
  }
  
  public NetworkPolicyPeerBuilder(NetworkPolicyPeerFluent<?> fluent) {
    this(fluent, new NetworkPolicyPeer());
  }
  
  public NetworkPolicyPeerBuilder(NetworkPolicyPeer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkPolicyPeerBuilder(NetworkPolicyPeerFluent<?> fluent,NetworkPolicyPeer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkPolicyPeer build() {
    NetworkPolicyPeer buildable = new NetworkPolicyPeer(fluent.buildIpBlock(), fluent.buildNamespaceSelector(), fluent.buildPodSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}