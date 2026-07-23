package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamMappingBuilder extends ImageStreamMappingFluent<ImageStreamMappingBuilder> implements VisitableBuilder<ImageStreamMapping,ImageStreamMappingBuilder>{

  ImageStreamMappingFluent<?> fluent;

  public ImageStreamMappingBuilder() {
    this(new ImageStreamMapping());
  }
  
  public ImageStreamMappingBuilder(ImageStreamMappingFluent<?> fluent) {
    this(fluent, new ImageStreamMapping());
  }
  
  public ImageStreamMappingBuilder(ImageStreamMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamMappingBuilder(ImageStreamMappingFluent<?> fluent,ImageStreamMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamMapping build() {
    ImageStreamMapping buildable = new ImageStreamMapping(fluent.getApiVersion(), fluent.buildImage(), fluent.getKind(), fluent.buildMetadata(), fluent.getTag());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}