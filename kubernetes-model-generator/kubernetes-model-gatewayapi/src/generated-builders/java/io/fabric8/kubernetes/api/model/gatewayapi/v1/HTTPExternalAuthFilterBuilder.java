package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPExternalAuthFilterBuilder extends HTTPExternalAuthFilterFluent<HTTPExternalAuthFilterBuilder> implements VisitableBuilder<HTTPExternalAuthFilter,HTTPExternalAuthFilterBuilder>{

  HTTPExternalAuthFilterFluent<?> fluent;

  public HTTPExternalAuthFilterBuilder() {
    this(new HTTPExternalAuthFilter());
  }
  
  public HTTPExternalAuthFilterBuilder(HTTPExternalAuthFilterFluent<?> fluent) {
    this(fluent, new HTTPExternalAuthFilter());
  }
  
  public HTTPExternalAuthFilterBuilder(HTTPExternalAuthFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPExternalAuthFilterBuilder(HTTPExternalAuthFilterFluent<?> fluent,HTTPExternalAuthFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPExternalAuthFilter build() {
    HTTPExternalAuthFilter buildable = new HTTPExternalAuthFilter(fluent.buildBackendRef(), fluent.buildForwardBody(), fluent.buildGrpc(), fluent.buildHttp(), fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}