package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDNSSpecBuilder extends NetworkDNSSpecFluent<NetworkDNSSpecBuilder> implements VisitableBuilder<NetworkDNSSpec,NetworkDNSSpecBuilder>{

  NetworkDNSSpecFluent<?> fluent;

  public NetworkDNSSpecBuilder() {
    this(new NetworkDNSSpec());
  }
  
  public NetworkDNSSpecBuilder(NetworkDNSSpecFluent<?> fluent) {
    this(fluent, new NetworkDNSSpec());
  }
  
  public NetworkDNSSpecBuilder(NetworkDNSSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDNSSpecBuilder(NetworkDNSSpecFluent<?> fluent,NetworkDNSSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDNSSpec build() {
    NetworkDNSSpec buildable = new NetworkDNSSpec(fluent.getDnsDomainName(), fluent.getDnsIp(), fluent.getDnsServer());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}