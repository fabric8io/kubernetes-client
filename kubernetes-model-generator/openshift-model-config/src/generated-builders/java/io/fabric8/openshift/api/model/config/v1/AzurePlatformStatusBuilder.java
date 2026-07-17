package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzurePlatformStatusBuilder extends AzurePlatformStatusFluent<AzurePlatformStatusBuilder> implements VisitableBuilder<AzurePlatformStatus,AzurePlatformStatusBuilder>{

  AzurePlatformStatusFluent<?> fluent;

  public AzurePlatformStatusBuilder() {
    this(new AzurePlatformStatus());
  }
  
  public AzurePlatformStatusBuilder(AzurePlatformStatusFluent<?> fluent) {
    this(fluent, new AzurePlatformStatus());
  }
  
  public AzurePlatformStatusBuilder(AzurePlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzurePlatformStatusBuilder(AzurePlatformStatusFluent<?> fluent,AzurePlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzurePlatformStatus build() {
    AzurePlatformStatus buildable = new AzurePlatformStatus(fluent.getArmEndpoint(), fluent.buildCloudLoadBalancerConfig(), fluent.getCloudName(), fluent.getNetworkResourceGroupName(), fluent.getResourceGroupName(), fluent.buildResourceTags());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}