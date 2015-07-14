package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateablePersistentVolumeClaim extends PersistentVolumeClaimFluent<UpdateablePersistentVolumeClaim> implements Updateable<PersistentVolumeClaim> {

  private final PersistentVolumeClaimBuilder builder;
  private final Update<PersistentVolumeClaim> update;

  public UpdateablePersistentVolumeClaim(PersistentVolumeClaim persistentVolumeClaim, Update<PersistentVolumeClaim> update) {
    this.update = update;
    builder = new PersistentVolumeClaimBuilder(this, persistentVolumeClaim);
  }

  @Override
  public PersistentVolumeClaim update() {
    return update.apply(builder.build());
  }
}
