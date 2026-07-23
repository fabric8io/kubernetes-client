package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewaySpecAddressBuilder extends GatewaySpecAddressFluent<GatewaySpecAddressBuilder> implements VisitableBuilder<GatewaySpecAddress,GatewaySpecAddressBuilder>{

  GatewaySpecAddressFluent<?> fluent;

  public GatewaySpecAddressBuilder() {
    this(new GatewaySpecAddress());
  }
  
  public GatewaySpecAddressBuilder(GatewaySpecAddressFluent<?> fluent) {
    this(fluent, new GatewaySpecAddress());
  }
  
  public GatewaySpecAddressBuilder(GatewaySpecAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewaySpecAddressBuilder(GatewaySpecAddressFluent<?> fluent,GatewaySpecAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewaySpecAddress build() {
    GatewaySpecAddress buildable = new GatewaySpecAddress(fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}