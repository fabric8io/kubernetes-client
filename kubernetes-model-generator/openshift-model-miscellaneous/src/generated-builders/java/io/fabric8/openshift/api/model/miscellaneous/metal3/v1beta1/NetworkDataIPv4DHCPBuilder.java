package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataIPv4DHCPBuilder extends NetworkDataIPv4DHCPFluent<NetworkDataIPv4DHCPBuilder> implements VisitableBuilder<NetworkDataIPv4DHCP,NetworkDataIPv4DHCPBuilder>{

  NetworkDataIPv4DHCPFluent<?> fluent;

  public NetworkDataIPv4DHCPBuilder() {
    this(new NetworkDataIPv4DHCP());
  }
  
  public NetworkDataIPv4DHCPBuilder(NetworkDataIPv4DHCPFluent<?> fluent) {
    this(fluent, new NetworkDataIPv4DHCP());
  }
  
  public NetworkDataIPv4DHCPBuilder(NetworkDataIPv4DHCP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataIPv4DHCPBuilder(NetworkDataIPv4DHCPFluent<?> fluent,NetworkDataIPv4DHCP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataIPv4DHCP build() {
    NetworkDataIPv4DHCP buildable = new NetworkDataIPv4DHCP(fluent.getId(), fluent.getLink(), fluent.buildRoutes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}