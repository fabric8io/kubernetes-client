package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageLayerDataBuilder extends ImageLayerDataFluent<ImageLayerDataBuilder> implements VisitableBuilder<ImageLayerData,ImageLayerDataBuilder>{

  ImageLayerDataFluent<?> fluent;

  public ImageLayerDataBuilder() {
    this(new ImageLayerData());
  }
  
  public ImageLayerDataBuilder(ImageLayerDataFluent<?> fluent) {
    this(fluent, new ImageLayerData());
  }
  
  public ImageLayerDataBuilder(ImageLayerData instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageLayerDataBuilder(ImageLayerDataFluent<?> fluent,ImageLayerData instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageLayerData build() {
    ImageLayerData buildable = new ImageLayerData(fluent.getMediaType(), fluent.getSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}