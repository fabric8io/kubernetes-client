package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodIOChaosStatusBuilder extends PodIOChaosStatusFluent<PodIOChaosStatusBuilder> implements VisitableBuilder<PodIOChaosStatus,PodIOChaosStatusBuilder>{

  PodIOChaosStatusFluent<?> fluent;

  public PodIOChaosStatusBuilder() {
    this(new PodIOChaosStatus());
  }
  
  public PodIOChaosStatusBuilder(PodIOChaosStatusFluent<?> fluent) {
    this(fluent, new PodIOChaosStatus());
  }
  
  public PodIOChaosStatusBuilder(PodIOChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodIOChaosStatusBuilder(PodIOChaosStatusFluent<?> fluent,PodIOChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodIOChaosStatus build() {
    PodIOChaosStatus buildable = new PodIOChaosStatus(fluent.getFailedMessage(), fluent.getObservedGeneration(), fluent.getPid(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}