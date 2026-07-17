package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPv6OVNKubernetesConfigBuilder extends IPv6OVNKubernetesConfigFluent<IPv6OVNKubernetesConfigBuilder> implements VisitableBuilder<IPv6OVNKubernetesConfig,IPv6OVNKubernetesConfigBuilder>{

  IPv6OVNKubernetesConfigFluent<?> fluent;

  public IPv6OVNKubernetesConfigBuilder() {
    this(new IPv6OVNKubernetesConfig());
  }
  
  public IPv6OVNKubernetesConfigBuilder(IPv6OVNKubernetesConfigFluent<?> fluent) {
    this(fluent, new IPv6OVNKubernetesConfig());
  }
  
  public IPv6OVNKubernetesConfigBuilder(IPv6OVNKubernetesConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPv6OVNKubernetesConfigBuilder(IPv6OVNKubernetesConfigFluent<?> fluent,IPv6OVNKubernetesConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPv6OVNKubernetesConfig build() {
    IPv6OVNKubernetesConfig buildable = new IPv6OVNKubernetesConfig(fluent.getInternalJoinSubnet(), fluent.getInternalTransitSwitchSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}