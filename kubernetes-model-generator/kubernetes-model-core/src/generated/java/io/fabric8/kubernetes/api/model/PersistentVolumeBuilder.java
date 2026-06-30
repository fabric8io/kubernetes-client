package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeBuilder extends PersistentVolumeFluent<PersistentVolumeBuilder> implements VisitableBuilder<PersistentVolume,PersistentVolumeBuilder>{

  PersistentVolumeFluent<?> fluent;

  public PersistentVolumeBuilder() {
    this(new PersistentVolume());
  }
  
  public PersistentVolumeBuilder(PersistentVolumeFluent<?> fluent) {
    this(fluent, new PersistentVolume());
  }
  
  public PersistentVolumeBuilder(PersistentVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeBuilder(PersistentVolumeFluent<?> fluent,PersistentVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolume build() {
    PersistentVolume buildable = new PersistentVolume(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}