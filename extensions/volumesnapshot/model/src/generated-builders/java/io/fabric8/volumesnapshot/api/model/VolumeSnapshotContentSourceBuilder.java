package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotContentSourceBuilder extends VolumeSnapshotContentSourceFluent<VolumeSnapshotContentSourceBuilder> implements VisitableBuilder<VolumeSnapshotContentSource,VolumeSnapshotContentSourceBuilder>{

  VolumeSnapshotContentSourceFluent<?> fluent;

  public VolumeSnapshotContentSourceBuilder() {
    this(new VolumeSnapshotContentSource());
  }
  
  public VolumeSnapshotContentSourceBuilder(VolumeSnapshotContentSourceFluent<?> fluent) {
    this(fluent, new VolumeSnapshotContentSource());
  }
  
  public VolumeSnapshotContentSourceBuilder(VolumeSnapshotContentSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotContentSourceBuilder(VolumeSnapshotContentSourceFluent<?> fluent,VolumeSnapshotContentSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotContentSource build() {
    VolumeSnapshotContentSource buildable = new VolumeSnapshotContentSource(fluent.getSnapshotHandle(), fluent.getVolumeHandle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}