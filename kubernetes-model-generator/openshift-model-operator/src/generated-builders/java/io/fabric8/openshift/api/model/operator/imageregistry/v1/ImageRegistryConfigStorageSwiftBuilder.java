package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStorageSwiftBuilder extends ImageRegistryConfigStorageSwiftFluent<ImageRegistryConfigStorageSwiftBuilder> implements VisitableBuilder<ImageRegistryConfigStorageSwift,ImageRegistryConfigStorageSwiftBuilder>{

  ImageRegistryConfigStorageSwiftFluent<?> fluent;

  public ImageRegistryConfigStorageSwiftBuilder() {
    this(new ImageRegistryConfigStorageSwift());
  }
  
  public ImageRegistryConfigStorageSwiftBuilder(ImageRegistryConfigStorageSwiftFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStorageSwift());
  }
  
  public ImageRegistryConfigStorageSwiftBuilder(ImageRegistryConfigStorageSwift instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStorageSwiftBuilder(ImageRegistryConfigStorageSwiftFluent<?> fluent,ImageRegistryConfigStorageSwift instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStorageSwift build() {
    ImageRegistryConfigStorageSwift buildable = new ImageRegistryConfigStorageSwift(fluent.getAuthURL(), fluent.getAuthVersion(), fluent.getContainer(), fluent.getDomain(), fluent.getDomainID(), fluent.getRegionName(), fluent.getTenant(), fluent.getTenantID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}