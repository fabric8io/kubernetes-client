package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TCPRouteStatusBuilder extends TCPRouteStatusFluent<TCPRouteStatusBuilder> implements VisitableBuilder<TCPRouteStatus,TCPRouteStatusBuilder>{

  TCPRouteStatusFluent<?> fluent;

  public TCPRouteStatusBuilder() {
    this(new TCPRouteStatus());
  }
  
  public TCPRouteStatusBuilder(TCPRouteStatusFluent<?> fluent) {
    this(fluent, new TCPRouteStatus());
  }
  
  public TCPRouteStatusBuilder(TCPRouteStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TCPRouteStatusBuilder(TCPRouteStatusFluent<?> fluent,TCPRouteStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TCPRouteStatus build() {
    TCPRouteStatus buildable = new TCPRouteStatus(fluent.buildParents());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}