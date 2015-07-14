package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.api.model.RouteFluent;

public class UpdateableRoute extends RouteFluent<UpdateableRoute> implements Updateable<Route> {

  private final RouteBuilder builder;
  private final Update<Route> update;

  public UpdateableRoute(Route route, Update<Route> update) {
    this.update = update;
    builder = new RouteBuilder(this, route);
  }

  @Override
  public Route update() {
    return update.apply(builder.build());
  }
}
