package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSpherePlatformLoadBalancerBuilder extends VSpherePlatformLoadBalancerFluent<VSpherePlatformLoadBalancerBuilder> implements VisitableBuilder<VSpherePlatformLoadBalancer,VSpherePlatformLoadBalancerBuilder>{

  VSpherePlatformLoadBalancerFluent<?> fluent;

  public VSpherePlatformLoadBalancerBuilder() {
    this(new VSpherePlatformLoadBalancer());
  }
  
  public VSpherePlatformLoadBalancerBuilder(VSpherePlatformLoadBalancerFluent<?> fluent) {
    this(fluent, new VSpherePlatformLoadBalancer());
  }
  
  public VSpherePlatformLoadBalancerBuilder(VSpherePlatformLoadBalancer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSpherePlatformLoadBalancerBuilder(VSpherePlatformLoadBalancerFluent<?> fluent,VSpherePlatformLoadBalancer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSpherePlatformLoadBalancer build() {
    VSpherePlatformLoadBalancer buildable = new VSpherePlatformLoadBalancer(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}