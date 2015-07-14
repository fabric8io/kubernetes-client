package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretFluent;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableServiceAccount extends ServiceAccountFluent<UpdateableServiceAccount> implements Updateable<ServiceAccount> {

  @Override
  public ServiceAccount update() {
    return null;
  }
}
