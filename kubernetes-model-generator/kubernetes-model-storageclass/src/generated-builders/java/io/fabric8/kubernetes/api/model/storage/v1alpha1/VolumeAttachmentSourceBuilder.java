package io.fabric8.kubernetes.api.model.storage.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeAttachmentSourceBuilder extends VolumeAttachmentSourceFluent<VolumeAttachmentSourceBuilder> implements VisitableBuilder<VolumeAttachmentSource,VolumeAttachmentSourceBuilder>{

  VolumeAttachmentSourceFluent<?> fluent;

  public VolumeAttachmentSourceBuilder() {
    this(new VolumeAttachmentSource());
  }
  
  public VolumeAttachmentSourceBuilder(VolumeAttachmentSourceFluent<?> fluent) {
    this(fluent, new VolumeAttachmentSource());
  }
  
  public VolumeAttachmentSourceBuilder(VolumeAttachmentSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeAttachmentSourceBuilder(VolumeAttachmentSourceFluent<?> fluent,VolumeAttachmentSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeAttachmentSource build() {
    VolumeAttachmentSource buildable = new VolumeAttachmentSource(fluent.getInlineVolumeSpec(), fluent.getPersistentVolumeName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}