package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkLinkEthernetMacBuilder extends NetworkLinkEthernetMacFluent<NetworkLinkEthernetMacBuilder> implements VisitableBuilder<NetworkLinkEthernetMac,NetworkLinkEthernetMacBuilder>{

  NetworkLinkEthernetMacFluent<?> fluent;

  public NetworkLinkEthernetMacBuilder() {
    this(new NetworkLinkEthernetMac());
  }
  
  public NetworkLinkEthernetMacBuilder(NetworkLinkEthernetMacFluent<?> fluent) {
    this(fluent, new NetworkLinkEthernetMac());
  }
  
  public NetworkLinkEthernetMacBuilder(NetworkLinkEthernetMac instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkLinkEthernetMacBuilder(NetworkLinkEthernetMacFluent<?> fluent,NetworkLinkEthernetMac instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkLinkEthernetMac build() {
    NetworkLinkEthernetMac buildable = new NetworkLinkEthernetMac(fluent.buildFromAnnotation(), fluent.getFromHostInterface(), fluent.getString());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}