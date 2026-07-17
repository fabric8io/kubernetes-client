package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPConfigWithoutTLSBuilder extends HTTPConfigWithoutTLSFluent<HTTPConfigWithoutTLSBuilder> implements VisitableBuilder<HTTPConfigWithoutTLS,HTTPConfigWithoutTLSBuilder>{

  HTTPConfigWithoutTLSFluent<?> fluent;

  public HTTPConfigWithoutTLSBuilder() {
    this(new HTTPConfigWithoutTLS());
  }
  
  public HTTPConfigWithoutTLSBuilder(HTTPConfigWithoutTLSFluent<?> fluent) {
    this(fluent, new HTTPConfigWithoutTLS());
  }
  
  public HTTPConfigWithoutTLSBuilder(HTTPConfigWithoutTLS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPConfigWithoutTLSBuilder(HTTPConfigWithoutTLSFluent<?> fluent,HTTPConfigWithoutTLS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPConfigWithoutTLS build() {
    HTTPConfigWithoutTLS buildable = new HTTPConfigWithoutTLS(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerTokenSecret(), fluent.getEnableHttp2(), fluent.getFollowRedirects(), fluent.buildOauth2());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}