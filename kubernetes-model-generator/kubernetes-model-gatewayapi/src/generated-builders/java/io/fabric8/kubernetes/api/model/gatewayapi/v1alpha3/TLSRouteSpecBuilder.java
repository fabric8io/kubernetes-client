package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSRouteSpecBuilder extends TLSRouteSpecFluent<TLSRouteSpecBuilder> implements VisitableBuilder<TLSRouteSpec,TLSRouteSpecBuilder>{

  TLSRouteSpecFluent<?> fluent;

  public TLSRouteSpecBuilder() {
    this(new TLSRouteSpec());
  }
  
  public TLSRouteSpecBuilder(TLSRouteSpecFluent<?> fluent) {
    this(fluent, new TLSRouteSpec());
  }
  
  public TLSRouteSpecBuilder(TLSRouteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSRouteSpecBuilder(TLSRouteSpecFluent<?> fluent,TLSRouteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSRouteSpec build() {
    TLSRouteSpec buildable = new TLSRouteSpec(fluent.getHostnames(), fluent.buildParentRefs(), fluent.buildRules(), fluent.getUseDefaultGateways());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}