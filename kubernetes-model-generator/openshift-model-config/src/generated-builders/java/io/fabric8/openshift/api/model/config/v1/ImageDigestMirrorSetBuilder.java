package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageDigestMirrorSetBuilder extends ImageDigestMirrorSetFluent<ImageDigestMirrorSetBuilder> implements VisitableBuilder<ImageDigestMirrorSet,ImageDigestMirrorSetBuilder>{

  ImageDigestMirrorSetFluent<?> fluent;

  public ImageDigestMirrorSetBuilder() {
    this(new ImageDigestMirrorSet());
  }
  
  public ImageDigestMirrorSetBuilder(ImageDigestMirrorSetFluent<?> fluent) {
    this(fluent, new ImageDigestMirrorSet());
  }
  
  public ImageDigestMirrorSetBuilder(ImageDigestMirrorSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageDigestMirrorSetBuilder(ImageDigestMirrorSetFluent<?> fluent,ImageDigestMirrorSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageDigestMirrorSet build() {
    ImageDigestMirrorSet buildable = new ImageDigestMirrorSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}