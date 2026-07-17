package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataIPv6DHCPBuilder extends NetworkDataIPv6DHCPFluent<NetworkDataIPv6DHCPBuilder> implements VisitableBuilder<NetworkDataIPv6DHCP,NetworkDataIPv6DHCPBuilder>{

  NetworkDataIPv6DHCPFluent<?> fluent;

  public NetworkDataIPv6DHCPBuilder() {
    this(new NetworkDataIPv6DHCP());
  }
  
  public NetworkDataIPv6DHCPBuilder(NetworkDataIPv6DHCPFluent<?> fluent) {
    this(fluent, new NetworkDataIPv6DHCP());
  }
  
  public NetworkDataIPv6DHCPBuilder(NetworkDataIPv6DHCP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataIPv6DHCPBuilder(NetworkDataIPv6DHCPFluent<?> fluent,NetworkDataIPv6DHCP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataIPv6DHCP build() {
    NetworkDataIPv6DHCP buildable = new NetworkDataIPv6DHCP(fluent.getId(), fluent.getLink(), fluent.buildRoutes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}