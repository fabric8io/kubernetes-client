package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AttachedImageReferenceBuilder extends AttachedImageReferenceFluent<AttachedImageReferenceBuilder> implements VisitableBuilder<AttachedImageReference,AttachedImageReferenceBuilder>{

  AttachedImageReferenceFluent<?> fluent;

  public AttachedImageReferenceBuilder() {
    this(new AttachedImageReference());
  }
  
  public AttachedImageReferenceBuilder(AttachedImageReferenceFluent<?> fluent) {
    this(fluent, new AttachedImageReference());
  }
  
  public AttachedImageReferenceBuilder(AttachedImageReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AttachedImageReferenceBuilder(AttachedImageReferenceFluent<?> fluent,AttachedImageReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AttachedImageReference build() {
    AttachedImageReference buildable = new AttachedImageReference(fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}