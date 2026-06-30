package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CinderPersistentVolumeSourceBuilder extends CinderPersistentVolumeSourceFluent<CinderPersistentVolumeSourceBuilder> implements VisitableBuilder<CinderPersistentVolumeSource,CinderPersistentVolumeSourceBuilder>{

  CinderPersistentVolumeSourceFluent<?> fluent;

  public CinderPersistentVolumeSourceBuilder() {
    this(new CinderPersistentVolumeSource());
  }
  
  public CinderPersistentVolumeSourceBuilder(CinderPersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new CinderPersistentVolumeSource());
  }
  
  public CinderPersistentVolumeSourceBuilder(CinderPersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CinderPersistentVolumeSourceBuilder(CinderPersistentVolumeSourceFluent<?> fluent,CinderPersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CinderPersistentVolumeSource build() {
    CinderPersistentVolumeSource buildable = new CinderPersistentVolumeSource(fluent.getFsType(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getVolumeID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}