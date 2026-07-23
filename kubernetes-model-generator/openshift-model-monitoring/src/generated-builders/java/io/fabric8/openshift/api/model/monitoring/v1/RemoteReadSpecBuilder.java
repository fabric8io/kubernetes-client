package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteReadSpecBuilder extends RemoteReadSpecFluent<RemoteReadSpecBuilder> implements VisitableBuilder<RemoteReadSpec,RemoteReadSpecBuilder>{

  RemoteReadSpecFluent<?> fluent;

  public RemoteReadSpecBuilder() {
    this(new RemoteReadSpec());
  }
  
  public RemoteReadSpecBuilder(RemoteReadSpecFluent<?> fluent) {
    this(fluent, new RemoteReadSpec());
  }
  
  public RemoteReadSpecBuilder(RemoteReadSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteReadSpecBuilder(RemoteReadSpecFluent<?> fluent,RemoteReadSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteReadSpec build() {
    RemoteReadSpec buildable = new RemoteReadSpec(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerToken(), fluent.getBearerTokenFile(), fluent.getFilterExternalLabels(), fluent.getFollowRedirects(), fluent.getHeaders(), fluent.getName(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getReadRecent(), fluent.getRemoteTimeout(), fluent.getRequiredMatchers(), fluent.buildTlsConfig(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}