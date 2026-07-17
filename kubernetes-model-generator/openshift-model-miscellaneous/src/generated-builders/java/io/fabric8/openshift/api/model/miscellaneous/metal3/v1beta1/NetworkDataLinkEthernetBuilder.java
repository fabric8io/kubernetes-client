package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataLinkEthernetBuilder extends NetworkDataLinkEthernetFluent<NetworkDataLinkEthernetBuilder> implements VisitableBuilder<NetworkDataLinkEthernet,NetworkDataLinkEthernetBuilder>{

  NetworkDataLinkEthernetFluent<?> fluent;

  public NetworkDataLinkEthernetBuilder() {
    this(new NetworkDataLinkEthernet());
  }
  
  public NetworkDataLinkEthernetBuilder(NetworkDataLinkEthernetFluent<?> fluent) {
    this(fluent, new NetworkDataLinkEthernet());
  }
  
  public NetworkDataLinkEthernetBuilder(NetworkDataLinkEthernet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataLinkEthernetBuilder(NetworkDataLinkEthernetFluent<?> fluent,NetworkDataLinkEthernet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataLinkEthernet build() {
    NetworkDataLinkEthernet buildable = new NetworkDataLinkEthernet(fluent.getId(), fluent.buildMacAddress(), fluent.getMtu(), fluent.getName(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}