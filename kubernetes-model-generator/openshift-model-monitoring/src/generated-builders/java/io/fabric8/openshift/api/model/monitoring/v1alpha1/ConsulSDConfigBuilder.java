package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsulSDConfigBuilder extends ConsulSDConfigFluent<ConsulSDConfigBuilder> implements VisitableBuilder<ConsulSDConfig,ConsulSDConfigBuilder>{

  ConsulSDConfigFluent<?> fluent;

  public ConsulSDConfigBuilder() {
    this(new ConsulSDConfig());
  }
  
  public ConsulSDConfigBuilder(ConsulSDConfigFluent<?> fluent) {
    this(fluent, new ConsulSDConfig());
  }
  
  public ConsulSDConfigBuilder(ConsulSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsulSDConfigBuilder(ConsulSDConfigFluent<?> fluent,ConsulSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsulSDConfig build() {
    ConsulSDConfig buildable = new ConsulSDConfig(fluent.getAllowStale(), fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getDatacenter(), fluent.getEnableHTTP2(), fluent.getFilter(), fluent.getFollowRedirects(), fluent.getHealthFilter(), fluent.getNamespace(), fluent.getNoProxy(), fluent.getNodeMeta(), fluent.buildOauth2(), fluent.getPartition(), fluent.getPathPrefix(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getScheme(), fluent.getServer(), fluent.getServices(), fluent.getTagSeparator(), fluent.getTags(), fluent.buildTlsConfig(), fluent.getTokenRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}