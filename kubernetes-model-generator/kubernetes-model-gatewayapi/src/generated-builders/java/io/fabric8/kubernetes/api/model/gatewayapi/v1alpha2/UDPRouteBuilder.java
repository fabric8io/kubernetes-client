package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UDPRouteBuilder extends UDPRouteFluent<UDPRouteBuilder> implements VisitableBuilder<UDPRoute,UDPRouteBuilder>{

  UDPRouteFluent<?> fluent;

  public UDPRouteBuilder() {
    this(new UDPRoute());
  }
  
  public UDPRouteBuilder(UDPRouteFluent<?> fluent) {
    this(fluent, new UDPRoute());
  }
  
  public UDPRouteBuilder(UDPRoute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UDPRouteBuilder(UDPRouteFluent<?> fluent,UDPRoute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UDPRoute build() {
    UDPRoute buildable = new UDPRoute(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}