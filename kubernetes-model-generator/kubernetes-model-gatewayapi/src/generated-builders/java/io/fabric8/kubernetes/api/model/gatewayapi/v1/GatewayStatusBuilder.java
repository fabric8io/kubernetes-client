package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayStatusBuilder extends GatewayStatusFluent<GatewayStatusBuilder> implements VisitableBuilder<GatewayStatus,GatewayStatusBuilder>{

  GatewayStatusFluent<?> fluent;

  public GatewayStatusBuilder() {
    this(new GatewayStatus());
  }
  
  public GatewayStatusBuilder(GatewayStatusFluent<?> fluent) {
    this(fluent, new GatewayStatus());
  }
  
  public GatewayStatusBuilder(GatewayStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayStatusBuilder(GatewayStatusFluent<?> fluent,GatewayStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayStatus build() {
    GatewayStatus buildable = new GatewayStatus(fluent.buildAddresses(), fluent.getAttachedListenerSets(), fluent.getConditions(), fluent.buildListeners());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}