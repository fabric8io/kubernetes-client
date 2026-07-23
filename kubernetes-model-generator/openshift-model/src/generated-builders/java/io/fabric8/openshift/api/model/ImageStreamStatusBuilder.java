package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamStatusBuilder extends ImageStreamStatusFluent<ImageStreamStatusBuilder> implements VisitableBuilder<ImageStreamStatus,ImageStreamStatusBuilder>{

  ImageStreamStatusFluent<?> fluent;

  public ImageStreamStatusBuilder() {
    this(new ImageStreamStatus());
  }
  
  public ImageStreamStatusBuilder(ImageStreamStatusFluent<?> fluent) {
    this(fluent, new ImageStreamStatus());
  }
  
  public ImageStreamStatusBuilder(ImageStreamStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamStatusBuilder(ImageStreamStatusFluent<?> fluent,ImageStreamStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamStatus build() {
    ImageStreamStatus buildable = new ImageStreamStatus(fluent.getDockerImageRepository(), fluent.getPublicDockerImageRepository(), fluent.buildTags());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}