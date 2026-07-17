package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamTagReferenceBuilder extends ImageStreamTagReferenceFluent<ImageStreamTagReferenceBuilder> implements VisitableBuilder<ImageStreamTagReference,ImageStreamTagReferenceBuilder>{

  ImageStreamTagReferenceFluent<?> fluent;

  public ImageStreamTagReferenceBuilder() {
    this(new ImageStreamTagReference());
  }
  
  public ImageStreamTagReferenceBuilder(ImageStreamTagReferenceFluent<?> fluent) {
    this(fluent, new ImageStreamTagReference());
  }
  
  public ImageStreamTagReferenceBuilder(ImageStreamTagReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamTagReferenceBuilder(ImageStreamTagReferenceFluent<?> fluent,ImageStreamTagReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamTagReference build() {
    ImageStreamTagReference buildable = new ImageStreamTagReference(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}