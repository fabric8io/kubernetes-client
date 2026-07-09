package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPPathMatchBuilder extends HTTPPathMatchFluent<HTTPPathMatchBuilder> implements VisitableBuilder<HTTPPathMatch,HTTPPathMatchBuilder>{

  HTTPPathMatchFluent<?> fluent;

  public HTTPPathMatchBuilder() {
    this(new HTTPPathMatch());
  }
  
  public HTTPPathMatchBuilder(HTTPPathMatchFluent<?> fluent) {
    this(fluent, new HTTPPathMatch());
  }
  
  public HTTPPathMatchBuilder(HTTPPathMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPPathMatchBuilder(HTTPPathMatchFluent<?> fluent,HTTPPathMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPPathMatch build() {
    HTTPPathMatch buildable = new HTTPPathMatch(fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}