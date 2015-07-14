package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableSecret extends SecretFluent<UpdateableSecret> implements Updateable<Secret> {

  @Override
  public Secret update() {
    return null;
  }
}
