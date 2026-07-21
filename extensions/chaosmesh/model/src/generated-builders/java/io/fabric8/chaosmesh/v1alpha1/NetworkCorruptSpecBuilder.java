package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkCorruptSpecBuilder extends NetworkCorruptSpecFluent<NetworkCorruptSpecBuilder> implements VisitableBuilder<NetworkCorruptSpec,NetworkCorruptSpecBuilder>{

  NetworkCorruptSpecFluent<?> fluent;

  public NetworkCorruptSpecBuilder() {
    this(new NetworkCorruptSpec());
  }
  
  public NetworkCorruptSpecBuilder(NetworkCorruptSpecFluent<?> fluent) {
    this(fluent, new NetworkCorruptSpec());
  }
  
  public NetworkCorruptSpecBuilder(NetworkCorruptSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkCorruptSpecBuilder(NetworkCorruptSpecFluent<?> fluent,NetworkCorruptSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkCorruptSpec build() {
    NetworkCorruptSpec buildable = new NetworkCorruptSpec(fluent.getCorrelation(), fluent.getDevice(), fluent.getEgressPort(), fluent.getHostname(), fluent.getIpAddress(), fluent.getIpProtocol(), fluent.getPercent(), fluent.getSourcePort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}