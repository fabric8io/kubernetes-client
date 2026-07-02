package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageVolumeStatusBuilder extends ImageVolumeStatusFluent<ImageVolumeStatusBuilder> implements VisitableBuilder<ImageVolumeStatus,ImageVolumeStatusBuilder>{

  ImageVolumeStatusFluent<?> fluent;

  public ImageVolumeStatusBuilder() {
    this(new ImageVolumeStatus());
  }
  
  public ImageVolumeStatusBuilder(ImageVolumeStatusFluent<?> fluent) {
    this(fluent, new ImageVolumeStatus());
  }
  
  public ImageVolumeStatusBuilder(ImageVolumeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageVolumeStatusBuilder(ImageVolumeStatusFluent<?> fluent,ImageVolumeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageVolumeStatus build() {
    ImageVolumeStatus buildable = new ImageVolumeStatus(fluent.getImageRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}