package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalityLoadBalancerSettingFailoverBuilder extends LocalityLoadBalancerSettingFailoverFluent<LocalityLoadBalancerSettingFailoverBuilder> implements VisitableBuilder<LocalityLoadBalancerSettingFailover,LocalityLoadBalancerSettingFailoverBuilder>{

  LocalityLoadBalancerSettingFailoverFluent<?> fluent;

  public LocalityLoadBalancerSettingFailoverBuilder() {
    this(new LocalityLoadBalancerSettingFailover());
  }
  
  public LocalityLoadBalancerSettingFailoverBuilder(LocalityLoadBalancerSettingFailoverFluent<?> fluent) {
    this(fluent, new LocalityLoadBalancerSettingFailover());
  }
  
  public LocalityLoadBalancerSettingFailoverBuilder(LocalityLoadBalancerSettingFailover instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalityLoadBalancerSettingFailoverBuilder(LocalityLoadBalancerSettingFailoverFluent<?> fluent,LocalityLoadBalancerSettingFailover instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalityLoadBalancerSettingFailover build() {
    LocalityLoadBalancerSettingFailover buildable = new LocalityLoadBalancerSettingFailover(fluent.getFrom(), fluent.getTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}