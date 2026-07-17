package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStorageS3CloudFrontBuilder extends ImageRegistryConfigStorageS3CloudFrontFluent<ImageRegistryConfigStorageS3CloudFrontBuilder> implements VisitableBuilder<ImageRegistryConfigStorageS3CloudFront,ImageRegistryConfigStorageS3CloudFrontBuilder>{

  ImageRegistryConfigStorageS3CloudFrontFluent<?> fluent;

  public ImageRegistryConfigStorageS3CloudFrontBuilder() {
    this(new ImageRegistryConfigStorageS3CloudFront());
  }
  
  public ImageRegistryConfigStorageS3CloudFrontBuilder(ImageRegistryConfigStorageS3CloudFrontFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStorageS3CloudFront());
  }
  
  public ImageRegistryConfigStorageS3CloudFrontBuilder(ImageRegistryConfigStorageS3CloudFront instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStorageS3CloudFrontBuilder(ImageRegistryConfigStorageS3CloudFrontFluent<?> fluent,ImageRegistryConfigStorageS3CloudFront instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStorageS3CloudFront build() {
    ImageRegistryConfigStorageS3CloudFront buildable = new ImageRegistryConfigStorageS3CloudFront(fluent.getBaseURL(), fluent.getDuration(), fluent.getKeypairID(), fluent.getPrivateKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}