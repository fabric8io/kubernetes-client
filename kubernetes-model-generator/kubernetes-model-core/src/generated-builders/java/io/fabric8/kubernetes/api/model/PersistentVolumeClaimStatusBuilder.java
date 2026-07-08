package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeClaimStatusBuilder extends PersistentVolumeClaimStatusFluent<PersistentVolumeClaimStatusBuilder> implements VisitableBuilder<PersistentVolumeClaimStatus,PersistentVolumeClaimStatusBuilder>{

  PersistentVolumeClaimStatusFluent<?> fluent;

  public PersistentVolumeClaimStatusBuilder() {
    this(new PersistentVolumeClaimStatus());
  }
  
  public PersistentVolumeClaimStatusBuilder(PersistentVolumeClaimStatusFluent<?> fluent) {
    this(fluent, new PersistentVolumeClaimStatus());
  }
  
  public PersistentVolumeClaimStatusBuilder(PersistentVolumeClaimStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeClaimStatusBuilder(PersistentVolumeClaimStatusFluent<?> fluent,PersistentVolumeClaimStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeClaimStatus build() {
    PersistentVolumeClaimStatus buildable = new PersistentVolumeClaimStatus(fluent.getAccessModes(), fluent.getAllocatedResourceStatuses(), fluent.getAllocatedResources(), fluent.getCapacity(), fluent.buildConditions(), fluent.getCurrentVolumeAttributesClassName(), fluent.buildModifyVolumeStatus(), fluent.getPhase());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}