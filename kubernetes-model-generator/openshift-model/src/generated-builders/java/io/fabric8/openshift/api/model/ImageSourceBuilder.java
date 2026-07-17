package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageSourceBuilder extends ImageSourceFluent<ImageSourceBuilder> implements VisitableBuilder<ImageSource,ImageSourceBuilder>{

  ImageSourceFluent<?> fluent;

  public ImageSourceBuilder() {
    this(new ImageSource());
  }
  
  public ImageSourceBuilder(ImageSourceFluent<?> fluent) {
    this(fluent, new ImageSource());
  }
  
  public ImageSourceBuilder(ImageSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageSourceBuilder(ImageSourceFluent<?> fluent,ImageSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageSource build() {
    ImageSource buildable = new ImageSource(fluent.getAs(), fluent.buildFrom(), fluent.buildPaths(), fluent.buildPullSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}