package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IonosSDConfigBuilder extends IonosSDConfigFluent<IonosSDConfigBuilder> implements VisitableBuilder<IonosSDConfig,IonosSDConfigBuilder>{

  IonosSDConfigFluent<?> fluent;

  public IonosSDConfigBuilder() {
    this(new IonosSDConfig());
  }
  
  public IonosSDConfigBuilder(IonosSDConfigFluent<?> fluent) {
    this(fluent, new IonosSDConfig());
  }
  
  public IonosSDConfigBuilder(IonosSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IonosSDConfigBuilder(IonosSDConfigFluent<?> fluent,IonosSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IonosSDConfig build() {
    IonosSDConfig buildable = new IonosSDConfig(fluent.buildAuthorization(), fluent.getDatacenterID(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}