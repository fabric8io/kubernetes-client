package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsBuilder;
import io.fabric8.kubernetes.api.model.EndpointsFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableEndpoints extends EndpointsFluent<UpdateableEndpoints> implements Updateable<Endpoints> {

  private final EndpointsBuilder builder;
  private final Update<Endpoints> update;

  public UpdateableEndpoints(Endpoints endpoints, Update<Endpoints> update) {
    this.update = update;
    builder = new EndpointsBuilder(this, endpoints);
  }
  @Override
  public Endpoints update() {
    return update.apply(builder.build());
  }
}
