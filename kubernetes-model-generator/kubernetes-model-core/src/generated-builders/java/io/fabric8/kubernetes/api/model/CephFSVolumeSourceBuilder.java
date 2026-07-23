package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CephFSVolumeSourceBuilder extends CephFSVolumeSourceFluent<CephFSVolumeSourceBuilder> implements VisitableBuilder<CephFSVolumeSource,CephFSVolumeSourceBuilder>{

  CephFSVolumeSourceFluent<?> fluent;

  public CephFSVolumeSourceBuilder() {
    this(new CephFSVolumeSource());
  }
  
  public CephFSVolumeSourceBuilder(CephFSVolumeSourceFluent<?> fluent) {
    this(fluent, new CephFSVolumeSource());
  }
  
  public CephFSVolumeSourceBuilder(CephFSVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CephFSVolumeSourceBuilder(CephFSVolumeSourceFluent<?> fluent,CephFSVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CephFSVolumeSource build() {
    CephFSVolumeSource buildable = new CephFSVolumeSource(fluent.getMonitors(), fluent.getPath(), fluent.getReadOnly(), fluent.getSecretFile(), fluent.buildSecretRef(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}