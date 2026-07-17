package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageDigestMirrorsBuilder extends ImageDigestMirrorsFluent<ImageDigestMirrorsBuilder> implements VisitableBuilder<ImageDigestMirrors,ImageDigestMirrorsBuilder>{

  ImageDigestMirrorsFluent<?> fluent;

  public ImageDigestMirrorsBuilder() {
    this(new ImageDigestMirrors());
  }
  
  public ImageDigestMirrorsBuilder(ImageDigestMirrorsFluent<?> fluent) {
    this(fluent, new ImageDigestMirrors());
  }
  
  public ImageDigestMirrorsBuilder(ImageDigestMirrors instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageDigestMirrorsBuilder(ImageDigestMirrorsFluent<?> fluent,ImageDigestMirrors instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageDigestMirrors build() {
    ImageDigestMirrors buildable = new ImageDigestMirrors(fluent.getMirrorSourcePolicy(), fluent.getMirrors(), fluent.getSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}