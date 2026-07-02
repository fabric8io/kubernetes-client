package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CephFSPersistentVolumeSourceBuilder extends CephFSPersistentVolumeSourceFluent<CephFSPersistentVolumeSourceBuilder> implements VisitableBuilder<CephFSPersistentVolumeSource,CephFSPersistentVolumeSourceBuilder>{

  CephFSPersistentVolumeSourceFluent<?> fluent;

  public CephFSPersistentVolumeSourceBuilder() {
    this(new CephFSPersistentVolumeSource());
  }
  
  public CephFSPersistentVolumeSourceBuilder(CephFSPersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new CephFSPersistentVolumeSource());
  }
  
  public CephFSPersistentVolumeSourceBuilder(CephFSPersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CephFSPersistentVolumeSourceBuilder(CephFSPersistentVolumeSourceFluent<?> fluent,CephFSPersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CephFSPersistentVolumeSource build() {
    CephFSPersistentVolumeSource buildable = new CephFSPersistentVolumeSource(fluent.getMonitors(), fluent.getPath(), fluent.getReadOnly(), fluent.getSecretFile(), fluent.buildSecretRef(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}