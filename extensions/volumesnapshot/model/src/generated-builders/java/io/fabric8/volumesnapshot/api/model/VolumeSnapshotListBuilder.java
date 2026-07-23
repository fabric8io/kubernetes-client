package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotListBuilder extends VolumeSnapshotListFluent<VolumeSnapshotListBuilder> implements VisitableBuilder<VolumeSnapshotList,VolumeSnapshotListBuilder>{

  VolumeSnapshotListFluent<?> fluent;

  public VolumeSnapshotListBuilder() {
    this(new VolumeSnapshotList());
  }
  
  public VolumeSnapshotListBuilder(VolumeSnapshotListFluent<?> fluent) {
    this(fluent, new VolumeSnapshotList());
  }
  
  public VolumeSnapshotListBuilder(VolumeSnapshotList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotListBuilder(VolumeSnapshotListFluent<?> fluent,VolumeSnapshotList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotList build() {
    VolumeSnapshotList buildable = new VolumeSnapshotList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}