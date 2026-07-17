package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataNetworkBuilder extends NetworkDataNetworkFluent<NetworkDataNetworkBuilder> implements VisitableBuilder<NetworkDataNetwork,NetworkDataNetworkBuilder>{

  NetworkDataNetworkFluent<?> fluent;

  public NetworkDataNetworkBuilder() {
    this(new NetworkDataNetwork());
  }
  
  public NetworkDataNetworkBuilder(NetworkDataNetworkFluent<?> fluent) {
    this(fluent, new NetworkDataNetwork());
  }
  
  public NetworkDataNetworkBuilder(NetworkDataNetwork instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataNetworkBuilder(NetworkDataNetworkFluent<?> fluent,NetworkDataNetwork instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataNetwork build() {
    NetworkDataNetwork buildable = new NetworkDataNetwork(fluent.buildIpv4(), fluent.buildIpv4DHCP(), fluent.buildIpv6(), fluent.buildIpv6DHCP(), fluent.buildIpv6SLAAC());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}