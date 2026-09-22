package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ZoneAwareLoadBalancerSettingBuilder extends ZoneAwareLoadBalancerSettingFluent<ZoneAwareLoadBalancerSettingBuilder> implements VisitableBuilder<ZoneAwareLoadBalancerSetting,ZoneAwareLoadBalancerSettingBuilder>{

  ZoneAwareLoadBalancerSettingFluent<?> fluent;

  public ZoneAwareLoadBalancerSettingBuilder() {
    this(new ZoneAwareLoadBalancerSetting());
  }
  
  public ZoneAwareLoadBalancerSettingBuilder(ZoneAwareLoadBalancerSettingFluent<?> fluent) {
    this(fluent, new ZoneAwareLoadBalancerSetting());
  }
  
  public ZoneAwareLoadBalancerSettingBuilder(ZoneAwareLoadBalancerSetting instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ZoneAwareLoadBalancerSettingBuilder(ZoneAwareLoadBalancerSettingFluent<?> fluent,ZoneAwareLoadBalancerSetting instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ZoneAwareLoadBalancerSetting build() {
    ZoneAwareLoadBalancerSetting buildable = new ZoneAwareLoadBalancerSetting(fluent.getEnabled(), fluent.buildFailover(), fluent.getFailoverPriority(), fluent.getMinClusterSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}