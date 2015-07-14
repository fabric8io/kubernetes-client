package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableReplicationController extends ReplicationControllerFluent<UpdateableReplicationController> implements Updateable<ReplicationController> {

  private final ReplicationControllerBuilder builder;
  private final Update<ReplicationController> update;

  public UpdateableReplicationController(ReplicationController replicationController, Update<ReplicationController> update) {
    this.update = update;
    builder = new ReplicationControllerBuilder(this, replicationController);
  }

  @Override
  public ReplicationController update() {
    return update.apply(builder.build());
  }
}
