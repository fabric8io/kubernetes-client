package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRequestRedirectFilterBuilder extends HTTPRequestRedirectFilterFluent<HTTPRequestRedirectFilterBuilder> implements VisitableBuilder<HTTPRequestRedirectFilter,HTTPRequestRedirectFilterBuilder>{

  HTTPRequestRedirectFilterFluent<?> fluent;

  public HTTPRequestRedirectFilterBuilder() {
    this(new HTTPRequestRedirectFilter());
  }
  
  public HTTPRequestRedirectFilterBuilder(HTTPRequestRedirectFilterFluent<?> fluent) {
    this(fluent, new HTTPRequestRedirectFilter());
  }
  
  public HTTPRequestRedirectFilterBuilder(HTTPRequestRedirectFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRequestRedirectFilterBuilder(HTTPRequestRedirectFilterFluent<?> fluent,HTTPRequestRedirectFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRequestRedirectFilter build() {
    HTTPRequestRedirectFilter buildable = new HTTPRequestRedirectFilter(fluent.getHostname(), fluent.buildPath(), fluent.getPort(), fluent.getScheme(), fluent.getStatusCode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}