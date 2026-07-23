package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayStatusAddressBuilder extends GatewayStatusAddressFluent<GatewayStatusAddressBuilder> implements VisitableBuilder<GatewayStatusAddress,GatewayStatusAddressBuilder>{

  GatewayStatusAddressFluent<?> fluent;

  public GatewayStatusAddressBuilder() {
    this(new GatewayStatusAddress());
  }
  
  public GatewayStatusAddressBuilder(GatewayStatusAddressFluent<?> fluent) {
    this(fluent, new GatewayStatusAddress());
  }
  
  public GatewayStatusAddressBuilder(GatewayStatusAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayStatusAddressBuilder(GatewayStatusAddressFluent<?> fluent,GatewayStatusAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayStatusAddress build() {
    GatewayStatusAddress buildable = new GatewayStatusAddress(fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}