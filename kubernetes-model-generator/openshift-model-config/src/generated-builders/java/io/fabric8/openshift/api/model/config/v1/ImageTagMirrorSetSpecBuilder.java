package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageTagMirrorSetSpecBuilder extends ImageTagMirrorSetSpecFluent<ImageTagMirrorSetSpecBuilder> implements VisitableBuilder<ImageTagMirrorSetSpec,ImageTagMirrorSetSpecBuilder>{

  ImageTagMirrorSetSpecFluent<?> fluent;

  public ImageTagMirrorSetSpecBuilder() {
    this(new ImageTagMirrorSetSpec());
  }
  
  public ImageTagMirrorSetSpecBuilder(ImageTagMirrorSetSpecFluent<?> fluent) {
    this(fluent, new ImageTagMirrorSetSpec());
  }
  
  public ImageTagMirrorSetSpecBuilder(ImageTagMirrorSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageTagMirrorSetSpecBuilder(ImageTagMirrorSetSpecFluent<?> fluent,ImageTagMirrorSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageTagMirrorSetSpec build() {
    ImageTagMirrorSetSpec buildable = new ImageTagMirrorSetSpec(fluent.buildImageTagMirrors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}