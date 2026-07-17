package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageDigestSourceBuilder extends ImageDigestSourceFluent<ImageDigestSourceBuilder> implements VisitableBuilder<ImageDigestSource,ImageDigestSourceBuilder>{

  ImageDigestSourceFluent<?> fluent;

  public ImageDigestSourceBuilder() {
    this(new ImageDigestSource());
  }
  
  public ImageDigestSourceBuilder(ImageDigestSourceFluent<?> fluent) {
    this(fluent, new ImageDigestSource());
  }
  
  public ImageDigestSourceBuilder(ImageDigestSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageDigestSourceBuilder(ImageDigestSourceFluent<?> fluent,ImageDigestSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageDigestSource build() {
    ImageDigestSource buildable = new ImageDigestSource(fluent.getMirrors(), fluent.getSource(), fluent.getSourcePolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}