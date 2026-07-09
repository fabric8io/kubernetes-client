package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteSpecBuilder extends HTTPRouteSpecFluent<HTTPRouteSpecBuilder> implements VisitableBuilder<HTTPRouteSpec,HTTPRouteSpecBuilder>{

  HTTPRouteSpecFluent<?> fluent;

  public HTTPRouteSpecBuilder() {
    this(new HTTPRouteSpec());
  }
  
  public HTTPRouteSpecBuilder(HTTPRouteSpecFluent<?> fluent) {
    this(fluent, new HTTPRouteSpec());
  }
  
  public HTTPRouteSpecBuilder(HTTPRouteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteSpecBuilder(HTTPRouteSpecFluent<?> fluent,HTTPRouteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRouteSpec build() {
    HTTPRouteSpec buildable = new HTTPRouteSpec(fluent.getHostnames(), fluent.buildParentRefs(), fluent.buildRules(), fluent.getUseDefaultGateways());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}