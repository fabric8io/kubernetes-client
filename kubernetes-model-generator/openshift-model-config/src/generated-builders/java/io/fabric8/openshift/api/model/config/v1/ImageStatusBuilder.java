package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStatusBuilder extends ImageStatusFluent<ImageStatusBuilder> implements VisitableBuilder<ImageStatus,ImageStatusBuilder>{

  ImageStatusFluent<?> fluent;

  public ImageStatusBuilder() {
    this(new ImageStatus());
  }
  
  public ImageStatusBuilder(ImageStatusFluent<?> fluent) {
    this(fluent, new ImageStatus());
  }
  
  public ImageStatusBuilder(ImageStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStatusBuilder(ImageStatusFluent<?> fluent,ImageStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStatus build() {
    ImageStatus buildable = new ImageStatus(fluent.getExternalRegistryHostnames(), fluent.getImageStreamImportMode(), fluent.getInternalRegistryHostname());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}