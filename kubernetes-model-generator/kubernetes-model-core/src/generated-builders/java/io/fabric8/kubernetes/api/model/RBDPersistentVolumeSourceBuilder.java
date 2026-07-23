package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RBDPersistentVolumeSourceBuilder extends RBDPersistentVolumeSourceFluent<RBDPersistentVolumeSourceBuilder> implements VisitableBuilder<RBDPersistentVolumeSource,RBDPersistentVolumeSourceBuilder>{

  RBDPersistentVolumeSourceFluent<?> fluent;

  public RBDPersistentVolumeSourceBuilder() {
    this(new RBDPersistentVolumeSource());
  }
  
  public RBDPersistentVolumeSourceBuilder(RBDPersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new RBDPersistentVolumeSource());
  }
  
  public RBDPersistentVolumeSourceBuilder(RBDPersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RBDPersistentVolumeSourceBuilder(RBDPersistentVolumeSourceFluent<?> fluent,RBDPersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RBDPersistentVolumeSource build() {
    RBDPersistentVolumeSource buildable = new RBDPersistentVolumeSource(fluent.getFsType(), fluent.getImage(), fluent.getKeyring(), fluent.getMonitors(), fluent.getPool(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}