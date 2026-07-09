package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCRouteMatchBuilder extends GRPCRouteMatchFluent<GRPCRouteMatchBuilder> implements VisitableBuilder<GRPCRouteMatch,GRPCRouteMatchBuilder>{

  GRPCRouteMatchFluent<?> fluent;

  public GRPCRouteMatchBuilder() {
    this(new GRPCRouteMatch());
  }
  
  public GRPCRouteMatchBuilder(GRPCRouteMatchFluent<?> fluent) {
    this(fluent, new GRPCRouteMatch());
  }
  
  public GRPCRouteMatchBuilder(GRPCRouteMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCRouteMatchBuilder(GRPCRouteMatchFluent<?> fluent,GRPCRouteMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCRouteMatch build() {
    GRPCRouteMatch buildable = new GRPCRouteMatch(fluent.buildHeaders(), fluent.buildMethod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}