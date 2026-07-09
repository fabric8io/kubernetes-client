package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeAttachmentListBuilder extends VolumeAttachmentListFluent<VolumeAttachmentListBuilder> implements VisitableBuilder<VolumeAttachmentList,VolumeAttachmentListBuilder>{

  VolumeAttachmentListFluent<?> fluent;

  public VolumeAttachmentListBuilder() {
    this(new VolumeAttachmentList());
  }
  
  public VolumeAttachmentListBuilder(VolumeAttachmentListFluent<?> fluent) {
    this(fluent, new VolumeAttachmentList());
  }
  
  public VolumeAttachmentListBuilder(VolumeAttachmentList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeAttachmentListBuilder(VolumeAttachmentListFluent<?> fluent,VolumeAttachmentList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeAttachmentList build() {
    VolumeAttachmentList buildable = new VolumeAttachmentList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}