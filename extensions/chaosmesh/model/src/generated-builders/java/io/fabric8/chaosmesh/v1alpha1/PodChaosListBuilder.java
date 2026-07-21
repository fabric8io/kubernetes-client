package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodChaosListBuilder extends PodChaosListFluent<PodChaosListBuilder> implements VisitableBuilder<PodChaosList,PodChaosListBuilder>{

  PodChaosListFluent<?> fluent;

  public PodChaosListBuilder() {
    this(new PodChaosList());
  }
  
  public PodChaosListBuilder(PodChaosListFluent<?> fluent) {
    this(fluent, new PodChaosList());
  }
  
  public PodChaosListBuilder(PodChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodChaosListBuilder(PodChaosListFluent<?> fluent,PodChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodChaosList build() {
    PodChaosList buildable = new PodChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}