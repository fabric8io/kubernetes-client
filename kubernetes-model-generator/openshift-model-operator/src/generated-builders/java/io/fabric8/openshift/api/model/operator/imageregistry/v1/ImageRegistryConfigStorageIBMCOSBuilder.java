package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStorageIBMCOSBuilder extends ImageRegistryConfigStorageIBMCOSFluent<ImageRegistryConfigStorageIBMCOSBuilder> implements VisitableBuilder<ImageRegistryConfigStorageIBMCOS,ImageRegistryConfigStorageIBMCOSBuilder>{

  ImageRegistryConfigStorageIBMCOSFluent<?> fluent;

  public ImageRegistryConfigStorageIBMCOSBuilder() {
    this(new ImageRegistryConfigStorageIBMCOS());
  }
  
  public ImageRegistryConfigStorageIBMCOSBuilder(ImageRegistryConfigStorageIBMCOSFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStorageIBMCOS());
  }
  
  public ImageRegistryConfigStorageIBMCOSBuilder(ImageRegistryConfigStorageIBMCOS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStorageIBMCOSBuilder(ImageRegistryConfigStorageIBMCOSFluent<?> fluent,ImageRegistryConfigStorageIBMCOS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStorageIBMCOS build() {
    ImageRegistryConfigStorageIBMCOS buildable = new ImageRegistryConfigStorageIBMCOS(fluent.getBucket(), fluent.getLocation(), fluent.getResourceGroupName(), fluent.getResourceKeyCRN(), fluent.getServiceInstanceCRN());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}