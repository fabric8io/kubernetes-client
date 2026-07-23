package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPv4OVNKubernetesConfigBuilder extends IPv4OVNKubernetesConfigFluent<IPv4OVNKubernetesConfigBuilder> implements VisitableBuilder<IPv4OVNKubernetesConfig,IPv4OVNKubernetesConfigBuilder>{

  IPv4OVNKubernetesConfigFluent<?> fluent;

  public IPv4OVNKubernetesConfigBuilder() {
    this(new IPv4OVNKubernetesConfig());
  }
  
  public IPv4OVNKubernetesConfigBuilder(IPv4OVNKubernetesConfigFluent<?> fluent) {
    this(fluent, new IPv4OVNKubernetesConfig());
  }
  
  public IPv4OVNKubernetesConfigBuilder(IPv4OVNKubernetesConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPv4OVNKubernetesConfigBuilder(IPv4OVNKubernetesConfigFluent<?> fluent,IPv4OVNKubernetesConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPv4OVNKubernetesConfig build() {
    IPv4OVNKubernetesConfig buildable = new IPv4OVNKubernetesConfig(fluent.getInternalJoinSubnet(), fluent.getInternalTransitSwitchSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}