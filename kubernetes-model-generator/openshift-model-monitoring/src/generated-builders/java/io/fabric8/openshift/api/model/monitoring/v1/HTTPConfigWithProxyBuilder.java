package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPConfigWithProxyBuilder extends HTTPConfigWithProxyFluent<HTTPConfigWithProxyBuilder> implements VisitableBuilder<HTTPConfigWithProxy,HTTPConfigWithProxyBuilder>{

  HTTPConfigWithProxyFluent<?> fluent;

  public HTTPConfigWithProxyBuilder() {
    this(new HTTPConfigWithProxy());
  }
  
  public HTTPConfigWithProxyBuilder(HTTPConfigWithProxyFluent<?> fluent) {
    this(fluent, new HTTPConfigWithProxy());
  }
  
  public HTTPConfigWithProxyBuilder(HTTPConfigWithProxy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPConfigWithProxyBuilder(HTTPConfigWithProxyFluent<?> fluent,HTTPConfigWithProxy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPConfigWithProxy build() {
    HTTPConfigWithProxy buildable = new HTTPConfigWithProxy(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerTokenSecret(), fluent.getEnableHttp2(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}