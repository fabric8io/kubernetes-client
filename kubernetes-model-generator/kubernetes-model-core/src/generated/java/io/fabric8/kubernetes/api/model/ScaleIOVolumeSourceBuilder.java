package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScaleIOVolumeSourceBuilder extends ScaleIOVolumeSourceFluent<ScaleIOVolumeSourceBuilder> implements VisitableBuilder<ScaleIOVolumeSource,ScaleIOVolumeSourceBuilder>{

  ScaleIOVolumeSourceFluent<?> fluent;

  public ScaleIOVolumeSourceBuilder() {
    this(new ScaleIOVolumeSource());
  }
  
  public ScaleIOVolumeSourceBuilder(ScaleIOVolumeSourceFluent<?> fluent) {
    this(fluent, new ScaleIOVolumeSource());
  }
  
  public ScaleIOVolumeSourceBuilder(ScaleIOVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScaleIOVolumeSourceBuilder(ScaleIOVolumeSourceFluent<?> fluent,ScaleIOVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScaleIOVolumeSource build() {
    ScaleIOVolumeSource buildable = new ScaleIOVolumeSource(fluent.getFsType(), fluent.getGateway(), fluent.getProtectionDomain(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getSslEnabled(), fluent.getStorageMode(), fluent.getStoragePool(), fluent.getSystem(), fluent.getVolumeName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}