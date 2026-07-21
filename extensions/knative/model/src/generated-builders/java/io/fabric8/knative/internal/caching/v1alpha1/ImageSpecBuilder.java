package io.fabric8.knative.internal.caching.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageSpecBuilder extends ImageSpecFluent<ImageSpecBuilder> implements VisitableBuilder<ImageSpec,ImageSpecBuilder>{

  ImageSpecFluent<?> fluent;

  public ImageSpecBuilder() {
    this(new ImageSpec());
  }
  
  public ImageSpecBuilder(ImageSpecFluent<?> fluent) {
    this(fluent, new ImageSpec());
  }
  
  public ImageSpecBuilder(ImageSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageSpecBuilder(ImageSpecFluent<?> fluent,ImageSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageSpec build() {
    ImageSpec buildable = new ImageSpec(fluent.getImage(), fluent.buildImagePullSecrets(), fluent.getServiceAccountName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}