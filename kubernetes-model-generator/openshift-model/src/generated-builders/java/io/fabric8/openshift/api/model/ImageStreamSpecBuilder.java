package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamSpecBuilder extends ImageStreamSpecFluent<ImageStreamSpecBuilder> implements VisitableBuilder<ImageStreamSpec,ImageStreamSpecBuilder>{

  ImageStreamSpecFluent<?> fluent;

  public ImageStreamSpecBuilder() {
    this(new ImageStreamSpec());
  }
  
  public ImageStreamSpecBuilder(ImageStreamSpecFluent<?> fluent) {
    this(fluent, new ImageStreamSpec());
  }
  
  public ImageStreamSpecBuilder(ImageStreamSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamSpecBuilder(ImageStreamSpecFluent<?> fluent,ImageStreamSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamSpec build() {
    ImageStreamSpec buildable = new ImageStreamSpec(fluent.getDockerImageRepository(), fluent.buildLookupPolicy(), fluent.buildTags());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}