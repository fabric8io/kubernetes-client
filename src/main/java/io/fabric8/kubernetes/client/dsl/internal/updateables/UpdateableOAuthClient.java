package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientFluent;

public class UpdateableOAuthClient extends OAuthClientFluent<UpdateableOAuthClient> implements Updateable<OAuthClient> {

  @Override
  public OAuthClient update() {
    return null;
  }
}
