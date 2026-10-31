package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkTopologySpecBuilder extends NetworkTopologySpecFluent<NetworkTopologySpecBuilder> implements VisitableBuilder<NetworkTopologySpec,NetworkTopologySpecBuilder>{

  NetworkTopologySpecFluent<?> fluent;

  public NetworkTopologySpecBuilder() {
    this(new NetworkTopologySpec());
  }
  
  public NetworkTopologySpecBuilder(NetworkTopologySpecFluent<?> fluent) {
    this(fluent, new NetworkTopologySpec());
  }
  
  public NetworkTopologySpecBuilder(NetworkTopologySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkTopologySpecBuilder(NetworkTopologySpecFluent<?> fluent,NetworkTopologySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkTopologySpec build() {
    NetworkTopologySpec buildable = new NetworkTopologySpec(fluent.getHighestTierAllowed(), fluent.getHighestTierName(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}