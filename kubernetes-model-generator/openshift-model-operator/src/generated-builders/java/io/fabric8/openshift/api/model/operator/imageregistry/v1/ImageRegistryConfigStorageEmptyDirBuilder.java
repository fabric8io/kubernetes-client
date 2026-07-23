package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStorageEmptyDirBuilder extends ImageRegistryConfigStorageEmptyDirFluent<ImageRegistryConfigStorageEmptyDirBuilder> implements VisitableBuilder<ImageRegistryConfigStorageEmptyDir,ImageRegistryConfigStorageEmptyDirBuilder>{

  ImageRegistryConfigStorageEmptyDirFluent<?> fluent;

  public ImageRegistryConfigStorageEmptyDirBuilder() {
    this(new ImageRegistryConfigStorageEmptyDir());
  }
  
  public ImageRegistryConfigStorageEmptyDirBuilder(ImageRegistryConfigStorageEmptyDirFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStorageEmptyDir());
  }
  
  public ImageRegistryConfigStorageEmptyDirBuilder(ImageRegistryConfigStorageEmptyDir instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStorageEmptyDirBuilder(ImageRegistryConfigStorageEmptyDirFluent<?> fluent,ImageRegistryConfigStorageEmptyDir instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStorageEmptyDir build() {
    ImageRegistryConfigStorageEmptyDir buildable = new ImageRegistryConfigStorageEmptyDir();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}