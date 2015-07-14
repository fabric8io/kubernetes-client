package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateablePersistentVolume extends PersistentVolumeFluent<UpdateablePersistentVolume> implements Updateable<PersistentVolume> {

  private final PersistentVolumeBuilder builder;
  private final Update<PersistentVolume> update;

  public UpdateablePersistentVolume(PersistentVolume persistentVolume, Update<PersistentVolume> update) {
    this.update = update;
    builder = new PersistentVolumeBuilder(this, persistentVolume);
  }

  @Override
  public PersistentVolume update() {
    return update.apply(builder.build());
  }
}
