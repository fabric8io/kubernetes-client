package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigStorageGCSBuilder extends ImageRegistryConfigStorageGCSFluent<ImageRegistryConfigStorageGCSBuilder> implements VisitableBuilder<ImageRegistryConfigStorageGCS,ImageRegistryConfigStorageGCSBuilder>{

  ImageRegistryConfigStorageGCSFluent<?> fluent;

  public ImageRegistryConfigStorageGCSBuilder() {
    this(new ImageRegistryConfigStorageGCS());
  }
  
  public ImageRegistryConfigStorageGCSBuilder(ImageRegistryConfigStorageGCSFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigStorageGCS());
  }
  
  public ImageRegistryConfigStorageGCSBuilder(ImageRegistryConfigStorageGCS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigStorageGCSBuilder(ImageRegistryConfigStorageGCSFluent<?> fluent,ImageRegistryConfigStorageGCS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigStorageGCS build() {
    ImageRegistryConfigStorageGCS buildable = new ImageRegistryConfigStorageGCS(fluent.getBucket(), fluent.getKeyID(), fluent.getProjectID(), fluent.getRegion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}