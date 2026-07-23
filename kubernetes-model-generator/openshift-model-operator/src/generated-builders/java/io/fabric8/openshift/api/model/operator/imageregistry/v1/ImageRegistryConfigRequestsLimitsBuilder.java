package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryConfigRequestsLimitsBuilder extends ImageRegistryConfigRequestsLimitsFluent<ImageRegistryConfigRequestsLimitsBuilder> implements VisitableBuilder<ImageRegistryConfigRequestsLimits,ImageRegistryConfigRequestsLimitsBuilder>{

  ImageRegistryConfigRequestsLimitsFluent<?> fluent;

  public ImageRegistryConfigRequestsLimitsBuilder() {
    this(new ImageRegistryConfigRequestsLimits());
  }
  
  public ImageRegistryConfigRequestsLimitsBuilder(ImageRegistryConfigRequestsLimitsFluent<?> fluent) {
    this(fluent, new ImageRegistryConfigRequestsLimits());
  }
  
  public ImageRegistryConfigRequestsLimitsBuilder(ImageRegistryConfigRequestsLimits instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryConfigRequestsLimitsBuilder(ImageRegistryConfigRequestsLimitsFluent<?> fluent,ImageRegistryConfigRequestsLimits instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryConfigRequestsLimits build() {
    ImageRegistryConfigRequestsLimits buildable = new ImageRegistryConfigRequestsLimits(fluent.getMaxInQueue(), fluent.getMaxRunning(), fluent.getMaxWaitInQueue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}