package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EC2SDConfigBuilder extends EC2SDConfigFluent<EC2SDConfigBuilder> implements VisitableBuilder<EC2SDConfig,EC2SDConfigBuilder>{

  EC2SDConfigFluent<?> fluent;

  public EC2SDConfigBuilder() {
    this(new EC2SDConfig());
  }
  
  public EC2SDConfigBuilder(EC2SDConfigFluent<?> fluent) {
    this(fluent, new EC2SDConfig());
  }
  
  public EC2SDConfigBuilder(EC2SDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EC2SDConfigBuilder(EC2SDConfigFluent<?> fluent,EC2SDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EC2SDConfig build() {
    EC2SDConfig buildable = new EC2SDConfig(fluent.getAccessKey(), fluent.getEnableHTTP2(), fluent.buildFilters(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getRegion(), fluent.getRoleARN(), fluent.getSecretKey(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}