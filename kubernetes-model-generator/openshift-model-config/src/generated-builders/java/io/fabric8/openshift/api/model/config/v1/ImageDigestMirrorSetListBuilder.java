package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageDigestMirrorSetListBuilder extends ImageDigestMirrorSetListFluent<ImageDigestMirrorSetListBuilder> implements VisitableBuilder<ImageDigestMirrorSetList,ImageDigestMirrorSetListBuilder>{

  ImageDigestMirrorSetListFluent<?> fluent;

  public ImageDigestMirrorSetListBuilder() {
    this(new ImageDigestMirrorSetList());
  }
  
  public ImageDigestMirrorSetListBuilder(ImageDigestMirrorSetListFluent<?> fluent) {
    this(fluent, new ImageDigestMirrorSetList());
  }
  
  public ImageDigestMirrorSetListBuilder(ImageDigestMirrorSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageDigestMirrorSetListBuilder(ImageDigestMirrorSetListFluent<?> fluent,ImageDigestMirrorSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageDigestMirrorSetList build() {
    ImageDigestMirrorSetList buildable = new ImageDigestMirrorSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}