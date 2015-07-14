package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.PodFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenBuilder;
import io.fabric8.openshift.api.model.OAuthAccessTokenFluent;

public class UpdateableOAuthAccessToken extends OAuthAccessTokenFluent<UpdateableOAuthAccessToken> implements Updateable<OAuthAccessToken> {

  private final OAuthAccessTokenBuilder builder;
  private final Update<OAuthAccessToken> update;

  public UpdateableOAuthAccessToken(OAuthAccessToken oAuthAccessToken, Update<OAuthAccessToken> update) {
    this.update = update;
    builder = new OAuthAccessTokenBuilder(this, oAuthAccessToken);
  }

  @Override
  public OAuthAccessToken update() {
    return update.apply(builder.build());
  }
}
