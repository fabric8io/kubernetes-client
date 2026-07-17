package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStorageBuilder extends ImageRegistryConfigStorageFluent<ImageRegistryConfigStorageBuilder> implements VisitableBuilder<ImageRegistryConfigStorage,ImageRegistryConfigStorageBuilder>{

  ImageRegistryConfigStorageFluent<?> fluent;

  public ImageRegistryConfigStorageBuilder() {
    this(new ImageRegistryConfigStorage());
  }
  
  public ImageRegistryConfigStorageBuilder(ImageRegistryConfigStorageFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStorage());
  }
  
  public ImageRegistryConfigStorageBuilder(ImageRegistryConfigStorage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStorageBuilder(ImageRegistryConfigStorageFluent<?> fluent,ImageRegistryConfigStorage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStorage build() {
    ImageRegistryConfigStorage buildable = new ImageRegistryConfigStorage(fluent.buildAzure(), fluent.buildEmptyDir(), fluent.buildGcs(), fluent.buildIbmcos(), fluent.getManagementState(), fluent.buildOss(), fluent.buildPvc(), fluent.buildS3(), fluent.buildSwift());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}