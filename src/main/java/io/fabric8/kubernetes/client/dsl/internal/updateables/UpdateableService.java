package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableService extends ServiceFluent<UpdateableService> implements Updateable<Service> {

  @Override
  public Service update() {
    return null;
  }
}
