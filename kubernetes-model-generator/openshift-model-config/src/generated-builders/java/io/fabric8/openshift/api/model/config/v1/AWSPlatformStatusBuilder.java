package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSPlatformStatusBuilder extends AWSPlatformStatusFluent<AWSPlatformStatusBuilder> implements VisitableBuilder<AWSPlatformStatus,AWSPlatformStatusBuilder>{

  AWSPlatformStatusFluent<?> fluent;

  public AWSPlatformStatusBuilder() {
    this(new AWSPlatformStatus());
  }
  
  public AWSPlatformStatusBuilder(AWSPlatformStatusFluent<?> fluent) {
    this(fluent, new AWSPlatformStatus());
  }
  
  public AWSPlatformStatusBuilder(AWSPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSPlatformStatusBuilder(AWSPlatformStatusFluent<?> fluent,AWSPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSPlatformStatus build() {
    AWSPlatformStatus buildable = new AWSPlatformStatus(fluent.buildCloudLoadBalancerConfig(), fluent.getRegion(), fluent.buildResourceTags(), fluent.buildServiceEndpoints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}