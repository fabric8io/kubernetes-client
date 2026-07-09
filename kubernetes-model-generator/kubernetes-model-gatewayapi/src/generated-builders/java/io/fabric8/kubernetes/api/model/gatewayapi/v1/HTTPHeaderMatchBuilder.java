package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPHeaderMatchBuilder extends HTTPHeaderMatchFluent<HTTPHeaderMatchBuilder> implements VisitableBuilder<HTTPHeaderMatch,HTTPHeaderMatchBuilder>{

  HTTPHeaderMatchFluent<?> fluent;

  public HTTPHeaderMatchBuilder() {
    this(new HTTPHeaderMatch());
  }
  
  public HTTPHeaderMatchBuilder(HTTPHeaderMatchFluent<?> fluent) {
    this(fluent, new HTTPHeaderMatch());
  }
  
  public HTTPHeaderMatchBuilder(HTTPHeaderMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPHeaderMatchBuilder(HTTPHeaderMatchFluent<?> fluent,HTTPHeaderMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPHeaderMatch build() {
    HTTPHeaderMatch buildable = new HTTPHeaderMatch(fluent.getName(), fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}