package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageChangeCauseBuilder extends ImageChangeCauseFluent<ImageChangeCauseBuilder> implements VisitableBuilder<ImageChangeCause,ImageChangeCauseBuilder>{

  ImageChangeCauseFluent<?> fluent;

  public ImageChangeCauseBuilder() {
    this(new ImageChangeCause());
  }
  
  public ImageChangeCauseBuilder(ImageChangeCauseFluent<?> fluent) {
    this(fluent, new ImageChangeCause());
  }
  
  public ImageChangeCauseBuilder(ImageChangeCause instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageChangeCauseBuilder(ImageChangeCauseFluent<?> fluent,ImageChangeCause instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageChangeCause build() {
    ImageChangeCause buildable = new ImageChangeCause(fluent.buildFromRef(), fluent.getImageID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}