package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageContentSourceBuilder extends ImageContentSourceFluent<ImageContentSourceBuilder> implements VisitableBuilder<ImageContentSource,ImageContentSourceBuilder>{

  ImageContentSourceFluent<?> fluent;

  public ImageContentSourceBuilder() {
    this(new ImageContentSource());
  }
  
  public ImageContentSourceBuilder(ImageContentSourceFluent<?> fluent) {
    this(fluent, new ImageContentSource());
  }
  
  public ImageContentSourceBuilder(ImageContentSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageContentSourceBuilder(ImageContentSourceFluent<?> fluent,ImageContentSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageContentSource build() {
    ImageContentSource buildable = new ImageContentSource(fluent.getMirrors(), fluent.getSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}