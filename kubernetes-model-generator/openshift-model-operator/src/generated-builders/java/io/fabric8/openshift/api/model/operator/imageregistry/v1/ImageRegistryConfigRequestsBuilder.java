package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigRequestsBuilder extends ImageRegistryConfigRequestsFluent<ImageRegistryConfigRequestsBuilder> implements VisitableBuilder<ImageRegistryConfigRequests,ImageRegistryConfigRequestsBuilder>{

  ImageRegistryConfigRequestsFluent<?> fluent;

  public ImageRegistryConfigRequestsBuilder() {
    this(new ImageRegistryConfigRequests());
  }
  
  public ImageRegistryConfigRequestsBuilder(ImageRegistryConfigRequestsFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigRequests());
  }
  
  public ImageRegistryConfigRequestsBuilder(ImageRegistryConfigRequests instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigRequestsBuilder(ImageRegistryConfigRequestsFluent<?> fluent,ImageRegistryConfigRequests instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigRequests build() {
    ImageRegistryConfigRequests buildable = new ImageRegistryConfigRequests(fluent.buildRead(), fluent.buildWrite());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}