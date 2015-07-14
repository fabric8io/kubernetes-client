package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.OAuthAccessTokenFluent;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenBuilder;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenFluent;

public class UpdateableOAuthAuthorizeToken extends OAuthAuthorizeTokenFluent<UpdateableOAuthAuthorizeToken> implements Updateable<OAuthAuthorizeToken> {

  private final OAuthAuthorizeTokenBuilder builder;
  private final Update<OAuthAuthorizeToken> update;

  public UpdateableOAuthAuthorizeToken(OAuthAuthorizeToken oAuthAuthorizeToken, Update<OAuthAuthorizeToken> update) {
    this.update = update;
    builder = new OAuthAuthorizeTokenBuilder(this, oAuthAuthorizeToken);
  }

  @Override
  public OAuthAuthorizeToken update() {
    return update.apply(builder.build());
  }
}
