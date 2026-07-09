package io.fabric8.kubernetes.api.model.gatewayapi.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayClassBuilder extends GatewayClassFluent<GatewayClassBuilder> implements VisitableBuilder<GatewayClass,GatewayClassBuilder>{

  GatewayClassFluent<?> fluent;

  public GatewayClassBuilder() {
    this(new GatewayClass());
  }
  
  public GatewayClassBuilder(GatewayClassFluent<?> fluent) {
    this(fluent, new GatewayClass());
  }
  
  public GatewayClassBuilder(GatewayClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayClassBuilder(GatewayClassFluent<?> fluent,GatewayClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayClass build() {
    GatewayClass buildable = new GatewayClass(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}