package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDelaySpecBuilder extends NetworkDelaySpecFluent<NetworkDelaySpecBuilder> implements VisitableBuilder<NetworkDelaySpec,NetworkDelaySpecBuilder>{

  NetworkDelaySpecFluent<?> fluent;

  public NetworkDelaySpecBuilder() {
    this(new NetworkDelaySpec());
  }
  
  public NetworkDelaySpecBuilder(NetworkDelaySpecFluent<?> fluent) {
    this(fluent, new NetworkDelaySpec());
  }
  
  public NetworkDelaySpecBuilder(NetworkDelaySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDelaySpecBuilder(NetworkDelaySpecFluent<?> fluent,NetworkDelaySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDelaySpec build() {
    NetworkDelaySpec buildable = new NetworkDelaySpec(fluent.getAcceptTcpFlags(), fluent.getCorrelation(), fluent.getDevice(), fluent.getEgressPort(), fluent.getHostname(), fluent.getIpAddress(), fluent.getIpProtocol(), fluent.getJitter(), fluent.getLatency(), fluent.getSourcePort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}