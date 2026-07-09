package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCAuthConfigBuilder extends GRPCAuthConfigFluent<GRPCAuthConfigBuilder> implements VisitableBuilder<GRPCAuthConfig,GRPCAuthConfigBuilder>{

  GRPCAuthConfigFluent<?> fluent;

  public GRPCAuthConfigBuilder() {
    this(new GRPCAuthConfig());
  }
  
  public GRPCAuthConfigBuilder(GRPCAuthConfigFluent<?> fluent) {
    this(fluent, new GRPCAuthConfig());
  }
  
  public GRPCAuthConfigBuilder(GRPCAuthConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCAuthConfigBuilder(GRPCAuthConfigFluent<?> fluent,GRPCAuthConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCAuthConfig build() {
    GRPCAuthConfig buildable = new GRPCAuthConfig(fluent.getAllowedHeaders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}