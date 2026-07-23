package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DigitalOceanSDConfigBuilder extends DigitalOceanSDConfigFluent<DigitalOceanSDConfigBuilder> implements VisitableBuilder<DigitalOceanSDConfig,DigitalOceanSDConfigBuilder>{

  DigitalOceanSDConfigFluent<?> fluent;

  public DigitalOceanSDConfigBuilder() {
    this(new DigitalOceanSDConfig());
  }
  
  public DigitalOceanSDConfigBuilder(DigitalOceanSDConfigFluent<?> fluent) {
    this(fluent, new DigitalOceanSDConfig());
  }
  
  public DigitalOceanSDConfigBuilder(DigitalOceanSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DigitalOceanSDConfigBuilder(DigitalOceanSDConfigFluent<?> fluent,DigitalOceanSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DigitalOceanSDConfig build() {
    DigitalOceanSDConfig buildable = new DigitalOceanSDConfig(fluent.buildAuthorization(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}