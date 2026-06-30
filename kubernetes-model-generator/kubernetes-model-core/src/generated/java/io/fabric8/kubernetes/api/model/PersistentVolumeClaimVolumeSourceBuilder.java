package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeClaimVolumeSourceBuilder extends PersistentVolumeClaimVolumeSourceFluent<PersistentVolumeClaimVolumeSourceBuilder> implements VisitableBuilder<PersistentVolumeClaimVolumeSource,PersistentVolumeClaimVolumeSourceBuilder>{

  PersistentVolumeClaimVolumeSourceFluent<?> fluent;

  public PersistentVolumeClaimVolumeSourceBuilder() {
    this(new PersistentVolumeClaimVolumeSource());
  }
  
  public PersistentVolumeClaimVolumeSourceBuilder(PersistentVolumeClaimVolumeSourceFluent<?> fluent) {
    this(fluent, new PersistentVolumeClaimVolumeSource());
  }
  
  public PersistentVolumeClaimVolumeSourceBuilder(PersistentVolumeClaimVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeClaimVolumeSourceBuilder(PersistentVolumeClaimVolumeSourceFluent<?> fluent,PersistentVolumeClaimVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeClaimVolumeSource build() {
    PersistentVolumeClaimVolumeSource buildable = new PersistentVolumeClaimVolumeSource(fluent.getClaimName(), fluent.getReadOnly());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}