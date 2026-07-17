package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamImportSpecBuilder extends ImageStreamImportSpecFluent<ImageStreamImportSpecBuilder> implements VisitableBuilder<ImageStreamImportSpec,ImageStreamImportSpecBuilder>{

  ImageStreamImportSpecFluent<?> fluent;

  public ImageStreamImportSpecBuilder() {
    this(new ImageStreamImportSpec());
  }
  
  public ImageStreamImportSpecBuilder(ImageStreamImportSpecFluent<?> fluent) {
    this(fluent, new ImageStreamImportSpec());
  }
  
  public ImageStreamImportSpecBuilder(ImageStreamImportSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamImportSpecBuilder(ImageStreamImportSpecFluent<?> fluent,ImageStreamImportSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamImportSpec build() {
    ImageStreamImportSpec buildable = new ImageStreamImportSpec(fluent.buildImages(), fluent.getImport(), fluent.buildRepository());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}