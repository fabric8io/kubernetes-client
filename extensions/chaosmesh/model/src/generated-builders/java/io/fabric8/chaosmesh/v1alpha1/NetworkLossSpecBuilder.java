package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkLossSpecBuilder extends NetworkLossSpecFluent<NetworkLossSpecBuilder> implements VisitableBuilder<NetworkLossSpec,NetworkLossSpecBuilder>{

  NetworkLossSpecFluent<?> fluent;

  public NetworkLossSpecBuilder() {
    this(new NetworkLossSpec());
  }
  
  public NetworkLossSpecBuilder(NetworkLossSpecFluent<?> fluent) {
    this(fluent, new NetworkLossSpec());
  }
  
  public NetworkLossSpecBuilder(NetworkLossSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkLossSpecBuilder(NetworkLossSpecFluent<?> fluent,NetworkLossSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkLossSpec build() {
    NetworkLossSpec buildable = new NetworkLossSpec(fluent.getCorrelation(), fluent.getDevice(), fluent.getEgressPort(), fluent.getHostname(), fluent.getIpAddress(), fluent.getIpProtocol(), fluent.getPercent(), fluent.getSourcePort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}