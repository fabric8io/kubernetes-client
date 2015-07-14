package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteFluent;

public class UpdateableRoute extends RouteFluent<UpdateableRoute> implements Updateable<Route> {

  @Override
  public Route update() {
    return null;
  }
}
