package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageTagMirrorSetBuilder extends ImageTagMirrorSetFluent<ImageTagMirrorSetBuilder> implements VisitableBuilder<ImageTagMirrorSet,ImageTagMirrorSetBuilder>{

  ImageTagMirrorSetFluent<?> fluent;

  public ImageTagMirrorSetBuilder() {
    this(new ImageTagMirrorSet());
  }
  
  public ImageTagMirrorSetBuilder(ImageTagMirrorSetFluent<?> fluent) {
    this(fluent, new ImageTagMirrorSet());
  }
  
  public ImageTagMirrorSetBuilder(ImageTagMirrorSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageTagMirrorSetBuilder(ImageTagMirrorSetFluent<?> fluent,ImageTagMirrorSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageTagMirrorSet build() {
    ImageTagMirrorSet buildable = new ImageTagMirrorSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}