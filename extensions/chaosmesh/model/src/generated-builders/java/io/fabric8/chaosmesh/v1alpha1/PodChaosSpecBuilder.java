package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodChaosSpecBuilder extends PodChaosSpecFluent<PodChaosSpecBuilder> implements VisitableBuilder<PodChaosSpec,PodChaosSpecBuilder>{

  PodChaosSpecFluent<?> fluent;

  public PodChaosSpecBuilder() {
    this(new PodChaosSpec());
  }
  
  public PodChaosSpecBuilder(PodChaosSpecFluent<?> fluent) {
    this(fluent, new PodChaosSpec());
  }
  
  public PodChaosSpecBuilder(PodChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodChaosSpecBuilder(PodChaosSpecFluent<?> fluent,PodChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodChaosSpec build() {
    PodChaosSpec buildable = new PodChaosSpec(fluent.getAction(), fluent.getContainerNames(), fluent.getDuration(), fluent.getGracePeriod(), fluent.getMode(), fluent.getRemoteCluster(), fluent.buildSelector(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}