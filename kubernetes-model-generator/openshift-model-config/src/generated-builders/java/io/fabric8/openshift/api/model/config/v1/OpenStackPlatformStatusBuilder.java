package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenStackPlatformStatusBuilder extends OpenStackPlatformStatusFluent<OpenStackPlatformStatusBuilder> implements VisitableBuilder<OpenStackPlatformStatus,OpenStackPlatformStatusBuilder>{

  OpenStackPlatformStatusFluent<?> fluent;

  public OpenStackPlatformStatusBuilder() {
    this(new OpenStackPlatformStatus());
  }
  
  public OpenStackPlatformStatusBuilder(OpenStackPlatformStatusFluent<?> fluent) {
    this(fluent, new OpenStackPlatformStatus());
  }
  
  public OpenStackPlatformStatusBuilder(OpenStackPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenStackPlatformStatusBuilder(OpenStackPlatformStatusFluent<?> fluent,OpenStackPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenStackPlatformStatus build() {
    OpenStackPlatformStatus buildable = new OpenStackPlatformStatus(fluent.getApiServerInternalIP(), fluent.getApiServerInternalIPs(), fluent.getCloudName(), fluent.getIngressIP(), fluent.getIngressIPs(), fluent.buildLoadBalancer(), fluent.getMachineNetworks(), fluent.getNodeDNSIP());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}