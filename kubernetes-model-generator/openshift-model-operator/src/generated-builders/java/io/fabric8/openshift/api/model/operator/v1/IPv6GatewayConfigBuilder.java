package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPv6GatewayConfigBuilder extends IPv6GatewayConfigFluent<IPv6GatewayConfigBuilder> implements VisitableBuilder<IPv6GatewayConfig,IPv6GatewayConfigBuilder>{

  IPv6GatewayConfigFluent<?> fluent;

  public IPv6GatewayConfigBuilder() {
    this(new IPv6GatewayConfig());
  }
  
  public IPv6GatewayConfigBuilder(IPv6GatewayConfigFluent<?> fluent) {
    this(fluent, new IPv6GatewayConfig());
  }
  
  public IPv6GatewayConfigBuilder(IPv6GatewayConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPv6GatewayConfigBuilder(IPv6GatewayConfigFluent<?> fluent,IPv6GatewayConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPv6GatewayConfig build() {
    IPv6GatewayConfig buildable = new IPv6GatewayConfig(fluent.getInternalMasqueradeSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}