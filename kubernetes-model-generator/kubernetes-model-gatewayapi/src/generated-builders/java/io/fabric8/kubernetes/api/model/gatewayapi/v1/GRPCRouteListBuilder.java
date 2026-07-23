package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCRouteListBuilder extends GRPCRouteListFluent<GRPCRouteListBuilder> implements VisitableBuilder<GRPCRouteList,GRPCRouteListBuilder>{

  GRPCRouteListFluent<?> fluent;

  public GRPCRouteListBuilder() {
    this(new GRPCRouteList());
  }
  
  public GRPCRouteListBuilder(GRPCRouteListFluent<?> fluent) {
    this(fluent, new GRPCRouteList());
  }
  
  public GRPCRouteListBuilder(GRPCRouteList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCRouteListBuilder(GRPCRouteListFluent<?> fluent,GRPCRouteList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCRouteList build() {
    GRPCRouteList buildable = new GRPCRouteList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}