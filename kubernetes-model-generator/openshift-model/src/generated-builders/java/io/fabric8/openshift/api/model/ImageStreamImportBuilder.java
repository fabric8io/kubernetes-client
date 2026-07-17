package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamImportBuilder extends ImageStreamImportFluent<ImageStreamImportBuilder> implements VisitableBuilder<ImageStreamImport,ImageStreamImportBuilder>{

  ImageStreamImportFluent<?> fluent;

  public ImageStreamImportBuilder() {
    this(new ImageStreamImport());
  }
  
  public ImageStreamImportBuilder(ImageStreamImportFluent<?> fluent) {
    this(fluent, new ImageStreamImport());
  }
  
  public ImageStreamImportBuilder(ImageStreamImport instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamImportBuilder(ImageStreamImportFluent<?> fluent,ImageStreamImport instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamImport build() {
    ImageStreamImport buildable = new ImageStreamImport(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}