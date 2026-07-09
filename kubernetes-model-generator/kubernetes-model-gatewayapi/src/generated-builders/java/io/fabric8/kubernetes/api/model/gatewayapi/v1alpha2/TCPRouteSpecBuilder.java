package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TCPRouteSpecBuilder extends TCPRouteSpecFluent<TCPRouteSpecBuilder> implements VisitableBuilder<TCPRouteSpec,TCPRouteSpecBuilder>{

  TCPRouteSpecFluent<?> fluent;

  public TCPRouteSpecBuilder() {
    this(new TCPRouteSpec());
  }
  
  public TCPRouteSpecBuilder(TCPRouteSpecFluent<?> fluent) {
    this(fluent, new TCPRouteSpec());
  }
  
  public TCPRouteSpecBuilder(TCPRouteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TCPRouteSpecBuilder(TCPRouteSpecFluent<?> fluent,TCPRouteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TCPRouteSpec build() {
    TCPRouteSpec buildable = new TCPRouteSpec(fluent.buildParentRefs(), fluent.buildRules(), fluent.getUseDefaultGateways());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}