package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPPlatformStatusBuilder extends GCPPlatformStatusFluent<GCPPlatformStatusBuilder> implements VisitableBuilder<GCPPlatformStatus,GCPPlatformStatusBuilder>{

  GCPPlatformStatusFluent<?> fluent;

  public GCPPlatformStatusBuilder() {
    this(new GCPPlatformStatus());
  }
  
  public GCPPlatformStatusBuilder(GCPPlatformStatusFluent<?> fluent) {
    this(fluent, new GCPPlatformStatus());
  }
  
  public GCPPlatformStatusBuilder(GCPPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPPlatformStatusBuilder(GCPPlatformStatusFluent<?> fluent,GCPPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPPlatformStatus build() {
    GCPPlatformStatus buildable = new GCPPlatformStatus(fluent.buildCloudLoadBalancerConfig(), fluent.getProjectID(), fluent.getRegion(), fluent.buildResourceLabels(), fluent.buildResourceTags(), fluent.buildServiceEndpoints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}