package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageSecretObjectReferenceBuilder extends ImageSecretObjectReferenceFluent<ImageSecretObjectReferenceBuilder> implements VisitableBuilder<ImageSecretObjectReference,ImageSecretObjectReferenceBuilder>{

  ImageSecretObjectReferenceFluent<?> fluent;

  public ImageSecretObjectReferenceBuilder() {
    this(new ImageSecretObjectReference());
  }
  
  public ImageSecretObjectReferenceBuilder(ImageSecretObjectReferenceFluent<?> fluent) {
    this(fluent, new ImageSecretObjectReference());
  }
  
  public ImageSecretObjectReferenceBuilder(ImageSecretObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageSecretObjectReferenceBuilder(ImageSecretObjectReferenceFluent<?> fluent,ImageSecretObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageSecretObjectReference build() {
    ImageSecretObjectReference buildable = new ImageSecretObjectReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}