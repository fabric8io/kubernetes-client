package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalPlatformLoadBalancerBuilder extends BareMetalPlatformLoadBalancerFluent<BareMetalPlatformLoadBalancerBuilder> implements VisitableBuilder<BareMetalPlatformLoadBalancer,BareMetalPlatformLoadBalancerBuilder>{

  BareMetalPlatformLoadBalancerFluent<?> fluent;

  public BareMetalPlatformLoadBalancerBuilder() {
    this(new BareMetalPlatformLoadBalancer());
  }
  
  public BareMetalPlatformLoadBalancerBuilder(BareMetalPlatformLoadBalancerFluent<?> fluent) {
    this(fluent, new BareMetalPlatformLoadBalancer());
  }
  
  public BareMetalPlatformLoadBalancerBuilder(BareMetalPlatformLoadBalancer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalPlatformLoadBalancerBuilder(BareMetalPlatformLoadBalancerFluent<?> fluent,BareMetalPlatformLoadBalancer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalPlatformLoadBalancer build() {
    BareMetalPlatformLoadBalancer buildable = new BareMetalPlatformLoadBalancer(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}