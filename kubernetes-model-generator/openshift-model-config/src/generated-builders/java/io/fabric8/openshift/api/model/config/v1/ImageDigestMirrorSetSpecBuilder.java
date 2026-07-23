package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageDigestMirrorSetSpecBuilder extends ImageDigestMirrorSetSpecFluent<ImageDigestMirrorSetSpecBuilder> implements VisitableBuilder<ImageDigestMirrorSetSpec,ImageDigestMirrorSetSpecBuilder>{

  ImageDigestMirrorSetSpecFluent<?> fluent;

  public ImageDigestMirrorSetSpecBuilder() {
    this(new ImageDigestMirrorSetSpec());
  }
  
  public ImageDigestMirrorSetSpecBuilder(ImageDigestMirrorSetSpecFluent<?> fluent) {
    this(fluent, new ImageDigestMirrorSetSpec());
  }
  
  public ImageDigestMirrorSetSpecBuilder(ImageDigestMirrorSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageDigestMirrorSetSpecBuilder(ImageDigestMirrorSetSpecFluent<?> fluent,ImageDigestMirrorSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageDigestMirrorSetSpec build() {
    ImageDigestMirrorSetSpec buildable = new ImageDigestMirrorSetSpec(fluent.buildImageDigestMirrors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}