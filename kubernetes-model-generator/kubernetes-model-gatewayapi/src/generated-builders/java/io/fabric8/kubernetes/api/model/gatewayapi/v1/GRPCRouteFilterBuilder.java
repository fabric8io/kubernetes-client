package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCRouteFilterBuilder extends GRPCRouteFilterFluent<GRPCRouteFilterBuilder> implements VisitableBuilder<GRPCRouteFilter,GRPCRouteFilterBuilder>{

  GRPCRouteFilterFluent<?> fluent;

  public GRPCRouteFilterBuilder() {
    this(new GRPCRouteFilter());
  }
  
  public GRPCRouteFilterBuilder(GRPCRouteFilterFluent<?> fluent) {
    this(fluent, new GRPCRouteFilter());
  }
  
  public GRPCRouteFilterBuilder(GRPCRouteFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCRouteFilterBuilder(GRPCRouteFilterFluent<?> fluent,GRPCRouteFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCRouteFilter build() {
    GRPCRouteFilter buildable = new GRPCRouteFilter(fluent.buildExtensionRef(), fluent.buildRequestHeaderModifier(), fluent.buildRequestMirror(), fluent.buildResponseHeaderModifier(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}