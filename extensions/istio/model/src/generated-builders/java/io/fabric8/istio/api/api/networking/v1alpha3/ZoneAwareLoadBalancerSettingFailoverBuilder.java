package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ZoneAwareLoadBalancerSettingFailoverBuilder extends ZoneAwareLoadBalancerSettingFailoverFluent<ZoneAwareLoadBalancerSettingFailoverBuilder> implements VisitableBuilder<ZoneAwareLoadBalancerSettingFailover,ZoneAwareLoadBalancerSettingFailoverBuilder>{

  ZoneAwareLoadBalancerSettingFailoverFluent<?> fluent;

  public ZoneAwareLoadBalancerSettingFailoverBuilder() {
    this(new ZoneAwareLoadBalancerSettingFailover());
  }
  
  public ZoneAwareLoadBalancerSettingFailoverBuilder(ZoneAwareLoadBalancerSettingFailoverFluent<?> fluent) {
    this(fluent, new ZoneAwareLoadBalancerSettingFailover());
  }
  
  public ZoneAwareLoadBalancerSettingFailoverBuilder(ZoneAwareLoadBalancerSettingFailover instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ZoneAwareLoadBalancerSettingFailoverBuilder(ZoneAwareLoadBalancerSettingFailoverFluent<?> fluent,ZoneAwareLoadBalancerSettingFailover instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ZoneAwareLoadBalancerSettingFailover build() {
    ZoneAwareLoadBalancerSettingFailover buildable = new ZoneAwareLoadBalancerSettingFailover(fluent.getFrom(), fluent.getTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}