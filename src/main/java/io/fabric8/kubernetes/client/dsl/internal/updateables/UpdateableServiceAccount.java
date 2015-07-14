package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.api.model.ServiceAccountFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;


public class UpdateableServiceAccount extends ServiceAccountFluent<UpdateableServiceAccount> implements Updateable<ServiceAccount> {

  private final ServiceAccountBuilder builder;
  private final Update<ServiceAccount> update;


  public UpdateableServiceAccount(ServiceAccount serviceAccount, Update<ServiceAccount> update) {
    this.update = update;
    builder = new ServiceAccountBuilder(this, serviceAccount);
  }
  
  @Override
  public ServiceAccount update() {
    return update.apply(builder.build());
  }
}
