package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPHeaderBuilder extends HTTPHeaderFluent<HTTPHeaderBuilder> implements VisitableBuilder<HTTPHeader,HTTPHeaderBuilder>{

  HTTPHeaderFluent<?> fluent;

  public HTTPHeaderBuilder() {
    this(new HTTPHeader());
  }
  
  public HTTPHeaderBuilder(HTTPHeaderFluent<?> fluent) {
    this(fluent, new HTTPHeader());
  }
  
  public HTTPHeaderBuilder(HTTPHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPHeaderBuilder(HTTPHeaderFluent<?> fluent,HTTPHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPHeader build() {
    HTTPHeader buildable = new HTTPHeader(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}