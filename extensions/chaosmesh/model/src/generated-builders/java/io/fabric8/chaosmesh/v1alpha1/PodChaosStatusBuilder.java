package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodChaosStatusBuilder extends PodChaosStatusFluent<PodChaosStatusBuilder> implements VisitableBuilder<PodChaosStatus,PodChaosStatusBuilder>{

  PodChaosStatusFluent<?> fluent;

  public PodChaosStatusBuilder() {
    this(new PodChaosStatus());
  }
  
  public PodChaosStatusBuilder(PodChaosStatusFluent<?> fluent) {
    this(fluent, new PodChaosStatus());
  }
  
  public PodChaosStatusBuilder(PodChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodChaosStatusBuilder(PodChaosStatusFluent<?> fluent,PodChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodChaosStatus build() {
    PodChaosStatus buildable = new PodChaosStatus(fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}