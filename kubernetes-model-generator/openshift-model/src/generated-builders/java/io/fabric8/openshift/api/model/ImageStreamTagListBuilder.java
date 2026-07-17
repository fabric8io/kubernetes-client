package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamTagListBuilder extends ImageStreamTagListFluent<ImageStreamTagListBuilder> implements VisitableBuilder<ImageStreamTagList,ImageStreamTagListBuilder>{

  ImageStreamTagListFluent<?> fluent;

  public ImageStreamTagListBuilder() {
    this(new ImageStreamTagList());
  }
  
  public ImageStreamTagListBuilder(ImageStreamTagListFluent<?> fluent) {
    this(fluent, new ImageStreamTagList());
  }
  
  public ImageStreamTagListBuilder(ImageStreamTagList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamTagListBuilder(ImageStreamTagListFluent<?> fluent,ImageStreamTagList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamTagList build() {
    ImageStreamTagList buildable = new ImageStreamTagList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}