package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDuplicateSpecBuilder extends NetworkDuplicateSpecFluent<NetworkDuplicateSpecBuilder> implements VisitableBuilder<NetworkDuplicateSpec,NetworkDuplicateSpecBuilder>{

  NetworkDuplicateSpecFluent<?> fluent;

  public NetworkDuplicateSpecBuilder() {
    this(new NetworkDuplicateSpec());
  }
  
  public NetworkDuplicateSpecBuilder(NetworkDuplicateSpecFluent<?> fluent) {
    this(fluent, new NetworkDuplicateSpec());
  }
  
  public NetworkDuplicateSpecBuilder(NetworkDuplicateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDuplicateSpecBuilder(NetworkDuplicateSpecFluent<?> fluent,NetworkDuplicateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDuplicateSpec build() {
    NetworkDuplicateSpec buildable = new NetworkDuplicateSpec(fluent.getCorrelation(), fluent.getDevice(), fluent.getEgressPort(), fluent.getHostname(), fluent.getIpAddress(), fluent.getIpProtocol(), fluent.getPercent(), fluent.getSourcePort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}