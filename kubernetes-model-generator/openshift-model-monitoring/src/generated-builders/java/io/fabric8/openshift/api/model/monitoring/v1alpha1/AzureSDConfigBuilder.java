package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureSDConfigBuilder extends AzureSDConfigFluent<AzureSDConfigBuilder> implements VisitableBuilder<AzureSDConfig,AzureSDConfigBuilder>{

  AzureSDConfigFluent<?> fluent;

  public AzureSDConfigBuilder() {
    this(new AzureSDConfig());
  }
  
  public AzureSDConfigBuilder(AzureSDConfigFluent<?> fluent) {
    this(fluent, new AzureSDConfig());
  }
  
  public AzureSDConfigBuilder(AzureSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureSDConfigBuilder(AzureSDConfigFluent<?> fluent,AzureSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureSDConfig build() {
    AzureSDConfig buildable = new AzureSDConfig(fluent.getAuthenticationMethod(), fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getClientID(), fluent.getClientSecret(), fluent.getEnableHTTP2(), fluent.getEnvironment(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getResourceGroup(), fluent.getSubscriptionID(), fluent.getTenantID(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}