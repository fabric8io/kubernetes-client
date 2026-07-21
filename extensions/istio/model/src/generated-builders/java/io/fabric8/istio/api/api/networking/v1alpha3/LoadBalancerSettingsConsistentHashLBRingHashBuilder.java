package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBRingHashBuilder extends LoadBalancerSettingsConsistentHashLBRingHashFluent<LoadBalancerSettingsConsistentHashLBRingHashBuilder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLBRingHash,LoadBalancerSettingsConsistentHashLBRingHashBuilder>{

  LoadBalancerSettingsConsistentHashLBRingHashFluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBRingHashBuilder() {
    this(new LoadBalancerSettingsConsistentHashLBRingHash());
  }
  
  public LoadBalancerSettingsConsistentHashLBRingHashBuilder(LoadBalancerSettingsConsistentHashLBRingHashFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLBRingHash());
  }
  
  public LoadBalancerSettingsConsistentHashLBRingHashBuilder(LoadBalancerSettingsConsistentHashLBRingHash instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBRingHashBuilder(LoadBalancerSettingsConsistentHashLBRingHashFluent<?> fluent,LoadBalancerSettingsConsistentHashLBRingHash instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLBRingHash build() {
    LoadBalancerSettingsConsistentHashLBRingHash buildable = new LoadBalancerSettingsConsistentHashLBRingHash(fluent.buildRingHash());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}