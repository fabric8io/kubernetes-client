package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePrunerListBuilder extends ImagePrunerListFluent<ImagePrunerListBuilder> implements VisitableBuilder<ImagePrunerList,ImagePrunerListBuilder>{

  ImagePrunerListFluent<?> fluent;

  public ImagePrunerListBuilder() {
    this(new ImagePrunerList());
  }
  
  public ImagePrunerListBuilder(ImagePrunerListFluent<?> fluent) {
    this(fluent, new ImagePrunerList());
  }
  
  public ImagePrunerListBuilder(ImagePrunerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePrunerListBuilder(ImagePrunerListFluent<?> fluent,ImagePrunerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePrunerList build() {
    ImagePrunerList buildable = new ImagePrunerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}