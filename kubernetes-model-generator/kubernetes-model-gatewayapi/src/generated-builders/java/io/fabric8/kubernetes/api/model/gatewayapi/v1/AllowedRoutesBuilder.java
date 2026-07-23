package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllowedRoutesBuilder extends AllowedRoutesFluent<AllowedRoutesBuilder> implements VisitableBuilder<AllowedRoutes,AllowedRoutesBuilder>{

  AllowedRoutesFluent<?> fluent;

  public AllowedRoutesBuilder() {
    this(new AllowedRoutes());
  }
  
  public AllowedRoutesBuilder(AllowedRoutesFluent<?> fluent) {
    this(fluent, new AllowedRoutes());
  }
  
  public AllowedRoutesBuilder(AllowedRoutes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllowedRoutesBuilder(AllowedRoutesFluent<?> fluent,AllowedRoutes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllowedRoutes build() {
    AllowedRoutes buildable = new AllowedRoutes(fluent.buildKinds(), fluent.buildNamespaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}