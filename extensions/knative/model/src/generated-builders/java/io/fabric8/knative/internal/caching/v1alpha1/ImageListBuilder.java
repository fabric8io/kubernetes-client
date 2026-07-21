package io.fabric8.knative.internal.caching.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageListBuilder extends ImageListFluent<ImageListBuilder> implements VisitableBuilder<ImageList,ImageListBuilder>{

  ImageListFluent<?> fluent;

  public ImageListBuilder() {
    this(new ImageList());
  }
  
  public ImageListBuilder(ImageListFluent<?> fluent) {
    this(fluent, new ImageList());
  }
  
  public ImageListBuilder(ImageList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageListBuilder(ImageListFluent<?> fluent,ImageList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageList build() {
    ImageList buildable = new ImageList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}