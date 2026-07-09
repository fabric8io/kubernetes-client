package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeAttachmentStatusBuilder extends VolumeAttachmentStatusFluent<VolumeAttachmentStatusBuilder> implements VisitableBuilder<VolumeAttachmentStatus,VolumeAttachmentStatusBuilder>{

  VolumeAttachmentStatusFluent<?> fluent;

  public VolumeAttachmentStatusBuilder() {
    this(new VolumeAttachmentStatus());
  }
  
  public VolumeAttachmentStatusBuilder(VolumeAttachmentStatusFluent<?> fluent) {
    this(fluent, new VolumeAttachmentStatus());
  }
  
  public VolumeAttachmentStatusBuilder(VolumeAttachmentStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeAttachmentStatusBuilder(VolumeAttachmentStatusFluent<?> fluent,VolumeAttachmentStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeAttachmentStatus build() {
    VolumeAttachmentStatus buildable = new VolumeAttachmentStatus(fluent.buildAttachError(), fluent.getAttached(), fluent.getAttachmentMetadata(), fluent.buildDetachError());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}