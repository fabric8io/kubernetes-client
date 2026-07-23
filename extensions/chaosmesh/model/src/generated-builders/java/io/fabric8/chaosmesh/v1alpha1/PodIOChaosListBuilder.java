package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodIOChaosListBuilder extends PodIOChaosListFluent<PodIOChaosListBuilder> implements VisitableBuilder<PodIOChaosList,PodIOChaosListBuilder>{

  PodIOChaosListFluent<?> fluent;

  public PodIOChaosListBuilder() {
    this(new PodIOChaosList());
  }
  
  public PodIOChaosListBuilder(PodIOChaosListFluent<?> fluent) {
    this(fluent, new PodIOChaosList());
  }
  
  public PodIOChaosListBuilder(PodIOChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodIOChaosListBuilder(PodIOChaosListFluent<?> fluent,PodIOChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodIOChaosList build() {
    PodIOChaosList buildable = new PodIOChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}