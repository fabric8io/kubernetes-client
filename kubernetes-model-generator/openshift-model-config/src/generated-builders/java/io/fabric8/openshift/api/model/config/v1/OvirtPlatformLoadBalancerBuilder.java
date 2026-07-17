package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OvirtPlatformLoadBalancerBuilder extends OvirtPlatformLoadBalancerFluent<OvirtPlatformLoadBalancerBuilder> implements VisitableBuilder<OvirtPlatformLoadBalancer,OvirtPlatformLoadBalancerBuilder>{

  OvirtPlatformLoadBalancerFluent<?> fluent;

  public OvirtPlatformLoadBalancerBuilder() {
    this(new OvirtPlatformLoadBalancer());
  }
  
  public OvirtPlatformLoadBalancerBuilder(OvirtPlatformLoadBalancerFluent<?> fluent) {
    this(fluent, new OvirtPlatformLoadBalancer());
  }
  
  public OvirtPlatformLoadBalancerBuilder(OvirtPlatformLoadBalancer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OvirtPlatformLoadBalancerBuilder(OvirtPlatformLoadBalancerFluent<?> fluent,OvirtPlatformLoadBalancer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OvirtPlatformLoadBalancer build() {
    OvirtPlatformLoadBalancer buildable = new OvirtPlatformLoadBalancer(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}