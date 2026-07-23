package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageTagListBuilder extends ImageTagListFluent<ImageTagListBuilder> implements VisitableBuilder<ImageTagList,ImageTagListBuilder>{

  ImageTagListFluent<?> fluent;

  public ImageTagListBuilder() {
    this(new ImageTagList());
  }
  
  public ImageTagListBuilder(ImageTagListFluent<?> fluent) {
    this(fluent, new ImageTagList());
  }
  
  public ImageTagListBuilder(ImageTagList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageTagListBuilder(ImageTagListFluent<?> fluent,ImageTagList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageTagList build() {
    ImageTagList buildable = new ImageTagList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}