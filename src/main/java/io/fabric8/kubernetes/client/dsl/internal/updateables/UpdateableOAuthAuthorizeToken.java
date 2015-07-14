package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.OAuthAccessTokenFluent;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;

public class UpdateableOAuthAuthorizeToken extends OAuthAccessTokenFluent<UpdateableOAuthAuthorizeToken> implements Updateable<OAuthAuthorizeToken> {

  @Override
  public OAuthAuthorizeToken update() {
    return null;
  }
}
