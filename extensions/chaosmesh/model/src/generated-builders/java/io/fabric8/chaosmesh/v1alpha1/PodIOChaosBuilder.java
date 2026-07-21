package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodIOChaosBuilder extends PodIOChaosFluent<PodIOChaosBuilder> implements VisitableBuilder<PodIOChaos,PodIOChaosBuilder>{

  PodIOChaosFluent<?> fluent;

  public PodIOChaosBuilder() {
    this(new PodIOChaos());
  }
  
  public PodIOChaosBuilder(PodIOChaosFluent<?> fluent) {
    this(fluent, new PodIOChaos());
  }
  
  public PodIOChaosBuilder(PodIOChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodIOChaosBuilder(PodIOChaosFluent<?> fluent,PodIOChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodIOChaos build() {
    PodIOChaos buildable = new PodIOChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}