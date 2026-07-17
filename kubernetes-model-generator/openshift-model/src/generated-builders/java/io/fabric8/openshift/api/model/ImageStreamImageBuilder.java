package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamImageBuilder extends ImageStreamImageFluent<ImageStreamImageBuilder> implements VisitableBuilder<ImageStreamImage,ImageStreamImageBuilder>{

  ImageStreamImageFluent<?> fluent;

  public ImageStreamImageBuilder() {
    this(new ImageStreamImage());
  }
  
  public ImageStreamImageBuilder(ImageStreamImageFluent<?> fluent) {
    this(fluent, new ImageStreamImage());
  }
  
  public ImageStreamImageBuilder(ImageStreamImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamImageBuilder(ImageStreamImageFluent<?> fluent,ImageStreamImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamImage build() {
    ImageStreamImage buildable = new ImageStreamImage(fluent.getApiVersion(), fluent.buildImage(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}