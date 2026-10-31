package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkSpecBuilder extends NetworkSpecFluent<NetworkSpecBuilder> implements VisitableBuilder<NetworkSpec,NetworkSpecBuilder>{

  NetworkSpecFluent<?> fluent;

  public NetworkSpecBuilder() {
    this(new NetworkSpec());
  }
  
  public NetworkSpecBuilder(NetworkSpecFluent<?> fluent) {
    this(fluent, new NetworkSpec());
  }
  
  public NetworkSpecBuilder(NetworkSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkSpecBuilder(NetworkSpecFluent<?> fluent,NetworkSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkSpec build() {
    NetworkSpec buildable = new NetworkSpec(fluent.buildEvpn(), fluent.buildLayer2(), fluent.buildLayer3(), fluent.buildLocalnet(), fluent.buildNoOverlay(), fluent.getTopology(), fluent.getTransport());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}