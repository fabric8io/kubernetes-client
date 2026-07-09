package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPBackendRefBuilder extends HTTPBackendRefFluent<HTTPBackendRefBuilder> implements VisitableBuilder<HTTPBackendRef,HTTPBackendRefBuilder>{

  HTTPBackendRefFluent<?> fluent;

  public HTTPBackendRefBuilder() {
    this(new HTTPBackendRef());
  }
  
  public HTTPBackendRefBuilder(HTTPBackendRefFluent<?> fluent) {
    this(fluent, new HTTPBackendRef());
  }
  
  public HTTPBackendRefBuilder(HTTPBackendRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPBackendRefBuilder(HTTPBackendRefFluent<?> fluent,HTTPBackendRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPBackendRef build() {
    HTTPBackendRef buildable = new HTTPBackendRef(fluent.buildFilters(), fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getPort(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}