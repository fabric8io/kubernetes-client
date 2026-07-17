package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageDigestMirrorSetStatusBuilder extends ImageDigestMirrorSetStatusFluent<ImageDigestMirrorSetStatusBuilder> implements VisitableBuilder<ImageDigestMirrorSetStatus,ImageDigestMirrorSetStatusBuilder>{

  ImageDigestMirrorSetStatusFluent<?> fluent;

  public ImageDigestMirrorSetStatusBuilder() {
    this(new ImageDigestMirrorSetStatus());
  }
  
  public ImageDigestMirrorSetStatusBuilder(ImageDigestMirrorSetStatusFluent<?> fluent) {
    this(fluent, new ImageDigestMirrorSetStatus());
  }
  
  public ImageDigestMirrorSetStatusBuilder(ImageDigestMirrorSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageDigestMirrorSetStatusBuilder(ImageDigestMirrorSetStatusFluent<?> fluent,ImageDigestMirrorSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageDigestMirrorSetStatus build() {
    ImageDigestMirrorSetStatus buildable = new ImageDigestMirrorSetStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}