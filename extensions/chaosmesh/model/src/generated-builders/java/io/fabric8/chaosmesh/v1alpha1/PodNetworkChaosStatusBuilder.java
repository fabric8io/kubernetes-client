package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodNetworkChaosStatusBuilder extends PodNetworkChaosStatusFluent<PodNetworkChaosStatusBuilder> implements VisitableBuilder<PodNetworkChaosStatus,PodNetworkChaosStatusBuilder>{

  PodNetworkChaosStatusFluent<?> fluent;

  public PodNetworkChaosStatusBuilder() {
    this(new PodNetworkChaosStatus());
  }
  
  public PodNetworkChaosStatusBuilder(PodNetworkChaosStatusFluent<?> fluent) {
    this(fluent, new PodNetworkChaosStatus());
  }
  
  public PodNetworkChaosStatusBuilder(PodNetworkChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodNetworkChaosStatusBuilder(PodNetworkChaosStatusFluent<?> fluent,PodNetworkChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodNetworkChaosStatus build() {
    PodNetworkChaosStatus buildable = new PodNetworkChaosStatus(fluent.getFailedMessage(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}