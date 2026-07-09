package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UDPRouteStatusBuilder extends UDPRouteStatusFluent<UDPRouteStatusBuilder> implements VisitableBuilder<UDPRouteStatus,UDPRouteStatusBuilder>{

  UDPRouteStatusFluent<?> fluent;

  public UDPRouteStatusBuilder() {
    this(new UDPRouteStatus());
  }
  
  public UDPRouteStatusBuilder(UDPRouteStatusFluent<?> fluent) {
    this(fluent, new UDPRouteStatus());
  }
  
  public UDPRouteStatusBuilder(UDPRouteStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UDPRouteStatusBuilder(UDPRouteStatusFluent<?> fluent,UDPRouteStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UDPRouteStatus build() {
    UDPRouteStatus buildable = new UDPRouteStatus(fluent.buildParents());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}