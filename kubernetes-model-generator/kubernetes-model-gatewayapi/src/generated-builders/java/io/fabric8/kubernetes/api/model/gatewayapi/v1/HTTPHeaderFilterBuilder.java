package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPHeaderFilterBuilder extends HTTPHeaderFilterFluent<HTTPHeaderFilterBuilder> implements VisitableBuilder<HTTPHeaderFilter,HTTPHeaderFilterBuilder>{

  HTTPHeaderFilterFluent<?> fluent;

  public HTTPHeaderFilterBuilder() {
    this(new HTTPHeaderFilter());
  }
  
  public HTTPHeaderFilterBuilder(HTTPHeaderFilterFluent<?> fluent) {
    this(fluent, new HTTPHeaderFilter());
  }
  
  public HTTPHeaderFilterBuilder(HTTPHeaderFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPHeaderFilterBuilder(HTTPHeaderFilterFluent<?> fluent,HTTPHeaderFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPHeaderFilter build() {
    HTTPHeaderFilter buildable = new HTTPHeaderFilter(fluent.buildAdd(), fluent.getRemove(), fluent.buildSet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}