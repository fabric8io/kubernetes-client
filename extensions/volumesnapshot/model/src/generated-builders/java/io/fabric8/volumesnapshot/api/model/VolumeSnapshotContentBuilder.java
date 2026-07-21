package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotContentBuilder extends VolumeSnapshotContentFluent<VolumeSnapshotContentBuilder> implements VisitableBuilder<VolumeSnapshotContent,VolumeSnapshotContentBuilder>{

  VolumeSnapshotContentFluent<?> fluent;

  public VolumeSnapshotContentBuilder() {
    this(new VolumeSnapshotContent());
  }
  
  public VolumeSnapshotContentBuilder(VolumeSnapshotContentFluent<?> fluent) {
    this(fluent, new VolumeSnapshotContent());
  }
  
  public VolumeSnapshotContentBuilder(VolumeSnapshotContent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotContentBuilder(VolumeSnapshotContentFluent<?> fluent,VolumeSnapshotContent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotContent build() {
    VolumeSnapshotContent buildable = new VolumeSnapshotContent(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}