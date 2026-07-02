package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageVolumeSourceBuilder extends ImageVolumeSourceFluent<ImageVolumeSourceBuilder> implements VisitableBuilder<ImageVolumeSource,ImageVolumeSourceBuilder>{

  ImageVolumeSourceFluent<?> fluent;

  public ImageVolumeSourceBuilder() {
    this(new ImageVolumeSource());
  }
  
  public ImageVolumeSourceBuilder(ImageVolumeSourceFluent<?> fluent) {
    this(fluent, new ImageVolumeSource());
  }
  
  public ImageVolumeSourceBuilder(ImageVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageVolumeSourceBuilder(ImageVolumeSourceFluent<?> fluent,ImageVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageVolumeSource build() {
    ImageVolumeSource buildable = new ImageVolumeSource(fluent.getPullPolicy(), fluent.getReference());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}