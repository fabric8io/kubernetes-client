package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodNetworkChaosListBuilder extends PodNetworkChaosListFluent<PodNetworkChaosListBuilder> implements VisitableBuilder<PodNetworkChaosList,PodNetworkChaosListBuilder>{

  PodNetworkChaosListFluent<?> fluent;

  public PodNetworkChaosListBuilder() {
    this(new PodNetworkChaosList());
  }
  
  public PodNetworkChaosListBuilder(PodNetworkChaosListFluent<?> fluent) {
    this(fluent, new PodNetworkChaosList());
  }
  
  public PodNetworkChaosListBuilder(PodNetworkChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodNetworkChaosListBuilder(PodNetworkChaosListFluent<?> fluent,PodNetworkChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodNetworkChaosList build() {
    PodNetworkChaosList buildable = new PodNetworkChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}