package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkChaosBuilder extends NetworkChaosFluent<NetworkChaosBuilder> implements VisitableBuilder<NetworkChaos,NetworkChaosBuilder>{

  NetworkChaosFluent<?> fluent;

  public NetworkChaosBuilder() {
    this(new NetworkChaos());
  }
  
  public NetworkChaosBuilder(NetworkChaosFluent<?> fluent) {
    this(fluent, new NetworkChaos());
  }
  
  public NetworkChaosBuilder(NetworkChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkChaosBuilder(NetworkChaosFluent<?> fluent,NetworkChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkChaos build() {
    NetworkChaos buildable = new NetworkChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}