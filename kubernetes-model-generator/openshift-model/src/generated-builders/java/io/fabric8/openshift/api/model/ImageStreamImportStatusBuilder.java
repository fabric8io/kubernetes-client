package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamImportStatusBuilder extends ImageStreamImportStatusFluent<ImageStreamImportStatusBuilder> implements VisitableBuilder<ImageStreamImportStatus,ImageStreamImportStatusBuilder>{

  ImageStreamImportStatusFluent<?> fluent;

  public ImageStreamImportStatusBuilder() {
    this(new ImageStreamImportStatus());
  }
  
  public ImageStreamImportStatusBuilder(ImageStreamImportStatusFluent<?> fluent) {
    this(fluent, new ImageStreamImportStatus());
  }
  
  public ImageStreamImportStatusBuilder(ImageStreamImportStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamImportStatusBuilder(ImageStreamImportStatusFluent<?> fluent,ImageStreamImportStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamImportStatus build() {
    ImageStreamImportStatus buildable = new ImageStreamImportStatus(fluent.buildImages(), fluent.buildImport(), fluent.buildRepository());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}