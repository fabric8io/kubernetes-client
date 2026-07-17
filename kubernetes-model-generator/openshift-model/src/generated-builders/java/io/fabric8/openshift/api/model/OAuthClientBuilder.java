package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthClientBuilder extends OAuthClientFluent<OAuthClientBuilder> implements VisitableBuilder<OAuthClient,OAuthClientBuilder>{

  OAuthClientFluent<?> fluent;

  public OAuthClientBuilder() {
    this(new OAuthClient());
  }
  
  public OAuthClientBuilder(OAuthClientFluent<?> fluent) {
    this(fluent, new OAuthClient());
  }
  
  public OAuthClientBuilder(OAuthClient instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthClientBuilder(OAuthClientFluent<?> fluent,OAuthClient instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthClient build() {
    OAuthClient buildable = new OAuthClient(fluent.getAccessTokenInactivityTimeoutSeconds(), fluent.getAccessTokenMaxAgeSeconds(), fluent.getAdditionalSecrets(), fluent.getApiVersion(), fluent.getGrantMethod(), fluent.getKind(), fluent.buildMetadata(), fluent.getRedirectURIs(), fluent.getRespondWithChallenges(), fluent.buildScopeRestrictions(), fluent.getSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}