package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NomadSDConfigBuilder extends NomadSDConfigFluent<NomadSDConfigBuilder> implements VisitableBuilder<NomadSDConfig,NomadSDConfigBuilder>{

  NomadSDConfigFluent<?> fluent;

  public NomadSDConfigBuilder() {
    this(new NomadSDConfig());
  }
  
  public NomadSDConfigBuilder(NomadSDConfigFluent<?> fluent) {
    this(fluent, new NomadSDConfig());
  }
  
  public NomadSDConfigBuilder(NomadSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NomadSDConfigBuilder(NomadSDConfigFluent<?> fluent,NomadSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NomadSDConfig build() {
    NomadSDConfig buildable = new NomadSDConfig(fluent.getAllowStale(), fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getNamespace(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getRegion(), fluent.getServer(), fluent.getTagSeparator(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}