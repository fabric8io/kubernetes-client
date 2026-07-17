package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMCloudPlatformStatusBuilder extends IBMCloudPlatformStatusFluent<IBMCloudPlatformStatusBuilder> implements VisitableBuilder<IBMCloudPlatformStatus,IBMCloudPlatformStatusBuilder>{

  IBMCloudPlatformStatusFluent<?> fluent;

  public IBMCloudPlatformStatusBuilder() {
    this(new IBMCloudPlatformStatus());
  }
  
  public IBMCloudPlatformStatusBuilder(IBMCloudPlatformStatusFluent<?> fluent) {
    this(fluent, new IBMCloudPlatformStatus());
  }
  
  public IBMCloudPlatformStatusBuilder(IBMCloudPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMCloudPlatformStatusBuilder(IBMCloudPlatformStatusFluent<?> fluent,IBMCloudPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMCloudPlatformStatus build() {
    IBMCloudPlatformStatus buildable = new IBMCloudPlatformStatus(fluent.getCisInstanceCRN(), fluent.getDnsInstanceCRN(), fluent.getLocation(), fluent.getProviderType(), fluent.getResourceGroupName(), fluent.buildServiceEndpoints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}