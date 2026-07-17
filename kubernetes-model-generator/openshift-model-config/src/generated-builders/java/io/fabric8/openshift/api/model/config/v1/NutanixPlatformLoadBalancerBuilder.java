package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixPlatformLoadBalancerBuilder extends NutanixPlatformLoadBalancerFluent<NutanixPlatformLoadBalancerBuilder> implements VisitableBuilder<NutanixPlatformLoadBalancer,NutanixPlatformLoadBalancerBuilder>{

  NutanixPlatformLoadBalancerFluent<?> fluent;

  public NutanixPlatformLoadBalancerBuilder() {
    this(new NutanixPlatformLoadBalancer());
  }
  
  public NutanixPlatformLoadBalancerBuilder(NutanixPlatformLoadBalancerFluent<?> fluent) {
    this(fluent, new NutanixPlatformLoadBalancer());
  }
  
  public NutanixPlatformLoadBalancerBuilder(NutanixPlatformLoadBalancer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixPlatformLoadBalancerBuilder(NutanixPlatformLoadBalancerFluent<?> fluent,NutanixPlatformLoadBalancer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixPlatformLoadBalancer build() {
    NutanixPlatformLoadBalancer buildable = new NutanixPlatformLoadBalancer(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}