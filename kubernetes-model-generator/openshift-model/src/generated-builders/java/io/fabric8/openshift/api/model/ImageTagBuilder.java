package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageTagBuilder extends ImageTagFluent<ImageTagBuilder> implements VisitableBuilder<ImageTag,ImageTagBuilder>{

  ImageTagFluent<?> fluent;

  public ImageTagBuilder() {
    this(new ImageTag());
  }
  
  public ImageTagBuilder(ImageTagFluent<?> fluent) {
    this(fluent, new ImageTag());
  }
  
  public ImageTagBuilder(ImageTag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageTagBuilder(ImageTagFluent<?> fluent,ImageTag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageTag build() {
    ImageTag buildable = new ImageTag(fluent.getApiVersion(), fluent.buildImage(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}