package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthRemoteConnectionInfoBuilder extends OAuthRemoteConnectionInfoFluent<OAuthRemoteConnectionInfoBuilder> implements VisitableBuilder<OAuthRemoteConnectionInfo,OAuthRemoteConnectionInfoBuilder>{

  OAuthRemoteConnectionInfoFluent<?> fluent;

  public OAuthRemoteConnectionInfoBuilder() {
    this(new OAuthRemoteConnectionInfo());
  }
  
  public OAuthRemoteConnectionInfoBuilder(OAuthRemoteConnectionInfoFluent<?> fluent) {
    this(fluent, new OAuthRemoteConnectionInfo());
  }
  
  public OAuthRemoteConnectionInfoBuilder(OAuthRemoteConnectionInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthRemoteConnectionInfoBuilder(OAuthRemoteConnectionInfoFluent<?> fluent,OAuthRemoteConnectionInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthRemoteConnectionInfo build() {
    OAuthRemoteConnectionInfo buildable = new OAuthRemoteConnectionInfo(fluent.buildCa(), fluent.buildTlsClientCert(), fluent.buildTlsClientKey(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}