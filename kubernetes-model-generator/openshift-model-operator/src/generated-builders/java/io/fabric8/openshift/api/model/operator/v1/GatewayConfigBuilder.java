package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayConfigBuilder extends GatewayConfigFluent<GatewayConfigBuilder> implements VisitableBuilder<GatewayConfig,GatewayConfigBuilder>{

  GatewayConfigFluent<?> fluent;

  public GatewayConfigBuilder() {
    this(new GatewayConfig());
  }
  
  public GatewayConfigBuilder(GatewayConfigFluent<?> fluent) {
    this(fluent, new GatewayConfig());
  }
  
  public GatewayConfigBuilder(GatewayConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayConfigBuilder(GatewayConfigFluent<?> fluent,GatewayConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayConfig build() {
    GatewayConfig buildable = new GatewayConfig(fluent.getIpForwarding(), fluent.buildIpv4(), fluent.buildIpv6(), fluent.getRoutingViaHost());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}