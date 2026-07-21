package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotSpecBuilder extends VolumeSnapshotSpecFluent<VolumeSnapshotSpecBuilder> implements VisitableBuilder<VolumeSnapshotSpec,VolumeSnapshotSpecBuilder>{

  VolumeSnapshotSpecFluent<?> fluent;

  public VolumeSnapshotSpecBuilder() {
    this(new VolumeSnapshotSpec());
  }
  
  public VolumeSnapshotSpecBuilder(VolumeSnapshotSpecFluent<?> fluent) {
    this(fluent, new VolumeSnapshotSpec());
  }
  
  public VolumeSnapshotSpecBuilder(VolumeSnapshotSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotSpecBuilder(VolumeSnapshotSpecFluent<?> fluent,VolumeSnapshotSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotSpec build() {
    VolumeSnapshotSpec buildable = new VolumeSnapshotSpec(fluent.buildSource(), fluent.getVolumeSnapshotClassName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}