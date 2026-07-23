package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TCPRouteBuilder extends TCPRouteFluent<TCPRouteBuilder> implements VisitableBuilder<TCPRoute,TCPRouteBuilder>{

  TCPRouteFluent<?> fluent;

  public TCPRouteBuilder() {
    this(new TCPRoute());
  }
  
  public TCPRouteBuilder(TCPRouteFluent<?> fluent) {
    this(fluent, new TCPRoute());
  }
  
  public TCPRouteBuilder(TCPRoute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TCPRouteBuilder(TCPRouteFluent<?> fluent,TCPRoute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TCPRoute build() {
    TCPRoute buildable = new TCPRoute(fluent.buildMatch(), fluent.buildRoute());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}