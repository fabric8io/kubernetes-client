package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewaySpecBuilder extends GatewaySpecFluent<GatewaySpecBuilder> implements VisitableBuilder<GatewaySpec,GatewaySpecBuilder>{

  GatewaySpecFluent<?> fluent;

  public GatewaySpecBuilder() {
    this(new GatewaySpec());
  }
  
  public GatewaySpecBuilder(GatewaySpecFluent<?> fluent) {
    this(fluent, new GatewaySpec());
  }
  
  public GatewaySpecBuilder(GatewaySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewaySpecBuilder(GatewaySpecFluent<?> fluent,GatewaySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewaySpec build() {
    GatewaySpec buildable = new GatewaySpec(fluent.buildAddresses(), fluent.buildAllowedListeners(), fluent.getDefaultScope(), fluent.getGatewayClassName(), fluent.buildInfrastructure(), fluent.buildListeners(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}