package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPBodyBytesBuilder extends HTTPBodyBytesFluent<HTTPBodyBytesBuilder> implements VisitableBuilder<HTTPBodyBytes,HTTPBodyBytesBuilder>{

  HTTPBodyBytesFluent<?> fluent;

  public HTTPBodyBytesBuilder() {
    this(new HTTPBodyBytes());
  }
  
  public HTTPBodyBytesBuilder(HTTPBodyBytesFluent<?> fluent) {
    this(fluent, new HTTPBodyBytes());
  }
  
  public HTTPBodyBytesBuilder(HTTPBodyBytes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPBodyBytesBuilder(HTTPBodyBytesFluent<?> fluent,HTTPBodyBytes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPBodyBytes build() {
    HTTPBodyBytes buildable = new HTTPBodyBytes(fluent.getBytes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}