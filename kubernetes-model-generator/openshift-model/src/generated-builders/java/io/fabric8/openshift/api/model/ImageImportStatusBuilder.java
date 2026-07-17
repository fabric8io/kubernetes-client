package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageImportStatusBuilder extends ImageImportStatusFluent<ImageImportStatusBuilder> implements VisitableBuilder<ImageImportStatus,ImageImportStatusBuilder>{

  ImageImportStatusFluent<?> fluent;

  public ImageImportStatusBuilder() {
    this(new ImageImportStatus());
  }
  
  public ImageImportStatusBuilder(ImageImportStatusFluent<?> fluent) {
    this(fluent, new ImageImportStatus());
  }
  
  public ImageImportStatusBuilder(ImageImportStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageImportStatusBuilder(ImageImportStatusFluent<?> fluent,ImageImportStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageImportStatus build() {
    ImageImportStatus buildable = new ImageImportStatus(fluent.buildImage(), fluent.buildManifests(), fluent.getStatus(), fluent.getTag());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}