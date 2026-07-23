package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeAttachmentSpecBuilder extends VolumeAttachmentSpecFluent<VolumeAttachmentSpecBuilder> implements VisitableBuilder<VolumeAttachmentSpec,VolumeAttachmentSpecBuilder>{

  VolumeAttachmentSpecFluent<?> fluent;

  public VolumeAttachmentSpecBuilder() {
    this(new VolumeAttachmentSpec());
  }
  
  public VolumeAttachmentSpecBuilder(VolumeAttachmentSpecFluent<?> fluent) {
    this(fluent, new VolumeAttachmentSpec());
  }
  
  public VolumeAttachmentSpecBuilder(VolumeAttachmentSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeAttachmentSpecBuilder(VolumeAttachmentSpecFluent<?> fluent,VolumeAttachmentSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeAttachmentSpec build() {
    VolumeAttachmentSpec buildable = new VolumeAttachmentSpec(fluent.getAttacher(), fluent.getNodeName(), fluent.buildSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}