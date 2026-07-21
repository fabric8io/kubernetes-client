package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPDirectResponseBuilder extends HTTPDirectResponseFluent<HTTPDirectResponseBuilder> implements VisitableBuilder<HTTPDirectResponse,HTTPDirectResponseBuilder>{

  HTTPDirectResponseFluent<?> fluent;

  public HTTPDirectResponseBuilder() {
    this(new HTTPDirectResponse());
  }
  
  public HTTPDirectResponseBuilder(HTTPDirectResponseFluent<?> fluent) {
    this(fluent, new HTTPDirectResponse());
  }
  
  public HTTPDirectResponseBuilder(HTTPDirectResponse instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPDirectResponseBuilder(HTTPDirectResponseFluent<?> fluent,HTTPDirectResponse instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPDirectResponse build() {
    HTTPDirectResponse buildable = new HTTPDirectResponse(fluent.buildBody(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}