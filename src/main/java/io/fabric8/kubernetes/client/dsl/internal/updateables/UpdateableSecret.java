package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.api.model.SecretFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableSecret extends SecretFluent<UpdateableSecret> implements Updateable<Secret> {

  private final SecretBuilder builder;
  private final Update<Secret> update;

  public UpdateableSecret(Secret secret, Update<Secret> update) {
    this.update = update;
    builder = new SecretBuilder(this, secret);
  }

  @Override
  public Secret update() {
    return update.apply(builder.build());
  }
}
