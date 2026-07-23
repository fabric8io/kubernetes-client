package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkChaosListBuilder extends NetworkChaosListFluent<NetworkChaosListBuilder> implements VisitableBuilder<NetworkChaosList,NetworkChaosListBuilder>{

  NetworkChaosListFluent<?> fluent;

  public NetworkChaosListBuilder() {
    this(new NetworkChaosList());
  }
  
  public NetworkChaosListBuilder(NetworkChaosListFluent<?> fluent) {
    this(fluent, new NetworkChaosList());
  }
  
  public NetworkChaosListBuilder(NetworkChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkChaosListBuilder(NetworkChaosListFluent<?> fluent,NetworkChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkChaosList build() {
    NetworkChaosList buildable = new NetworkChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}