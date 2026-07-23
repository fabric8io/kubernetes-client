package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HetznerSDConfigBuilder extends HetznerSDConfigFluent<HetznerSDConfigBuilder> implements VisitableBuilder<HetznerSDConfig,HetznerSDConfigBuilder>{

  HetznerSDConfigFluent<?> fluent;

  public HetznerSDConfigBuilder() {
    this(new HetznerSDConfig());
  }
  
  public HetznerSDConfigBuilder(HetznerSDConfigFluent<?> fluent) {
    this(fluent, new HetznerSDConfig());
  }
  
  public HetznerSDConfigBuilder(HetznerSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HetznerSDConfigBuilder(HetznerSDConfigFluent<?> fluent,HetznerSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HetznerSDConfig build() {
    HetznerSDConfig buildable = new HetznerSDConfig(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getLabelSelector(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getRole(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}