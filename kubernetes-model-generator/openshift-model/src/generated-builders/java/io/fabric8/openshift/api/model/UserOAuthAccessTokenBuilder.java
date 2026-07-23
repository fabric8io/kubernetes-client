package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserOAuthAccessTokenBuilder extends UserOAuthAccessTokenFluent<UserOAuthAccessTokenBuilder> implements VisitableBuilder<UserOAuthAccessToken,UserOAuthAccessTokenBuilder>{

  UserOAuthAccessTokenFluent<?> fluent;

  public UserOAuthAccessTokenBuilder() {
    this(new UserOAuthAccessToken());
  }
  
  public UserOAuthAccessTokenBuilder(UserOAuthAccessTokenFluent<?> fluent) {
    this(fluent, new UserOAuthAccessToken());
  }
  
  public UserOAuthAccessTokenBuilder(UserOAuthAccessToken instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserOAuthAccessTokenBuilder(UserOAuthAccessTokenFluent<?> fluent,UserOAuthAccessToken instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserOAuthAccessToken build() {
    UserOAuthAccessToken buildable = new UserOAuthAccessToken(fluent.getApiVersion(), fluent.getAuthorizeToken(), fluent.getClientName(), fluent.getExpiresIn(), fluent.getInactivityTimeoutSeconds(), fluent.getKind(), fluent.buildMetadata(), fluent.getRedirectURI(), fluent.getRefreshToken(), fluent.getScopes(), fluent.getUserName(), fluent.getUserUID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}