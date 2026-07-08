package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeStatusBuilder extends PersistentVolumeStatusFluent<PersistentVolumeStatusBuilder> implements VisitableBuilder<PersistentVolumeStatus,PersistentVolumeStatusBuilder>{

  PersistentVolumeStatusFluent<?> fluent;

  public PersistentVolumeStatusBuilder() {
    this(new PersistentVolumeStatus());
  }
  
  public PersistentVolumeStatusBuilder(PersistentVolumeStatusFluent<?> fluent) {
    this(fluent, new PersistentVolumeStatus());
  }
  
  public PersistentVolumeStatusBuilder(PersistentVolumeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeStatusBuilder(PersistentVolumeStatusFluent<?> fluent,PersistentVolumeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeStatus build() {
    PersistentVolumeStatus buildable = new PersistentVolumeStatus(fluent.getLastPhaseTransitionTime(), fluent.getMessage(), fluent.getPhase(), fluent.getReason());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}