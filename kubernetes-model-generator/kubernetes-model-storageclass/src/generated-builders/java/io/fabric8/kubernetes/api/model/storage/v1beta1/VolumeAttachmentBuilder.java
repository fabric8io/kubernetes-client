package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeAttachmentBuilder extends VolumeAttachmentFluent<VolumeAttachmentBuilder> implements VisitableBuilder<VolumeAttachment,VolumeAttachmentBuilder>{

  VolumeAttachmentFluent<?> fluent;

  public VolumeAttachmentBuilder() {
    this(new VolumeAttachment());
  }
  
  public VolumeAttachmentBuilder(VolumeAttachmentFluent<?> fluent) {
    this(fluent, new VolumeAttachment());
  }
  
  public VolumeAttachmentBuilder(VolumeAttachment instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeAttachmentBuilder(VolumeAttachmentFluent<?> fluent,VolumeAttachment instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeAttachment build() {
    VolumeAttachment buildable = new VolumeAttachment(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}