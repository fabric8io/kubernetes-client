package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientBuilder;
import io.fabric8.openshift.api.model.OAuthClientFluent;

public class UpdateableOAuthClient extends OAuthClientFluent<UpdateableOAuthClient> implements Updateable<OAuthClient> {

  private final OAuthClientBuilder builder;
  private final Update<OAuthClient> update;

  public UpdateableOAuthClient(OAuthClient oAuthClient, Update<OAuthClient> update) {
    this.update = update;
    builder = new OAuthClientBuilder(this, oAuthClient);
  }

  @Override
  public OAuthClient update() {
    return update.apply(builder.build());
  }
}
