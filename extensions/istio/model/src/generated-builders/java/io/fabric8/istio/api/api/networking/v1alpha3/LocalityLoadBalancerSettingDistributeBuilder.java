package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalityLoadBalancerSettingDistributeBuilder extends LocalityLoadBalancerSettingDistributeFluent<LocalityLoadBalancerSettingDistributeBuilder> implements VisitableBuilder<LocalityLoadBalancerSettingDistribute,LocalityLoadBalancerSettingDistributeBuilder>{

  LocalityLoadBalancerSettingDistributeFluent<?> fluent;

  public LocalityLoadBalancerSettingDistributeBuilder() {
    this(new LocalityLoadBalancerSettingDistribute());
  }
  
  public LocalityLoadBalancerSettingDistributeBuilder(LocalityLoadBalancerSettingDistributeFluent<?> fluent) {
    this(fluent, new LocalityLoadBalancerSettingDistribute());
  }
  
  public LocalityLoadBalancerSettingDistributeBuilder(LocalityLoadBalancerSettingDistribute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalityLoadBalancerSettingDistributeBuilder(LocalityLoadBalancerSettingDistributeFluent<?> fluent,LocalityLoadBalancerSettingDistribute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalityLoadBalancerSettingDistribute build() {
    LocalityLoadBalancerSettingDistribute buildable = new LocalityLoadBalancerSettingDistribute(fluent.getFrom(), fluent.getTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}