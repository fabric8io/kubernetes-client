package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRedirectDerivePortBuilder extends HTTPRedirectDerivePortFluent<HTTPRedirectDerivePortBuilder> implements VisitableBuilder<HTTPRedirectDerivePort,HTTPRedirectDerivePortBuilder>{

  HTTPRedirectDerivePortFluent<?> fluent;

  public HTTPRedirectDerivePortBuilder() {
    this(new HTTPRedirectDerivePort());
  }
  
  public HTTPRedirectDerivePortBuilder(HTTPRedirectDerivePortFluent<?> fluent) {
    this(fluent, new HTTPRedirectDerivePort());
  }
  
  public HTTPRedirectDerivePortBuilder(HTTPRedirectDerivePort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRedirectDerivePortBuilder(HTTPRedirectDerivePortFluent<?> fluent,HTTPRedirectDerivePort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRedirectDerivePort build() {
    HTTPRedirectDerivePort buildable = new HTTPRedirectDerivePort(fluent.getDerivePort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}