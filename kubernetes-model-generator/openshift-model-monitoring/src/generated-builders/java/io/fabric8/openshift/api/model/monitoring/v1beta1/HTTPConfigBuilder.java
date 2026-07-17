package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPConfigBuilder extends HTTPConfigFluent<HTTPConfigBuilder> implements VisitableBuilder<HTTPConfig,HTTPConfigBuilder>{

  HTTPConfigFluent<?> fluent;

  public HTTPConfigBuilder() {
    this(new HTTPConfig());
  }
  
  public HTTPConfigBuilder(HTTPConfigFluent<?> fluent) {
    this(fluent, new HTTPConfig());
  }
  
  public HTTPConfigBuilder(HTTPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPConfigBuilder(HTTPConfigFluent<?> fluent,HTTPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPConfig build() {
    HTTPConfig buildable = new HTTPConfig(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerTokenSecret(), fluent.getEnableHttp2(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyURL(), fluent.getProxyUrl(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}