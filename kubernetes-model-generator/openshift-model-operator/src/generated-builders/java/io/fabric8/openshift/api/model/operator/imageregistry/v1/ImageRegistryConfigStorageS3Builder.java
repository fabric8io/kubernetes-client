package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStorageS3Builder extends ImageRegistryConfigStorageS3Fluent<ImageRegistryConfigStorageS3Builder> implements VisitableBuilder<ImageRegistryConfigStorageS3,ImageRegistryConfigStorageS3Builder>{

  ImageRegistryConfigStorageS3Fluent<?> fluent;

  public ImageRegistryConfigStorageS3Builder() {
    this(new ImageRegistryConfigStorageS3());
  }
  
  public ImageRegistryConfigStorageS3Builder(ImageRegistryConfigStorageS3Fluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStorageS3());
  }
  
  public ImageRegistryConfigStorageS3Builder(ImageRegistryConfigStorageS3 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStorageS3Builder(ImageRegistryConfigStorageS3Fluent<?> fluent,ImageRegistryConfigStorageS3 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStorageS3 build() {
    ImageRegistryConfigStorageS3 buildable = new ImageRegistryConfigStorageS3(fluent.getBucket(), fluent.getChunkSizeMiB(), fluent.buildCloudFront(), fluent.getEncrypt(), fluent.getKeyID(), fluent.getRegion(), fluent.getRegionEndpoint(), fluent.buildTrustedCA(), fluent.getVirtualHostedStyle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}