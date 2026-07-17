package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamTagBuilder extends ImageStreamTagFluent<ImageStreamTagBuilder> implements VisitableBuilder<ImageStreamTag,ImageStreamTagBuilder>{

  ImageStreamTagFluent<?> fluent;

  public ImageStreamTagBuilder() {
    this(new ImageStreamTag());
  }
  
  public ImageStreamTagBuilder(ImageStreamTagFluent<?> fluent) {
    this(fluent, new ImageStreamTag());
  }
  
  public ImageStreamTagBuilder(ImageStreamTag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamTagBuilder(ImageStreamTagFluent<?> fluent,ImageStreamTag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamTag build() {
    ImageStreamTag buildable = new ImageStreamTag(fluent.getApiVersion(), fluent.buildConditions(), fluent.getGeneration(), fluent.buildImage(), fluent.getKind(), fluent.buildLookupPolicy(), fluent.buildMetadata(), fluent.buildTag());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}