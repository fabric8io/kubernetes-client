package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRedirectPortBuilder extends HTTPRedirectPortFluent<HTTPRedirectPortBuilder> implements VisitableBuilder<HTTPRedirectPort,HTTPRedirectPortBuilder>{

  HTTPRedirectPortFluent<?> fluent;

  public HTTPRedirectPortBuilder() {
    this(new HTTPRedirectPort());
  }
  
  public HTTPRedirectPortBuilder(HTTPRedirectPortFluent<?> fluent) {
    this(fluent, new HTTPRedirectPort());
  }
  
  public HTTPRedirectPortBuilder(HTTPRedirectPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRedirectPortBuilder(HTTPRedirectPortFluent<?> fluent,HTTPRedirectPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRedirectPort build() {
    HTTPRedirectPort buildable = new HTTPRedirectPort(fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}