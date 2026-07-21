package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRedirectBuilder extends HTTPRedirectFluent<HTTPRedirectBuilder> implements VisitableBuilder<HTTPRedirect,HTTPRedirectBuilder>{

  HTTPRedirectFluent<?> fluent;

  public HTTPRedirectBuilder() {
    this(new HTTPRedirect());
  }
  
  public HTTPRedirectBuilder(HTTPRedirectFluent<?> fluent) {
    this(fluent, new HTTPRedirect());
  }
  
  public HTTPRedirectBuilder(HTTPRedirect instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRedirectBuilder(HTTPRedirectFluent<?> fluent,HTTPRedirect instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRedirect build() {
    HTTPRedirect buildable = new HTTPRedirect(fluent.buildRedirectPort(), fluent.getAuthority(), fluent.getRedirectCode(), fluent.getScheme(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}