package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStoragePVCBuilder extends ImageRegistryConfigStoragePVCFluent<ImageRegistryConfigStoragePVCBuilder> implements VisitableBuilder<ImageRegistryConfigStoragePVC,ImageRegistryConfigStoragePVCBuilder>{

  ImageRegistryConfigStoragePVCFluent<?> fluent;

  public ImageRegistryConfigStoragePVCBuilder() {
    this(new ImageRegistryConfigStoragePVC());
  }
  
  public ImageRegistryConfigStoragePVCBuilder(ImageRegistryConfigStoragePVCFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStoragePVC());
  }
  
  public ImageRegistryConfigStoragePVCBuilder(ImageRegistryConfigStoragePVC instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStoragePVCBuilder(ImageRegistryConfigStoragePVCFluent<?> fluent,ImageRegistryConfigStoragePVC instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStoragePVC build() {
    ImageRegistryConfigStoragePVC buildable = new ImageRegistryConfigStoragePVC(fluent.getClaim());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}