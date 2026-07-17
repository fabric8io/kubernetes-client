package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubernetesSDConfigBuilder extends KubernetesSDConfigFluent<KubernetesSDConfigBuilder> implements VisitableBuilder<KubernetesSDConfig,KubernetesSDConfigBuilder>{

  KubernetesSDConfigFluent<?> fluent;

  public KubernetesSDConfigBuilder() {
    this(new KubernetesSDConfig());
  }
  
  public KubernetesSDConfigBuilder(KubernetesSDConfigFluent<?> fluent) {
    this(fluent, new KubernetesSDConfig());
  }
  
  public KubernetesSDConfigBuilder(KubernetesSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubernetesSDConfigBuilder(KubernetesSDConfigFluent<?> fluent,KubernetesSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubernetesSDConfig build() {
    KubernetesSDConfig buildable = new KubernetesSDConfig(fluent.getApiServer(), fluent.buildAttachMetadata(), fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.buildNamespaces(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRole(), fluent.buildSelectors(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}