package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuth2Builder extends OAuth2Fluent<OAuth2Builder> implements VisitableBuilder<OAuth2,OAuth2Builder>{

  OAuth2Fluent<?> fluent;

  public OAuth2Builder() {
    this(new OAuth2());
  }
  
  public OAuth2Builder(OAuth2Fluent<?> fluent) {
    this(fluent, new OAuth2());
  }
  
  public OAuth2Builder(OAuth2 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuth2Builder(OAuth2Fluent<?> fluent,OAuth2 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuth2 build() {
    OAuth2 buildable = new OAuth2(fluent.buildClientId(), fluent.getClientSecret(), fluent.getEndpointParams(), fluent.getNoProxy(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getScopes(), fluent.buildTlsConfig(), fluent.getTokenUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}