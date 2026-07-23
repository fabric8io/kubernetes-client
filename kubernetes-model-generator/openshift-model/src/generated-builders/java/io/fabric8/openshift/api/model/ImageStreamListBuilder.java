package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamListBuilder extends ImageStreamListFluent<ImageStreamListBuilder> implements VisitableBuilder<ImageStreamList,ImageStreamListBuilder>{

  ImageStreamListFluent<?> fluent;

  public ImageStreamListBuilder() {
    this(new ImageStreamList());
  }
  
  public ImageStreamListBuilder(ImageStreamListFluent<?> fluent) {
    this(fluent, new ImageStreamList());
  }
  
  public ImageStreamListBuilder(ImageStreamList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamListBuilder(ImageStreamListFluent<?> fluent,ImageStreamList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamList build() {
    ImageStreamList buildable = new ImageStreamList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}