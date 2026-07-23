package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSRouteListBuilder extends TLSRouteListFluent<TLSRouteListBuilder> implements VisitableBuilder<TLSRouteList,TLSRouteListBuilder>{

  TLSRouteListFluent<?> fluent;

  public TLSRouteListBuilder() {
    this(new TLSRouteList());
  }
  
  public TLSRouteListBuilder(TLSRouteListFluent<?> fluent) {
    this(fluent, new TLSRouteList());
  }
  
  public TLSRouteListBuilder(TLSRouteList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSRouteListBuilder(TLSRouteListFluent<?> fluent,TLSRouteList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSRouteList build() {
    TLSRouteList buildable = new TLSRouteList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}