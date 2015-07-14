package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableReplicationController extends ReplicationControllerFluent<UpdateableReplicationController> implements Updateable<ReplicationController> {

  @Override
  public ReplicationController update() {
    return null;
  }
}
