package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSRouteStatusBuilder extends TLSRouteStatusFluent<TLSRouteStatusBuilder> implements VisitableBuilder<TLSRouteStatus,TLSRouteStatusBuilder>{

  TLSRouteStatusFluent<?> fluent;

  public TLSRouteStatusBuilder() {
    this(new TLSRouteStatus());
  }
  
  public TLSRouteStatusBuilder(TLSRouteStatusFluent<?> fluent) {
    this(fluent, new TLSRouteStatus());
  }
  
  public TLSRouteStatusBuilder(TLSRouteStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSRouteStatusBuilder(TLSRouteStatusFluent<?> fluent,TLSRouteStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSRouteStatus build() {
    TLSRouteStatus buildable = new TLSRouteStatus(fluent.buildParents());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}