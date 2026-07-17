package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePrunerStatusBuilder extends ImagePrunerStatusFluent<ImagePrunerStatusBuilder> implements VisitableBuilder<ImagePrunerStatus,ImagePrunerStatusBuilder>{

  ImagePrunerStatusFluent<?> fluent;

  public ImagePrunerStatusBuilder() {
    this(new ImagePrunerStatus());
  }
  
  public ImagePrunerStatusBuilder(ImagePrunerStatusFluent<?> fluent) {
    this(fluent, new ImagePrunerStatus());
  }
  
  public ImagePrunerStatusBuilder(ImagePrunerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePrunerStatusBuilder(ImagePrunerStatusFluent<?> fluent,ImagePrunerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePrunerStatus build() {
    ImagePrunerStatus buildable = new ImagePrunerStatus(fluent.buildConditions(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}