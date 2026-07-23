package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotBuilder extends VolumeSnapshotFluent<VolumeSnapshotBuilder> implements VisitableBuilder<VolumeSnapshot,VolumeSnapshotBuilder>{

  VolumeSnapshotFluent<?> fluent;

  public VolumeSnapshotBuilder() {
    this(new VolumeSnapshot());
  }
  
  public VolumeSnapshotBuilder(VolumeSnapshotFluent<?> fluent) {
    this(fluent, new VolumeSnapshot());
  }
  
  public VolumeSnapshotBuilder(VolumeSnapshot instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotBuilder(VolumeSnapshotFluent<?> fluent,VolumeSnapshot instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshot build() {
    VolumeSnapshot buildable = new VolumeSnapshot(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}