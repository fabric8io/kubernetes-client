package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRequestMirrorFilterBuilder extends HTTPRequestMirrorFilterFluent<HTTPRequestMirrorFilterBuilder> implements VisitableBuilder<HTTPRequestMirrorFilter,HTTPRequestMirrorFilterBuilder>{

  HTTPRequestMirrorFilterFluent<?> fluent;

  public HTTPRequestMirrorFilterBuilder() {
    this(new HTTPRequestMirrorFilter());
  }
  
  public HTTPRequestMirrorFilterBuilder(HTTPRequestMirrorFilterFluent<?> fluent) {
    this(fluent, new HTTPRequestMirrorFilter());
  }
  
  public HTTPRequestMirrorFilterBuilder(HTTPRequestMirrorFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRequestMirrorFilterBuilder(HTTPRequestMirrorFilterFluent<?> fluent,HTTPRequestMirrorFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRequestMirrorFilter build() {
    HTTPRequestMirrorFilter buildable = new HTTPRequestMirrorFilter(fluent.buildBackendRef(), fluent.buildFraction(), fluent.getPercent());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}