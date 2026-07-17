package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStorageAzureBuilder extends ImageRegistryConfigStorageAzureFluent<ImageRegistryConfigStorageAzureBuilder> implements VisitableBuilder<ImageRegistryConfigStorageAzure,ImageRegistryConfigStorageAzureBuilder>{

  ImageRegistryConfigStorageAzureFluent<?> fluent;

  public ImageRegistryConfigStorageAzureBuilder() {
    this(new ImageRegistryConfigStorageAzure());
  }
  
  public ImageRegistryConfigStorageAzureBuilder(ImageRegistryConfigStorageAzureFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStorageAzure());
  }
  
  public ImageRegistryConfigStorageAzureBuilder(ImageRegistryConfigStorageAzure instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStorageAzureBuilder(ImageRegistryConfigStorageAzureFluent<?> fluent,ImageRegistryConfigStorageAzure instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStorageAzure build() {
    ImageRegistryConfigStorageAzure buildable = new ImageRegistryConfigStorageAzure(fluent.getAccountName(), fluent.getCloudName(), fluent.getContainer(), fluent.buildNetworkAccess());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}