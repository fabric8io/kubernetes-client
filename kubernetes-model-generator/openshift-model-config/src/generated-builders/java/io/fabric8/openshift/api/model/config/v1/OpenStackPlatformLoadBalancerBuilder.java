package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenStackPlatformLoadBalancerBuilder extends OpenStackPlatformLoadBalancerFluent<OpenStackPlatformLoadBalancerBuilder> implements VisitableBuilder<OpenStackPlatformLoadBalancer,OpenStackPlatformLoadBalancerBuilder>{

  OpenStackPlatformLoadBalancerFluent<?> fluent;

  public OpenStackPlatformLoadBalancerBuilder() {
    this(new OpenStackPlatformLoadBalancer());
  }
  
  public OpenStackPlatformLoadBalancerBuilder(OpenStackPlatformLoadBalancerFluent<?> fluent) {
    this(fluent, new OpenStackPlatformLoadBalancer());
  }
  
  public OpenStackPlatformLoadBalancerBuilder(OpenStackPlatformLoadBalancer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenStackPlatformLoadBalancerBuilder(OpenStackPlatformLoadBalancerFluent<?> fluent,OpenStackPlatformLoadBalancer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenStackPlatformLoadBalancer build() {
    OpenStackPlatformLoadBalancer buildable = new OpenStackPlatformLoadBalancer(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}