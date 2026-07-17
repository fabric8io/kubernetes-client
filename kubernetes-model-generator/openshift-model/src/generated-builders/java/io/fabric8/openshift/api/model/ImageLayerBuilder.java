package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageLayerBuilder extends ImageLayerFluent<ImageLayerBuilder> implements VisitableBuilder<ImageLayer,ImageLayerBuilder>{

  ImageLayerFluent<?> fluent;

  public ImageLayerBuilder() {
    this(new ImageLayer());
  }
  
  public ImageLayerBuilder(ImageLayerFluent<?> fluent) {
    this(fluent, new ImageLayer());
  }
  
  public ImageLayerBuilder(ImageLayer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageLayerBuilder(ImageLayerFluent<?> fluent,ImageLayer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageLayer build() {
    ImageLayer buildable = new ImageLayer(fluent.getMediaType(), fluent.getName(), fluent.getSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}