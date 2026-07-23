package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlibabaCloudPlatformStatusBuilder extends AlibabaCloudPlatformStatusFluent<AlibabaCloudPlatformStatusBuilder> implements VisitableBuilder<AlibabaCloudPlatformStatus,AlibabaCloudPlatformStatusBuilder>{

  AlibabaCloudPlatformStatusFluent<?> fluent;

  public AlibabaCloudPlatformStatusBuilder() {
    this(new AlibabaCloudPlatformStatus());
  }
  
  public AlibabaCloudPlatformStatusBuilder(AlibabaCloudPlatformStatusFluent<?> fluent) {
    this(fluent, new AlibabaCloudPlatformStatus());
  }
  
  public AlibabaCloudPlatformStatusBuilder(AlibabaCloudPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlibabaCloudPlatformStatusBuilder(AlibabaCloudPlatformStatusFluent<?> fluent,AlibabaCloudPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlibabaCloudPlatformStatus build() {
    AlibabaCloudPlatformStatus buildable = new AlibabaCloudPlatformStatus(fluent.getRegion(), fluent.getResourceGroupID(), fluent.buildResourceTags());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}