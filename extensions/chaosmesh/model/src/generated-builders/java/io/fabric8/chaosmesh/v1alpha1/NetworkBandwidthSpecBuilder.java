package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkBandwidthSpecBuilder extends NetworkBandwidthSpecFluent<NetworkBandwidthSpecBuilder> implements VisitableBuilder<NetworkBandwidthSpec,NetworkBandwidthSpecBuilder>{

  NetworkBandwidthSpecFluent<?> fluent;

  public NetworkBandwidthSpecBuilder() {
    this(new NetworkBandwidthSpec());
  }
  
  public NetworkBandwidthSpecBuilder(NetworkBandwidthSpecFluent<?> fluent) {
    this(fluent, new NetworkBandwidthSpec());
  }
  
  public NetworkBandwidthSpecBuilder(NetworkBandwidthSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkBandwidthSpecBuilder(NetworkBandwidthSpecFluent<?> fluent,NetworkBandwidthSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkBandwidthSpec build() {
    NetworkBandwidthSpec buildable = new NetworkBandwidthSpec(fluent.getBuffer(), fluent.getDevice(), fluent.getHostname(), fluent.getIpAddress(), fluent.getLimit(), fluent.getMinburst(), fluent.getPeakrate(), fluent.getRate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}