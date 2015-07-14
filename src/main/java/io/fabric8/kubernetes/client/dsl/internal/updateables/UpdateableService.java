package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableService extends ServiceFluent<UpdateableService> implements Updateable<Service> {

  private final ServiceBuilder builder;
  private final Update<Service> update;

  public UpdateableService(Service service, Update<Service> update) {
    this.update = update;
    builder = new ServiceBuilder(this, service);
  }

  @Override
  public Service update() {
    return update.apply(builder.build());
  }
}
