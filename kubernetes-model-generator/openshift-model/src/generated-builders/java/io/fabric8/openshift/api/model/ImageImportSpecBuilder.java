package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageImportSpecBuilder extends ImageImportSpecFluent<ImageImportSpecBuilder> implements VisitableBuilder<ImageImportSpec,ImageImportSpecBuilder>{

  ImageImportSpecFluent<?> fluent;

  public ImageImportSpecBuilder() {
    this(new ImageImportSpec());
  }
  
  public ImageImportSpecBuilder(ImageImportSpecFluent<?> fluent) {
    this(fluent, new ImageImportSpec());
  }
  
  public ImageImportSpecBuilder(ImageImportSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageImportSpecBuilder(ImageImportSpecFluent<?> fluent,ImageImportSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageImportSpec build() {
    ImageImportSpec buildable = new ImageImportSpec(fluent.buildFrom(), fluent.buildImportPolicy(), fluent.getIncludeManifest(), fluent.buildReferencePolicy(), fluent.buildTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}