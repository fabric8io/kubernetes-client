package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCRouteStatusBuilder extends GRPCRouteStatusFluent<GRPCRouteStatusBuilder> implements VisitableBuilder<GRPCRouteStatus,GRPCRouteStatusBuilder>{

  GRPCRouteStatusFluent<?> fluent;

  public GRPCRouteStatusBuilder() {
    this(new GRPCRouteStatus());
  }
  
  public GRPCRouteStatusBuilder(GRPCRouteStatusFluent<?> fluent) {
    this(fluent, new GRPCRouteStatus());
  }
  
  public GRPCRouteStatusBuilder(GRPCRouteStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCRouteStatusBuilder(GRPCRouteStatusFluent<?> fluent,GRPCRouteStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCRouteStatus build() {
    GRPCRouteStatus buildable = new GRPCRouteStatus(fluent.buildParents());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}