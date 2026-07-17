package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteWriteSpecBuilder extends RemoteWriteSpecFluent<RemoteWriteSpecBuilder> implements VisitableBuilder<RemoteWriteSpec,RemoteWriteSpecBuilder>{

  RemoteWriteSpecFluent<?> fluent;

  public RemoteWriteSpecBuilder() {
    this(new RemoteWriteSpec());
  }
  
  public RemoteWriteSpecBuilder(RemoteWriteSpecFluent<?> fluent) {
    this(fluent, new RemoteWriteSpec());
  }
  
  public RemoteWriteSpecBuilder(RemoteWriteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteWriteSpecBuilder(RemoteWriteSpecFluent<?> fluent,RemoteWriteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteWriteSpec build() {
    RemoteWriteSpec buildable = new RemoteWriteSpec(fluent.buildAuthorization(), fluent.buildAzureAd(), fluent.buildBasicAuth(), fluent.getBearerToken(), fluent.getBearerTokenFile(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getHeaders(), fluent.getMessageVersion(), fluent.buildMetadataConfig(), fluent.getName(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.buildQueueConfig(), fluent.getRemoteTimeout(), fluent.getRoundRobinDNS(), fluent.getSendExemplars(), fluent.getSendNativeHistograms(), fluent.buildSigv4(), fluent.buildTlsConfig(), fluent.getUrl(), fluent.buildWriteRelabelConfigs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}