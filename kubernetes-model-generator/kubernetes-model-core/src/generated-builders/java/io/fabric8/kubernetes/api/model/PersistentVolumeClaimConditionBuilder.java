package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeClaimConditionBuilder extends PersistentVolumeClaimConditionFluent<PersistentVolumeClaimConditionBuilder> implements VisitableBuilder<PersistentVolumeClaimCondition,PersistentVolumeClaimConditionBuilder>{

  PersistentVolumeClaimConditionFluent<?> fluent;

  public PersistentVolumeClaimConditionBuilder() {
    this(new PersistentVolumeClaimCondition());
  }
  
  public PersistentVolumeClaimConditionBuilder(PersistentVolumeClaimConditionFluent<?> fluent) {
    this(fluent, new PersistentVolumeClaimCondition());
  }
  
  public PersistentVolumeClaimConditionBuilder(PersistentVolumeClaimCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeClaimConditionBuilder(PersistentVolumeClaimConditionFluent<?> fluent,PersistentVolumeClaimCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeClaimCondition build() {
    PersistentVolumeClaimCondition buildable = new PersistentVolumeClaimCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}