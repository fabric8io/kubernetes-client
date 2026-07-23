package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPSDConfigBuilder extends HTTPSDConfigFluent<HTTPSDConfigBuilder> implements VisitableBuilder<HTTPSDConfig,HTTPSDConfigBuilder>{

  HTTPSDConfigFluent<?> fluent;

  public HTTPSDConfigBuilder() {
    this(new HTTPSDConfig());
  }
  
  public HTTPSDConfigBuilder(HTTPSDConfigFluent<?> fluent) {
    this(fluent, new HTTPSDConfig());
  }
  
  public HTTPSDConfigBuilder(HTTPSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPSDConfigBuilder(HTTPSDConfigFluent<?> fluent,HTTPSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPSDConfig build() {
    HTTPSDConfig buildable = new HTTPSDConfig(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.buildTlsConfig(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}