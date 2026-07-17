package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigRouteBuilder extends ImageRegistryConfigRouteFluent<ImageRegistryConfigRouteBuilder> implements VisitableBuilder<ImageRegistryConfigRoute,ImageRegistryConfigRouteBuilder>{

  ImageRegistryConfigRouteFluent<?> fluent;

  public ImageRegistryConfigRouteBuilder() {
    this(new ImageRegistryConfigRoute());
  }
  
  public ImageRegistryConfigRouteBuilder(ImageRegistryConfigRouteFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigRoute());
  }
  
  public ImageRegistryConfigRouteBuilder(ImageRegistryConfigRoute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigRouteBuilder(ImageRegistryConfigRouteFluent<?> fluent,ImageRegistryConfigRoute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigRoute build() {
    ImageRegistryConfigRoute buildable = new ImageRegistryConfigRoute(fluent.getHostname(), fluent.getName(), fluent.getSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}