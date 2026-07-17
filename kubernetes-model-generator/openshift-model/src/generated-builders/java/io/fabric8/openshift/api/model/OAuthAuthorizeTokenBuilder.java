package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthAuthorizeTokenBuilder extends OAuthAuthorizeTokenFluent<OAuthAuthorizeTokenBuilder> implements VisitableBuilder<OAuthAuthorizeToken,OAuthAuthorizeTokenBuilder>{

  OAuthAuthorizeTokenFluent<?> fluent;

  public OAuthAuthorizeTokenBuilder() {
    this(new OAuthAuthorizeToken());
  }
  
  public OAuthAuthorizeTokenBuilder(OAuthAuthorizeTokenFluent<?> fluent) {
    this(fluent, new OAuthAuthorizeToken());
  }
  
  public OAuthAuthorizeTokenBuilder(OAuthAuthorizeToken instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthAuthorizeTokenBuilder(OAuthAuthorizeTokenFluent<?> fluent,OAuthAuthorizeToken instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthAuthorizeToken build() {
    OAuthAuthorizeToken buildable = new OAuthAuthorizeToken(fluent.getApiVersion(), fluent.getClientName(), fluent.getCodeChallenge(), fluent.getCodeChallengeMethod(), fluent.getExpiresIn(), fluent.getKind(), fluent.buildMetadata(), fluent.getRedirectURI(), fluent.getScopes(), fluent.getState(), fluent.getUserName(), fluent.getUserUID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}