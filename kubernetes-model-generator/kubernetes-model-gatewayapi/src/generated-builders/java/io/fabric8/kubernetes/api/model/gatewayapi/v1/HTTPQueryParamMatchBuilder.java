package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPQueryParamMatchBuilder extends HTTPQueryParamMatchFluent<HTTPQueryParamMatchBuilder> implements VisitableBuilder<HTTPQueryParamMatch,HTTPQueryParamMatchBuilder>{

  HTTPQueryParamMatchFluent<?> fluent;

  public HTTPQueryParamMatchBuilder() {
    this(new HTTPQueryParamMatch());
  }
  
  public HTTPQueryParamMatchBuilder(HTTPQueryParamMatchFluent<?> fluent) {
    this(fluent, new HTTPQueryParamMatch());
  }
  
  public HTTPQueryParamMatchBuilder(HTTPQueryParamMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPQueryParamMatchBuilder(HTTPQueryParamMatchFluent<?> fluent,HTTPQueryParamMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPQueryParamMatch build() {
    HTTPQueryParamMatch buildable = new HTTPQueryParamMatch(fluent.getName(), fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}