package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalPlatformStatusBuilder extends BareMetalPlatformStatusFluent<BareMetalPlatformStatusBuilder> implements VisitableBuilder<BareMetalPlatformStatus,BareMetalPlatformStatusBuilder>{

  BareMetalPlatformStatusFluent<?> fluent;

  public BareMetalPlatformStatusBuilder() {
    this(new BareMetalPlatformStatus());
  }
  
  public BareMetalPlatformStatusBuilder(BareMetalPlatformStatusFluent<?> fluent) {
    this(fluent, new BareMetalPlatformStatus());
  }
  
  public BareMetalPlatformStatusBuilder(BareMetalPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalPlatformStatusBuilder(BareMetalPlatformStatusFluent<?> fluent,BareMetalPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalPlatformStatus build() {
    BareMetalPlatformStatus buildable = new BareMetalPlatformStatus(fluent.getApiServerInternalIP(), fluent.getApiServerInternalIPs(), fluent.getIngressIP(), fluent.getIngressIPs(), fluent.buildLoadBalancer(), fluent.getMachineNetworks(), fluent.getNodeDNSIP());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}