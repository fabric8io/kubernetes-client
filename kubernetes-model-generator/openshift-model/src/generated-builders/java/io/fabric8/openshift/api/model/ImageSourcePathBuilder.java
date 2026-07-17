package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageSourcePathBuilder extends ImageSourcePathFluent<ImageSourcePathBuilder> implements VisitableBuilder<ImageSourcePath,ImageSourcePathBuilder>{

  ImageSourcePathFluent<?> fluent;

  public ImageSourcePathBuilder() {
    this(new ImageSourcePath());
  }
  
  public ImageSourcePathBuilder(ImageSourcePathFluent<?> fluent) {
    this(fluent, new ImageSourcePath());
  }
  
  public ImageSourcePathBuilder(ImageSourcePath instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageSourcePathBuilder(ImageSourcePathFluent<?> fluent,ImageSourcePath instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageSourcePath build() {
    ImageSourcePath buildable = new ImageSourcePath(fluent.getDestinationDir(), fluent.getSourcePath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}