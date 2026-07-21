package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotStatusBuilder extends VolumeSnapshotStatusFluent<VolumeSnapshotStatusBuilder> implements VisitableBuilder<VolumeSnapshotStatus,VolumeSnapshotStatusBuilder>{

  VolumeSnapshotStatusFluent<?> fluent;

  public VolumeSnapshotStatusBuilder() {
    this(new VolumeSnapshotStatus());
  }
  
  public VolumeSnapshotStatusBuilder(VolumeSnapshotStatusFluent<?> fluent) {
    this(fluent, new VolumeSnapshotStatus());
  }
  
  public VolumeSnapshotStatusBuilder(VolumeSnapshotStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotStatusBuilder(VolumeSnapshotStatusFluent<?> fluent,VolumeSnapshotStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotStatus build() {
    VolumeSnapshotStatus buildable = new VolumeSnapshotStatus(fluent.getBoundVolumeSnapshotContentName(), fluent.getCreationTime(), fluent.buildError(), fluent.getReadyToUse(), fluent.getRestoreSize(), fluent.getVolumeGroupSnapshotName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}