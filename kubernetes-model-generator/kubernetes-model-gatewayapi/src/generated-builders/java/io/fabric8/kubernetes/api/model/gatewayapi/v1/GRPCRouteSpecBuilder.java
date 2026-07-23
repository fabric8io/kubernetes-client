package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCRouteSpecBuilder extends GRPCRouteSpecFluent<GRPCRouteSpecBuilder> implements VisitableBuilder<GRPCRouteSpec,GRPCRouteSpecBuilder>{

  GRPCRouteSpecFluent<?> fluent;

  public GRPCRouteSpecBuilder() {
    this(new GRPCRouteSpec());
  }
  
  public GRPCRouteSpecBuilder(GRPCRouteSpecFluent<?> fluent) {
    this(fluent, new GRPCRouteSpec());
  }
  
  public GRPCRouteSpecBuilder(GRPCRouteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCRouteSpecBuilder(GRPCRouteSpecFluent<?> fluent,GRPCRouteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCRouteSpec build() {
    GRPCRouteSpec buildable = new GRPCRouteSpec(fluent.getHostnames(), fluent.buildParentRefs(), fluent.buildRules(), fluent.getUseDefaultGateways());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}