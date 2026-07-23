package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodNetworkChaosBuilder extends PodNetworkChaosFluent<PodNetworkChaosBuilder> implements VisitableBuilder<PodNetworkChaos,PodNetworkChaosBuilder>{

  PodNetworkChaosFluent<?> fluent;

  public PodNetworkChaosBuilder() {
    this(new PodNetworkChaos());
  }
  
  public PodNetworkChaosBuilder(PodNetworkChaosFluent<?> fluent) {
    this(fluent, new PodNetworkChaos());
  }
  
  public PodNetworkChaosBuilder(PodNetworkChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodNetworkChaosBuilder(PodNetworkChaosFluent<?> fluent,PodNetworkChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodNetworkChaos build() {
    PodNetworkChaos buildable = new PodNetworkChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}