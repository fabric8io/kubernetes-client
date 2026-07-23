package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPv4GatewayConfigBuilder extends IPv4GatewayConfigFluent<IPv4GatewayConfigBuilder> implements VisitableBuilder<IPv4GatewayConfig,IPv4GatewayConfigBuilder>{

  IPv4GatewayConfigFluent<?> fluent;

  public IPv4GatewayConfigBuilder() {
    this(new IPv4GatewayConfig());
  }
  
  public IPv4GatewayConfigBuilder(IPv4GatewayConfigFluent<?> fluent) {
    this(fluent, new IPv4GatewayConfig());
  }
  
  public IPv4GatewayConfigBuilder(IPv4GatewayConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPv4GatewayConfigBuilder(IPv4GatewayConfigFluent<?> fluent,IPv4GatewayConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPv4GatewayConfig build() {
    IPv4GatewayConfig buildable = new IPv4GatewayConfig(fluent.getInternalMasqueradeSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}