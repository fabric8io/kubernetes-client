package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPCORSFilterBuilder extends HTTPCORSFilterFluent<HTTPCORSFilterBuilder> implements VisitableBuilder<HTTPCORSFilter,HTTPCORSFilterBuilder>{

  HTTPCORSFilterFluent<?> fluent;

  public HTTPCORSFilterBuilder() {
    this(new HTTPCORSFilter());
  }
  
  public HTTPCORSFilterBuilder(HTTPCORSFilterFluent<?> fluent) {
    this(fluent, new HTTPCORSFilter());
  }
  
  public HTTPCORSFilterBuilder(HTTPCORSFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPCORSFilterBuilder(HTTPCORSFilterFluent<?> fluent,HTTPCORSFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPCORSFilter build() {
    HTTPCORSFilter buildable = new HTTPCORSFilter(fluent.getAllowCredentials(), fluent.getAllowHeaders(), fluent.getAllowMethods(), fluent.getAllowOrigins(), fluent.getExposeHeaders(), fluent.getMaxAge());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}