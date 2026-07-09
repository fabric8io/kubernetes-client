package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupStatusBuilder extends PodGroupStatusFluent<PodGroupStatusBuilder> implements VisitableBuilder<PodGroupStatus,PodGroupStatusBuilder>{

  PodGroupStatusFluent<?> fluent;

  public PodGroupStatusBuilder() {
    this(new PodGroupStatus());
  }
  
  public PodGroupStatusBuilder(PodGroupStatusFluent<?> fluent) {
    this(fluent, new PodGroupStatus());
  }
  
  public PodGroupStatusBuilder(PodGroupStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupStatusBuilder(PodGroupStatusFluent<?> fluent,PodGroupStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupStatus build() {
    PodGroupStatus buildable = new PodGroupStatus(fluent.getConditions(), fluent.buildResourceClaimStatuses());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}