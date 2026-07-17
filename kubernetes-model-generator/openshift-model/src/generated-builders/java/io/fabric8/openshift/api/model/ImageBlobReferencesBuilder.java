package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageBlobReferencesBuilder extends ImageBlobReferencesFluent<ImageBlobReferencesBuilder> implements VisitableBuilder<ImageBlobReferences,ImageBlobReferencesBuilder>{

  ImageBlobReferencesFluent<?> fluent;

  public ImageBlobReferencesBuilder() {
    this(new ImageBlobReferences());
  }
  
  public ImageBlobReferencesBuilder(ImageBlobReferencesFluent<?> fluent) {
    this(fluent, new ImageBlobReferences());
  }
  
  public ImageBlobReferencesBuilder(ImageBlobReferences instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageBlobReferencesBuilder(ImageBlobReferencesFluent<?> fluent,ImageBlobReferences instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageBlobReferences build() {
    ImageBlobReferences buildable = new ImageBlobReferences(fluent.getConfig(), fluent.getImageMissing(), fluent.getLayers(), fluent.getManifests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}