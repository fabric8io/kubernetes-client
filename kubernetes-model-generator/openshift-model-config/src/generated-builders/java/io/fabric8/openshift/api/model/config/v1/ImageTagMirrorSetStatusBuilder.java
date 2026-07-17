package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageTagMirrorSetStatusBuilder extends ImageTagMirrorSetStatusFluent<ImageTagMirrorSetStatusBuilder> implements VisitableBuilder<ImageTagMirrorSetStatus,ImageTagMirrorSetStatusBuilder>{

  ImageTagMirrorSetStatusFluent<?> fluent;

  public ImageTagMirrorSetStatusBuilder() {
    this(new ImageTagMirrorSetStatus());
  }
  
  public ImageTagMirrorSetStatusBuilder(ImageTagMirrorSetStatusFluent<?> fluent) {
    this(fluent, new ImageTagMirrorSetStatus());
  }
  
  public ImageTagMirrorSetStatusBuilder(ImageTagMirrorSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageTagMirrorSetStatusBuilder(ImageTagMirrorSetStatusFluent<?> fluent,ImageTagMirrorSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageTagMirrorSetStatus build() {
    ImageTagMirrorSetStatus buildable = new ImageTagMirrorSetStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}