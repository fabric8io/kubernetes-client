package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStorageAlibabaOSSBuilder extends ImageRegistryConfigStorageAlibabaOSSFluent<ImageRegistryConfigStorageAlibabaOSSBuilder> implements VisitableBuilder<ImageRegistryConfigStorageAlibabaOSS,ImageRegistryConfigStorageAlibabaOSSBuilder>{

  ImageRegistryConfigStorageAlibabaOSSFluent<?> fluent;

  public ImageRegistryConfigStorageAlibabaOSSBuilder() {
    this(new ImageRegistryConfigStorageAlibabaOSS());
  }
  
  public ImageRegistryConfigStorageAlibabaOSSBuilder(ImageRegistryConfigStorageAlibabaOSSFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStorageAlibabaOSS());
  }
  
  public ImageRegistryConfigStorageAlibabaOSSBuilder(ImageRegistryConfigStorageAlibabaOSS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStorageAlibabaOSSBuilder(ImageRegistryConfigStorageAlibabaOSSFluent<?> fluent,ImageRegistryConfigStorageAlibabaOSS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStorageAlibabaOSS build() {
    ImageRegistryConfigStorageAlibabaOSS buildable = new ImageRegistryConfigStorageAlibabaOSS(fluent.getBucket(), fluent.buildEncryption(), fluent.getEndpointAccessibility(), fluent.getRegion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}