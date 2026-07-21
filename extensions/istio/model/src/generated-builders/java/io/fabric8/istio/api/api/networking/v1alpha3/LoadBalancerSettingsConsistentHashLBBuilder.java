package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBBuilder extends LoadBalancerSettingsConsistentHashLBFluent<LoadBalancerSettingsConsistentHashLBBuilder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLB,LoadBalancerSettingsConsistentHashLBBuilder>{

  LoadBalancerSettingsConsistentHashLBFluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBBuilder() {
    this(new LoadBalancerSettingsConsistentHashLB());
  }
  
  public LoadBalancerSettingsConsistentHashLBBuilder(LoadBalancerSettingsConsistentHashLBFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLB());
  }
  
  public LoadBalancerSettingsConsistentHashLBBuilder(LoadBalancerSettingsConsistentHashLB instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBBuilder(LoadBalancerSettingsConsistentHashLBFluent<?> fluent,LoadBalancerSettingsConsistentHashLB instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLB build() {
    LoadBalancerSettingsConsistentHashLB buildable = new LoadBalancerSettingsConsistentHashLB(fluent.buildHashAlgorithm(), fluent.buildHashKey(), fluent.getMinimumRingSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}