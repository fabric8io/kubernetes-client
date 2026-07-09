package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayClassSpecBuilder extends GatewayClassSpecFluent<GatewayClassSpecBuilder> implements VisitableBuilder<GatewayClassSpec,GatewayClassSpecBuilder>{

  GatewayClassSpecFluent<?> fluent;

  public GatewayClassSpecBuilder() {
    this(new GatewayClassSpec());
  }
  
  public GatewayClassSpecBuilder(GatewayClassSpecFluent<?> fluent) {
    this(fluent, new GatewayClassSpec());
  }
  
  public GatewayClassSpecBuilder(GatewayClassSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayClassSpecBuilder(GatewayClassSpecFluent<?> fluent,GatewayClassSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayClassSpec build() {
    GatewayClassSpec buildable = new GatewayClassSpec(fluent.getControllerName(), fluent.getDescription(), fluent.buildParametersRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}