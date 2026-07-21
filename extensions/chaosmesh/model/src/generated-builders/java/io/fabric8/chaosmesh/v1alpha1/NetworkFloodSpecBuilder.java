package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkFloodSpecBuilder extends NetworkFloodSpecFluent<NetworkFloodSpecBuilder> implements VisitableBuilder<NetworkFloodSpec,NetworkFloodSpecBuilder>{

  NetworkFloodSpecFluent<?> fluent;

  public NetworkFloodSpecBuilder() {
    this(new NetworkFloodSpec());
  }
  
  public NetworkFloodSpecBuilder(NetworkFloodSpecFluent<?> fluent) {
    this(fluent, new NetworkFloodSpec());
  }
  
  public NetworkFloodSpecBuilder(NetworkFloodSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkFloodSpecBuilder(NetworkFloodSpecFluent<?> fluent,NetworkFloodSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkFloodSpec build() {
    NetworkFloodSpec buildable = new NetworkFloodSpec(fluent.getDuration(), fluent.getIpAddress(), fluent.getParallel(), fluent.getPort(), fluent.getRate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}