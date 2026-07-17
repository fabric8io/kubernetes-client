package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSpherePlatformStatusBuilder extends VSpherePlatformStatusFluent<VSpherePlatformStatusBuilder> implements VisitableBuilder<VSpherePlatformStatus,VSpherePlatformStatusBuilder>{

  VSpherePlatformStatusFluent<?> fluent;

  public VSpherePlatformStatusBuilder() {
    this(new VSpherePlatformStatus());
  }
  
  public VSpherePlatformStatusBuilder(VSpherePlatformStatusFluent<?> fluent) {
    this(fluent, new VSpherePlatformStatus());
  }
  
  public VSpherePlatformStatusBuilder(VSpherePlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSpherePlatformStatusBuilder(VSpherePlatformStatusFluent<?> fluent,VSpherePlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSpherePlatformStatus build() {
    VSpherePlatformStatus buildable = new VSpherePlatformStatus(fluent.getApiServerInternalIP(), fluent.getApiServerInternalIPs(), fluent.getIngressIP(), fluent.getIngressIPs(), fluent.buildLoadBalancer(), fluent.getMachineNetworks(), fluent.getNodeDNSIP());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}