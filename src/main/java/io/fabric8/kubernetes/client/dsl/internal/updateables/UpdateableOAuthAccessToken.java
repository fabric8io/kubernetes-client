package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.OAuthAccessToken;

public class UpdateableOAuthAccessToken extends PodFluent<UpdateableOAuthAccessToken> implements Updateable<OAuthAccessToken> {

  @Override
  public OAuthAccessToken update() {
    return null;
  }
}
