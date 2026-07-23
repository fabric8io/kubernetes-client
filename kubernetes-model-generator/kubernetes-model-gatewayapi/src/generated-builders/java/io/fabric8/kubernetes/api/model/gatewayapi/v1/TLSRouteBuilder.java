package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSRouteBuilder extends TLSRouteFluent<TLSRouteBuilder> implements VisitableBuilder<TLSRoute,TLSRouteBuilder>{

  TLSRouteFluent<?> fluent;

  public TLSRouteBuilder() {
    this(new TLSRoute());
  }
  
  public TLSRouteBuilder(TLSRouteFluent<?> fluent) {
    this(fluent, new TLSRoute());
  }
  
  public TLSRouteBuilder(TLSRoute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSRouteBuilder(TLSRouteFluent<?> fluent,TLSRoute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSRoute build() {
    TLSRoute buildable = new TLSRoute(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}