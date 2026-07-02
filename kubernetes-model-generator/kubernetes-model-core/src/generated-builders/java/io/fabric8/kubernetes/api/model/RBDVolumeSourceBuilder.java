package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RBDVolumeSourceBuilder extends RBDVolumeSourceFluent<RBDVolumeSourceBuilder> implements VisitableBuilder<RBDVolumeSource,RBDVolumeSourceBuilder>{

  RBDVolumeSourceFluent<?> fluent;

  public RBDVolumeSourceBuilder() {
    this(new RBDVolumeSource());
  }
  
  public RBDVolumeSourceBuilder(RBDVolumeSourceFluent<?> fluent) {
    this(fluent, new RBDVolumeSource());
  }
  
  public RBDVolumeSourceBuilder(RBDVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RBDVolumeSourceBuilder(RBDVolumeSourceFluent<?> fluent,RBDVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RBDVolumeSource build() {
    RBDVolumeSource buildable = new RBDVolumeSource(fluent.getFsType(), fluent.getImage(), fluent.getKeyring(), fluent.getMonitors(), fluent.getPool(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}