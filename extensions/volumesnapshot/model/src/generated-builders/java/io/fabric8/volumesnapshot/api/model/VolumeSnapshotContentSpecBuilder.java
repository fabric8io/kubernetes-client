package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotContentSpecBuilder extends VolumeSnapshotContentSpecFluent<VolumeSnapshotContentSpecBuilder> implements VisitableBuilder<VolumeSnapshotContentSpec,VolumeSnapshotContentSpecBuilder>{

  VolumeSnapshotContentSpecFluent<?> fluent;

  public VolumeSnapshotContentSpecBuilder() {
    this(new VolumeSnapshotContentSpec());
  }
  
  public VolumeSnapshotContentSpecBuilder(VolumeSnapshotContentSpecFluent<?> fluent) {
    this(fluent, new VolumeSnapshotContentSpec());
  }
  
  public VolumeSnapshotContentSpecBuilder(VolumeSnapshotContentSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotContentSpecBuilder(VolumeSnapshotContentSpecFluent<?> fluent,VolumeSnapshotContentSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotContentSpec build() {
    VolumeSnapshotContentSpec buildable = new VolumeSnapshotContentSpec(fluent.getDeletionPolicy(), fluent.getDriver(), fluent.buildSource(), fluent.getSourceVolumeMode(), fluent.getVolumeSnapshotClassName(), fluent.buildVolumeSnapshotRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}