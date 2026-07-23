package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AttachedVolumeBuilder extends AttachedVolumeFluent<AttachedVolumeBuilder> implements VisitableBuilder<AttachedVolume,AttachedVolumeBuilder>{

  AttachedVolumeFluent<?> fluent;

  public AttachedVolumeBuilder() {
    this(new AttachedVolume());
  }
  
  public AttachedVolumeBuilder(AttachedVolumeFluent<?> fluent) {
    this(fluent, new AttachedVolume());
  }
  
  public AttachedVolumeBuilder(AttachedVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AttachedVolumeBuilder(AttachedVolumeFluent<?> fluent,AttachedVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AttachedVolume build() {
    AttachedVolume buildable = new AttachedVolume(fluent.getDevicePath(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}