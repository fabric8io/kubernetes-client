package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UDPRouteSpecBuilder extends UDPRouteSpecFluent<UDPRouteSpecBuilder> implements VisitableBuilder<UDPRouteSpec,UDPRouteSpecBuilder>{

  UDPRouteSpecFluent<?> fluent;

  public UDPRouteSpecBuilder() {
    this(new UDPRouteSpec());
  }
  
  public UDPRouteSpecBuilder(UDPRouteSpecFluent<?> fluent) {
    this(fluent, new UDPRouteSpec());
  }
  
  public UDPRouteSpecBuilder(UDPRouteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UDPRouteSpecBuilder(UDPRouteSpecFluent<?> fluent,UDPRouteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UDPRouteSpec build() {
    UDPRouteSpec buildable = new UDPRouteSpec(fluent.buildParentRefs(), fluent.buildRules(), fluent.getUseDefaultGateways());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}