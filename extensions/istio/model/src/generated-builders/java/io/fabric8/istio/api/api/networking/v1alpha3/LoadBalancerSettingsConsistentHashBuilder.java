package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashBuilder extends LoadBalancerSettingsConsistentHashFluent<LoadBalancerSettingsConsistentHashBuilder> implements VisitableBuilder<LoadBalancerSettingsConsistentHash,LoadBalancerSettingsConsistentHashBuilder>{

  LoadBalancerSettingsConsistentHashFluent<?> fluent;

  public LoadBalancerSettingsConsistentHashBuilder() {
    this(new LoadBalancerSettingsConsistentHash());
  }
  
  public LoadBalancerSettingsConsistentHashBuilder(LoadBalancerSettingsConsistentHashFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHash());
  }
  
  public LoadBalancerSettingsConsistentHashBuilder(LoadBalancerSettingsConsistentHash instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashBuilder(LoadBalancerSettingsConsistentHashFluent<?> fluent,LoadBalancerSettingsConsistentHash instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHash build() {
    LoadBalancerSettingsConsistentHash buildable = new LoadBalancerSettingsConsistentHash(fluent.buildConsistentHash());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}