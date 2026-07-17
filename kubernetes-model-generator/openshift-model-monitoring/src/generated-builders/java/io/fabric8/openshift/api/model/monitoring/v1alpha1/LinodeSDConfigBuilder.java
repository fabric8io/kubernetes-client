package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LinodeSDConfigBuilder extends LinodeSDConfigFluent<LinodeSDConfigBuilder> implements VisitableBuilder<LinodeSDConfig,LinodeSDConfigBuilder>{

  LinodeSDConfigFluent<?> fluent;

  public LinodeSDConfigBuilder() {
    this(new LinodeSDConfig());
  }
  
  public LinodeSDConfigBuilder(LinodeSDConfigFluent<?> fluent) {
    this(fluent, new LinodeSDConfig());
  }
  
  public LinodeSDConfigBuilder(LinodeSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LinodeSDConfigBuilder(LinodeSDConfigFluent<?> fluent,LinodeSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LinodeSDConfig build() {
    LinodeSDConfig buildable = new LinodeSDConfig(fluent.buildAuthorization(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getRegion(), fluent.getTagSeparator(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}