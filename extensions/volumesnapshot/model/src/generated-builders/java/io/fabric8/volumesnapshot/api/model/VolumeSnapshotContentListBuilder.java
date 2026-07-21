package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotContentListBuilder extends VolumeSnapshotContentListFluent<VolumeSnapshotContentListBuilder> implements VisitableBuilder<VolumeSnapshotContentList,VolumeSnapshotContentListBuilder>{

  VolumeSnapshotContentListFluent<?> fluent;

  public VolumeSnapshotContentListBuilder() {
    this(new VolumeSnapshotContentList());
  }
  
  public VolumeSnapshotContentListBuilder(VolumeSnapshotContentListFluent<?> fluent) {
    this(fluent, new VolumeSnapshotContentList());
  }
  
  public VolumeSnapshotContentListBuilder(VolumeSnapshotContentList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotContentListBuilder(VolumeSnapshotContentListFluent<?> fluent,VolumeSnapshotContentList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotContentList build() {
    VolumeSnapshotContentList buildable = new VolumeSnapshotContentList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}