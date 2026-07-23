package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DockerSwarmSDConfigBuilder extends DockerSwarmSDConfigFluent<DockerSwarmSDConfigBuilder> implements VisitableBuilder<DockerSwarmSDConfig,DockerSwarmSDConfigBuilder>{

  DockerSwarmSDConfigFluent<?> fluent;

  public DockerSwarmSDConfigBuilder() {
    this(new DockerSwarmSDConfig());
  }
  
  public DockerSwarmSDConfigBuilder(DockerSwarmSDConfigFluent<?> fluent) {
    this(fluent, new DockerSwarmSDConfig());
  }
  
  public DockerSwarmSDConfigBuilder(DockerSwarmSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DockerSwarmSDConfigBuilder(DockerSwarmSDConfigFluent<?> fluent,DockerSwarmSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DockerSwarmSDConfig build() {
    DockerSwarmSDConfig buildable = new DockerSwarmSDConfig(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getEnableHTTP2(), fluent.buildFilters(), fluent.getFollowRedirects(), fluent.getHost(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getRole(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}