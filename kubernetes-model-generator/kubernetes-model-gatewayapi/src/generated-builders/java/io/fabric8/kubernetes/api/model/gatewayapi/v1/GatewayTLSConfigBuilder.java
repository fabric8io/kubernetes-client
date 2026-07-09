package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayTLSConfigBuilder extends GatewayTLSConfigFluent<GatewayTLSConfigBuilder> implements VisitableBuilder<GatewayTLSConfig,GatewayTLSConfigBuilder>{

  GatewayTLSConfigFluent<?> fluent;

  public GatewayTLSConfigBuilder() {
    this(new GatewayTLSConfig());
  }
  
  public GatewayTLSConfigBuilder(GatewayTLSConfigFluent<?> fluent) {
    this(fluent, new GatewayTLSConfig());
  }
  
  public GatewayTLSConfigBuilder(GatewayTLSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayTLSConfigBuilder(GatewayTLSConfigFluent<?> fluent,GatewayTLSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayTLSConfig build() {
    GatewayTLSConfig buildable = new GatewayTLSConfig(fluent.buildBackend(), fluent.buildFrontend());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}