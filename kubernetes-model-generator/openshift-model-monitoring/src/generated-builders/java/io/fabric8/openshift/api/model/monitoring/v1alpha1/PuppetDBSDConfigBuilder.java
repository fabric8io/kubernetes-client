package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PuppetDBSDConfigBuilder extends PuppetDBSDConfigFluent<PuppetDBSDConfigBuilder> implements VisitableBuilder<PuppetDBSDConfig,PuppetDBSDConfigBuilder>{

  PuppetDBSDConfigFluent<?> fluent;

  public PuppetDBSDConfigBuilder() {
    this(new PuppetDBSDConfig());
  }
  
  public PuppetDBSDConfigBuilder(PuppetDBSDConfigFluent<?> fluent) {
    this(fluent, new PuppetDBSDConfig());
  }
  
  public PuppetDBSDConfigBuilder(PuppetDBSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PuppetDBSDConfigBuilder(PuppetDBSDConfigFluent<?> fluent,PuppetDBSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PuppetDBSDConfig build() {
    PuppetDBSDConfig buildable = new PuppetDBSDConfig(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getIncludeParameters(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getQuery(), fluent.getRefreshInterval(), fluent.buildTlsConfig(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}