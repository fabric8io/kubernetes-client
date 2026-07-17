package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DockerSDConfigBuilder extends DockerSDConfigFluent<DockerSDConfigBuilder> implements VisitableBuilder<DockerSDConfig,DockerSDConfigBuilder>{

  DockerSDConfigFluent<?> fluent;

  public DockerSDConfigBuilder() {
    this(new DockerSDConfig());
  }
  
  public DockerSDConfigBuilder(DockerSDConfigFluent<?> fluent) {
    this(fluent, new DockerSDConfig());
  }
  
  public DockerSDConfigBuilder(DockerSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DockerSDConfigBuilder(DockerSDConfigFluent<?> fluent,DockerSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DockerSDConfig build() {
    DockerSDConfig buildable = new DockerSDConfig(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getEnableHTTP2(), fluent.buildFilters(), fluent.getFollowRedirects(), fluent.getHost(), fluent.getHostNetworkingHost(), fluent.getMatchFirstNetwork(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}