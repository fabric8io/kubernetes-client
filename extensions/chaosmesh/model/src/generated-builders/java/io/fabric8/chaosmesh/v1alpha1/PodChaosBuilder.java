package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodChaosBuilder extends PodChaosFluent<PodChaosBuilder> implements VisitableBuilder<PodChaos,PodChaosBuilder>{

  PodChaosFluent<?> fluent;

  public PodChaosBuilder() {
    this(new PodChaos());
  }
  
  public PodChaosBuilder(PodChaosFluent<?> fluent) {
    this(fluent, new PodChaos());
  }
  
  public PodChaosBuilder(PodChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodChaosBuilder(PodChaosFluent<?> fluent,PodChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodChaos build() {
    PodChaos buildable = new PodChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}