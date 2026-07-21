package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HeadersBuilder extends HeadersFluent<HeadersBuilder> implements VisitableBuilder<Headers,HeadersBuilder>{

  HeadersFluent<?> fluent;

  public HeadersBuilder() {
    this(new Headers());
  }
  
  public HeadersBuilder(HeadersFluent<?> fluent) {
    this(fluent, new Headers());
  }
  
  public HeadersBuilder(Headers instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HeadersBuilder(HeadersFluent<?> fluent,Headers instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Headers build() {
    Headers buildable = new Headers(fluent.buildRequest(), fluent.buildResponse());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}