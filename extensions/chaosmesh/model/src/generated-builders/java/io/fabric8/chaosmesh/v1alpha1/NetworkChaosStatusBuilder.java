package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkChaosStatusBuilder extends NetworkChaosStatusFluent<NetworkChaosStatusBuilder> implements VisitableBuilder<NetworkChaosStatus,NetworkChaosStatusBuilder>{

  NetworkChaosStatusFluent<?> fluent;

  public NetworkChaosStatusBuilder() {
    this(new NetworkChaosStatus());
  }
  
  public NetworkChaosStatusBuilder(NetworkChaosStatusFluent<?> fluent) {
    this(fluent, new NetworkChaosStatus());
  }
  
  public NetworkChaosStatusBuilder(NetworkChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkChaosStatusBuilder(NetworkChaosStatusFluent<?> fluent,NetworkChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkChaosStatus build() {
    NetworkChaosStatus buildable = new NetworkChaosStatus(fluent.buildConditions(), fluent.buildExperiment(), fluent.getInstances());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}