package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalityLoadBalancerSettingBuilder extends LocalityLoadBalancerSettingFluent<LocalityLoadBalancerSettingBuilder> implements VisitableBuilder<LocalityLoadBalancerSetting,LocalityLoadBalancerSettingBuilder>{

  LocalityLoadBalancerSettingFluent<?> fluent;

  public LocalityLoadBalancerSettingBuilder() {
    this(new LocalityLoadBalancerSetting());
  }
  
  public LocalityLoadBalancerSettingBuilder(LocalityLoadBalancerSettingFluent<?> fluent) {
    this(fluent, new LocalityLoadBalancerSetting());
  }
  
  public LocalityLoadBalancerSettingBuilder(LocalityLoadBalancerSetting instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalityLoadBalancerSettingBuilder(LocalityLoadBalancerSettingFluent<?> fluent,LocalityLoadBalancerSetting instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalityLoadBalancerSetting build() {
    LocalityLoadBalancerSetting buildable = new LocalityLoadBalancerSetting(fluent.buildDistribute(), fluent.getEnabled(), fluent.buildFailover(), fluent.getFailoverPriority());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}