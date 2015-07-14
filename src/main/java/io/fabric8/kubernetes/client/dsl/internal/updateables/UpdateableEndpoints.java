package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsFluent;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableEndpoints extends EndpointsFluent<UpdateableEndpoints> implements Updateable<Endpoints> {

  @Override
  public Endpoints update() {
    return null;
  }
}
