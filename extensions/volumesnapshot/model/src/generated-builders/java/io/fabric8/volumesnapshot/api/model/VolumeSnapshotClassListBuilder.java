package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotClassListBuilder extends VolumeSnapshotClassListFluent<VolumeSnapshotClassListBuilder> implements VisitableBuilder<VolumeSnapshotClassList,VolumeSnapshotClassListBuilder>{

  VolumeSnapshotClassListFluent<?> fluent;

  public VolumeSnapshotClassListBuilder() {
    this(new VolumeSnapshotClassList());
  }
  
  public VolumeSnapshotClassListBuilder(VolumeSnapshotClassListFluent<?> fluent) {
    this(fluent, new VolumeSnapshotClassList());
  }
  
  public VolumeSnapshotClassListBuilder(VolumeSnapshotClassList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotClassListBuilder(VolumeSnapshotClassListFluent<?> fluent,VolumeSnapshotClassList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotClassList build() {
    VolumeSnapshotClassList buildable = new VolumeSnapshotClassList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}