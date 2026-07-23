package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AttachMetadataBuilder extends AttachMetadataFluent<AttachMetadataBuilder> implements VisitableBuilder<AttachMetadata,AttachMetadataBuilder>{

  AttachMetadataFluent<?> fluent;

  public AttachMetadataBuilder() {
    this(new AttachMetadata());
  }
  
  public AttachMetadataBuilder(AttachMetadataFluent<?> fluent) {
    this(fluent, new AttachMetadata());
  }
  
  public AttachMetadataBuilder(AttachMetadata instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AttachMetadataBuilder(AttachMetadataFluent<?> fluent,AttachMetadata instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AttachMetadata build() {
    AttachMetadata buildable = new AttachMetadata(fluent.getNode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}