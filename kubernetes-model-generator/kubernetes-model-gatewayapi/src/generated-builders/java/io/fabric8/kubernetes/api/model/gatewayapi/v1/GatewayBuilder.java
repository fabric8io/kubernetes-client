package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayBuilder extends GatewayFluent<GatewayBuilder> implements VisitableBuilder<Gateway,GatewayBuilder>{

  GatewayFluent<?> fluent;

  public GatewayBuilder() {
    this(new Gateway());
  }
  
  public GatewayBuilder(GatewayFluent<?> fluent) {
    this(fluent, new Gateway());
  }
  
  public GatewayBuilder(Gateway instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayBuilder(GatewayFluent<?> fluent,Gateway instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Gateway build() {
    Gateway buildable = new Gateway(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}