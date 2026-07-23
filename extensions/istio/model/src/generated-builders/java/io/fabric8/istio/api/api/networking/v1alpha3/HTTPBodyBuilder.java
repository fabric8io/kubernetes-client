package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPBodyBuilder extends HTTPBodyFluent<HTTPBodyBuilder> implements VisitableBuilder<HTTPBody,HTTPBodyBuilder>{

  HTTPBodyFluent<?> fluent;

  public HTTPBodyBuilder() {
    this(new HTTPBody());
  }
  
  public HTTPBodyBuilder(HTTPBodyFluent<?> fluent) {
    this(fluent, new HTTPBody());
  }
  
  public HTTPBodyBuilder(HTTPBody instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPBodyBuilder(HTTPBodyFluent<?> fluent,HTTPBody instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPBody build() {
    HTTPBody buildable = new HTTPBody(fluent.buildSpecifier());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}