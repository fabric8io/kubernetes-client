package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotContentStatusBuilder extends VolumeSnapshotContentStatusFluent<VolumeSnapshotContentStatusBuilder> implements VisitableBuilder<VolumeSnapshotContentStatus,VolumeSnapshotContentStatusBuilder>{

  VolumeSnapshotContentStatusFluent<?> fluent;

  public VolumeSnapshotContentStatusBuilder() {
    this(new VolumeSnapshotContentStatus());
  }
  
  public VolumeSnapshotContentStatusBuilder(VolumeSnapshotContentStatusFluent<?> fluent) {
    this(fluent, new VolumeSnapshotContentStatus());
  }
  
  public VolumeSnapshotContentStatusBuilder(VolumeSnapshotContentStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotContentStatusBuilder(VolumeSnapshotContentStatusFluent<?> fluent,VolumeSnapshotContentStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotContentStatus build() {
    VolumeSnapshotContentStatus buildable = new VolumeSnapshotContentStatus(fluent.getCreationTime(), fluent.buildError(), fluent.getReadyToUse(), fluent.getRestoreSize(), fluent.getSnapshotHandle(), fluent.getVolumeGroupSnapshotHandle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}