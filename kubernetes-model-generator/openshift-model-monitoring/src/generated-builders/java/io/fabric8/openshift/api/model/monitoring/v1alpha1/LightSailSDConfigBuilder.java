package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LightSailSDConfigBuilder extends LightSailSDConfigFluent<LightSailSDConfigBuilder> implements VisitableBuilder<LightSailSDConfig,LightSailSDConfigBuilder>{

  LightSailSDConfigFluent<?> fluent;

  public LightSailSDConfigBuilder() {
    this(new LightSailSDConfig());
  }
  
  public LightSailSDConfigBuilder(LightSailSDConfigFluent<?> fluent) {
    this(fluent, new LightSailSDConfig());
  }
  
  public LightSailSDConfigBuilder(LightSailSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LightSailSDConfigBuilder(LightSailSDConfigFluent<?> fluent,LightSailSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LightSailSDConfig build() {
    LightSailSDConfig buildable = new LightSailSDConfig(fluent.getAccessKey(), fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getEnableHTTP2(), fluent.getEndpoint(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getRegion(), fluent.getRoleARN(), fluent.getSecretKey(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}