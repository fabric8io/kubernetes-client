package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotSourceBuilder extends VolumeSnapshotSourceFluent<VolumeSnapshotSourceBuilder> implements VisitableBuilder<VolumeSnapshotSource,VolumeSnapshotSourceBuilder>{

  VolumeSnapshotSourceFluent<?> fluent;

  public VolumeSnapshotSourceBuilder() {
    this(new VolumeSnapshotSource());
  }
  
  public VolumeSnapshotSourceBuilder(VolumeSnapshotSourceFluent<?> fluent) {
    this(fluent, new VolumeSnapshotSource());
  }
  
  public VolumeSnapshotSourceBuilder(VolumeSnapshotSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotSourceBuilder(VolumeSnapshotSourceFluent<?> fluent,VolumeSnapshotSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotSource build() {
    VolumeSnapshotSource buildable = new VolumeSnapshotSource(fluent.getPersistentVolumeClaimName(), fluent.getVolumeSnapshotContentName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}