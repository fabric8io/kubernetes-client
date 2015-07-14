package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateablePod extends PodFluent<UpdateablePod> implements Updateable<Pod> {

  private final PodBuilder builder;
  private final Update<Pod> update;

  public UpdateablePod(Pod pod, Update<Pod> update) {
    this.update = update;
    builder = new PodBuilder(this, pod);
  }

  @Override
  public Pod update() {
    return update.apply(builder.build());
  }
}
