package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScaleIOPersistentVolumeSourceBuilder extends ScaleIOPersistentVolumeSourceFluent<ScaleIOPersistentVolumeSourceBuilder> implements VisitableBuilder<ScaleIOPersistentVolumeSource,ScaleIOPersistentVolumeSourceBuilder>{

  ScaleIOPersistentVolumeSourceFluent<?> fluent;

  public ScaleIOPersistentVolumeSourceBuilder() {
    this(new ScaleIOPersistentVolumeSource());
  }
  
  public ScaleIOPersistentVolumeSourceBuilder(ScaleIOPersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new ScaleIOPersistentVolumeSource());
  }
  
  public ScaleIOPersistentVolumeSourceBuilder(ScaleIOPersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScaleIOPersistentVolumeSourceBuilder(ScaleIOPersistentVolumeSourceFluent<?> fluent,ScaleIOPersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScaleIOPersistentVolumeSource build() {
    ScaleIOPersistentVolumeSource buildable = new ScaleIOPersistentVolumeSource(fluent.getFsType(), fluent.getGateway(), fluent.getProtectionDomain(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getSslEnabled(), fluent.getStorageMode(), fluent.getStoragePool(), fluent.getSystem(), fluent.getVolumeName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}