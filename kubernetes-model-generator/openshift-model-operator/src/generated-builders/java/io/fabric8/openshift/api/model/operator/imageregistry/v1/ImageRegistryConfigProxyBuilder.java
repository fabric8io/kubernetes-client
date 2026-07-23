package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigProxyBuilder extends ImageRegistryConfigProxyFluent<ImageRegistryConfigProxyBuilder> implements VisitableBuilder<ImageRegistryConfigProxy,ImageRegistryConfigProxyBuilder>{

  ImageRegistryConfigProxyFluent<?> fluent;

  public ImageRegistryConfigProxyBuilder() {
    this(new ImageRegistryConfigProxy());
  }
  
  public ImageRegistryConfigProxyBuilder(ImageRegistryConfigProxyFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigProxy());
  }
  
  public ImageRegistryConfigProxyBuilder(ImageRegistryConfigProxy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigProxyBuilder(ImageRegistryConfigProxyFluent<?> fluent,ImageRegistryConfigProxy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigProxy build() {
    ImageRegistryConfigProxy buildable = new ImageRegistryConfigProxy(fluent.getHttp(), fluent.getHttps(), fluent.getNoProxy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}