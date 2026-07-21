package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSnapshotClassBuilder extends VolumeSnapshotClassFluent<VolumeSnapshotClassBuilder> implements VisitableBuilder<VolumeSnapshotClass,VolumeSnapshotClassBuilder>{

  VolumeSnapshotClassFluent<?> fluent;

  public VolumeSnapshotClassBuilder() {
    this(new VolumeSnapshotClass());
  }
  
  public VolumeSnapshotClassBuilder(VolumeSnapshotClassFluent<?> fluent) {
    this(fluent, new VolumeSnapshotClass());
  }
  
  public VolumeSnapshotClassBuilder(VolumeSnapshotClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSnapshotClassBuilder(VolumeSnapshotClassFluent<?> fluent,VolumeSnapshotClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSnapshotClass build() {
    VolumeSnapshotClass buildable = new VolumeSnapshotClass(fluent.getApiVersion(), fluent.getDeletionPolicy(), fluent.getDriver(), fluent.getKind(), fluent.buildMetadata(), fluent.getParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}