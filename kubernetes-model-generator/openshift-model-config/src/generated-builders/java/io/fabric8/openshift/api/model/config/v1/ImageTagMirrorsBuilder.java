package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageTagMirrorsBuilder extends ImageTagMirrorsFluent<ImageTagMirrorsBuilder> implements VisitableBuilder<ImageTagMirrors,ImageTagMirrorsBuilder>{

  ImageTagMirrorsFluent<?> fluent;

  public ImageTagMirrorsBuilder() {
    this(new ImageTagMirrors());
  }
  
  public ImageTagMirrorsBuilder(ImageTagMirrorsFluent<?> fluent) {
    this(fluent, new ImageTagMirrors());
  }
  
  public ImageTagMirrorsBuilder(ImageTagMirrors instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageTagMirrorsBuilder(ImageTagMirrorsFluent<?> fluent,ImageTagMirrors instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageTagMirrors build() {
    ImageTagMirrors buildable = new ImageTagMirrors(fluent.getMirrorSourcePolicy(), fluent.getMirrors(), fluent.getSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}