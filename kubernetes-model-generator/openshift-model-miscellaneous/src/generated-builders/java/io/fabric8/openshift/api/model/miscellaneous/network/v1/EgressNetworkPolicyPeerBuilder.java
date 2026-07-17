package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressNetworkPolicyPeerBuilder extends EgressNetworkPolicyPeerFluent<EgressNetworkPolicyPeerBuilder> implements VisitableBuilder<EgressNetworkPolicyPeer,EgressNetworkPolicyPeerBuilder>{

  EgressNetworkPolicyPeerFluent<?> fluent;

  public EgressNetworkPolicyPeerBuilder() {
    this(new EgressNetworkPolicyPeer());
  }
  
  public EgressNetworkPolicyPeerBuilder(EgressNetworkPolicyPeerFluent<?> fluent) {
    this(fluent, new EgressNetworkPolicyPeer());
  }
  
  public EgressNetworkPolicyPeerBuilder(EgressNetworkPolicyPeer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressNetworkPolicyPeerBuilder(EgressNetworkPolicyPeerFluent<?> fluent,EgressNetworkPolicyPeer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressNetworkPolicyPeer build() {
    EgressNetworkPolicyPeer buildable = new EgressNetworkPolicyPeer(fluent.getCidrSelector(), fluent.getDnsName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}