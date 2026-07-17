package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthAccessTokenBuilder extends OAuthAccessTokenFluent<OAuthAccessTokenBuilder> implements VisitableBuilder<OAuthAccessToken,OAuthAccessTokenBuilder>{

  OAuthAccessTokenFluent<?> fluent;

  public OAuthAccessTokenBuilder() {
    this(new OAuthAccessToken());
  }
  
  public OAuthAccessTokenBuilder(OAuthAccessTokenFluent<?> fluent) {
    this(fluent, new OAuthAccessToken());
  }
  
  public OAuthAccessTokenBuilder(OAuthAccessToken instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthAccessTokenBuilder(OAuthAccessTokenFluent<?> fluent,OAuthAccessToken instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthAccessToken build() {
    OAuthAccessToken buildable = new OAuthAccessToken(fluent.getApiVersion(), fluent.getAuthorizeToken(), fluent.getClientName(), fluent.getExpiresIn(), fluent.getInactivityTimeoutSeconds(), fluent.getKind(), fluent.buildMetadata(), fluent.getRedirectURI(), fluent.getRefreshToken(), fluent.getScopes(), fluent.getUserName(), fluent.getUserUID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}