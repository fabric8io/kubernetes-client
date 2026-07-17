package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageTagMirrorSetListBuilder extends ImageTagMirrorSetListFluent<ImageTagMirrorSetListBuilder> implements VisitableBuilder<ImageTagMirrorSetList,ImageTagMirrorSetListBuilder>{

  ImageTagMirrorSetListFluent<?> fluent;

  public ImageTagMirrorSetListBuilder() {
    this(new ImageTagMirrorSetList());
  }
  
  public ImageTagMirrorSetListBuilder(ImageTagMirrorSetListFluent<?> fluent) {
    this(fluent, new ImageTagMirrorSetList());
  }
  
  public ImageTagMirrorSetListBuilder(ImageTagMirrorSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageTagMirrorSetListBuilder(ImageTagMirrorSetListFluent<?> fluent,ImageTagMirrorSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageTagMirrorSetList build() {
    ImageTagMirrorSetList buildable = new ImageTagMirrorSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}