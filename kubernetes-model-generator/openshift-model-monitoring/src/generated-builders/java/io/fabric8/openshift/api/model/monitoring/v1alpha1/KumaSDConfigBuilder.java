package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KumaSDConfigBuilder extends KumaSDConfigFluent<KumaSDConfigBuilder> implements VisitableBuilder<KumaSDConfig,KumaSDConfigBuilder>{

  KumaSDConfigFluent<?> fluent;

  public KumaSDConfigBuilder() {
    this(new KumaSDConfig());
  }
  
  public KumaSDConfigBuilder(KumaSDConfigFluent<?> fluent) {
    this(fluent, new KumaSDConfig());
  }
  
  public KumaSDConfigBuilder(KumaSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KumaSDConfigBuilder(KumaSDConfigFluent<?> fluent,KumaSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KumaSDConfig build() {
    KumaSDConfig buildable = new KumaSDConfig(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getClientID(), fluent.getEnableHTTP2(), fluent.getFetchTimeout(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getServer(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}