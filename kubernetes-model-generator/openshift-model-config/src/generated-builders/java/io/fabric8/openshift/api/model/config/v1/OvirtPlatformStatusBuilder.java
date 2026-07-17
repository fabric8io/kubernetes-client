package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OvirtPlatformStatusBuilder extends OvirtPlatformStatusFluent<OvirtPlatformStatusBuilder> implements VisitableBuilder<OvirtPlatformStatus,OvirtPlatformStatusBuilder>{

  OvirtPlatformStatusFluent<?> fluent;

  public OvirtPlatformStatusBuilder() {
    this(new OvirtPlatformStatus());
  }
  
  public OvirtPlatformStatusBuilder(OvirtPlatformStatusFluent<?> fluent) {
    this(fluent, new OvirtPlatformStatus());
  }
  
  public OvirtPlatformStatusBuilder(OvirtPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OvirtPlatformStatusBuilder(OvirtPlatformStatusFluent<?> fluent,OvirtPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OvirtPlatformStatus build() {
    OvirtPlatformStatus buildable = new OvirtPlatformStatus(fluent.getApiServerInternalIP(), fluent.getApiServerInternalIPs(), fluent.getIngressIP(), fluent.getIngressIPs(), fluent.buildLoadBalancer(), fluent.getNodeDNSIP());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}