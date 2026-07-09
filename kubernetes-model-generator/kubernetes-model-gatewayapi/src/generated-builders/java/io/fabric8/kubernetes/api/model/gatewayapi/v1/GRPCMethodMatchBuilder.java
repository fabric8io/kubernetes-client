package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCMethodMatchBuilder extends GRPCMethodMatchFluent<GRPCMethodMatchBuilder> implements VisitableBuilder<GRPCMethodMatch,GRPCMethodMatchBuilder>{

  GRPCMethodMatchFluent<?> fluent;

  public GRPCMethodMatchBuilder() {
    this(new GRPCMethodMatch());
  }
  
  public GRPCMethodMatchBuilder(GRPCMethodMatchFluent<?> fluent) {
    this(fluent, new GRPCMethodMatch());
  }
  
  public GRPCMethodMatchBuilder(GRPCMethodMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCMethodMatchBuilder(GRPCMethodMatchFluent<?> fluent,GRPCMethodMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCMethodMatch build() {
    GRPCMethodMatch buildable = new GRPCMethodMatch(fluent.getMethod(), fluent.getService(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}