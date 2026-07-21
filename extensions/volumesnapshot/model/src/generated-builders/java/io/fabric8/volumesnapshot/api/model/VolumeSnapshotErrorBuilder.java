package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotErrorBuilder extends VolumeSnapshotErrorFluent<VolumeSnapshotErrorBuilder> implements VisitableBuilder<VolumeSnapshotError,VolumeSnapshotErrorBuilder>{

  VolumeSnapshotErrorFluent<?> fluent;

  public VolumeSnapshotErrorBuilder() {
    this(new VolumeSnapshotError());
  }
  
  public VolumeSnapshotErrorBuilder(VolumeSnapshotErrorFluent<?> fluent) {
    this(fluent, new VolumeSnapshotError());
  }
  
  public VolumeSnapshotErrorBuilder(VolumeSnapshotError instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotErrorBuilder(VolumeSnapshotErrorFluent<?> fluent,VolumeSnapshotError instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotError build() {
    VolumeSnapshotError buildable = new VolumeSnapshotError(fluent.getMessage(), fluent.getTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}