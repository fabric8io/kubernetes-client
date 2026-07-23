package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPMatchRequestBuilder extends HTTPMatchRequestFluent<HTTPMatchRequestBuilder> implements VisitableBuilder<HTTPMatchRequest,HTTPMatchRequestBuilder>{

  HTTPMatchRequestFluent<?> fluent;

  public HTTPMatchRequestBuilder() {
    this(new HTTPMatchRequest());
  }
  
  public HTTPMatchRequestBuilder(HTTPMatchRequestFluent<?> fluent) {
    this(fluent, new HTTPMatchRequest());
  }
  
  public HTTPMatchRequestBuilder(HTTPMatchRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPMatchRequestBuilder(HTTPMatchRequestFluent<?> fluent,HTTPMatchRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPMatchRequest build() {
    HTTPMatchRequest buildable = new HTTPMatchRequest(fluent.buildAuthority(), fluent.getGateways(), fluent.getHeaders(), fluent.getIgnoreUriCase(), fluent.buildMethod(), fluent.getName(), fluent.getPort(), fluent.getQueryParams(), fluent.buildScheme(), fluent.getSourceLabels(), fluent.getSourceNamespace(), fluent.getStatPrefix(), fluent.buildUri(), fluent.getWithoutHeaders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}