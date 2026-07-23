package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCRouteBuilder extends GRPCRouteFluent<GRPCRouteBuilder> implements VisitableBuilder<GRPCRoute,GRPCRouteBuilder>{

  GRPCRouteFluent<?> fluent;

  public GRPCRouteBuilder() {
    this(new GRPCRoute());
  }
  
  public GRPCRouteBuilder(GRPCRouteFluent<?> fluent) {
    this(fluent, new GRPCRoute());
  }
  
  public GRPCRouteBuilder(GRPCRoute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCRouteBuilder(GRPCRouteFluent<?> fluent,GRPCRoute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCRoute build() {
    GRPCRoute buildable = new GRPCRoute(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}