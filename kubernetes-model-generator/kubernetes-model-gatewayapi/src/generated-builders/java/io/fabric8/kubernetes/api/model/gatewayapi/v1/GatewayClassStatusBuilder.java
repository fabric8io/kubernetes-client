package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayClassStatusBuilder extends GatewayClassStatusFluent<GatewayClassStatusBuilder> implements VisitableBuilder<GatewayClassStatus,GatewayClassStatusBuilder>{

  GatewayClassStatusFluent<?> fluent;

  public GatewayClassStatusBuilder() {
    this(new GatewayClassStatus());
  }
  
  public GatewayClassStatusBuilder(GatewayClassStatusFluent<?> fluent) {
    this(fluent, new GatewayClassStatus());
  }
  
  public GatewayClassStatusBuilder(GatewayClassStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayClassStatusBuilder(GatewayClassStatusFluent<?> fluent,GatewayClassStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayClassStatus build() {
    GatewayClassStatus buildable = new GatewayClassStatus(fluent.getConditions(), fluent.buildSupportedFeatures());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}