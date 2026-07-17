package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EurekaSDConfigBuilder extends EurekaSDConfigFluent<EurekaSDConfigBuilder> implements VisitableBuilder<EurekaSDConfig,EurekaSDConfigBuilder>{

  EurekaSDConfigFluent<?> fluent;

  public EurekaSDConfigBuilder() {
    this(new EurekaSDConfig());
  }
  
  public EurekaSDConfigBuilder(EurekaSDConfigFluent<?> fluent) {
    this(fluent, new EurekaSDConfig());
  }
  
  public EurekaSDConfigBuilder(EurekaSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EurekaSDConfigBuilder(EurekaSDConfigFluent<?> fluent,EurekaSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EurekaSDConfig build() {
    EurekaSDConfig buildable = new EurekaSDConfig(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getServer(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}