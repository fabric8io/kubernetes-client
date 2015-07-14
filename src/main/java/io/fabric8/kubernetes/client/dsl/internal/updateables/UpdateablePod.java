package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateablePod extends PodFluent<UpdateablePod> implements Updateable<Pod> {

  @Override
  public Pod update() {
    return null;
  }
}
