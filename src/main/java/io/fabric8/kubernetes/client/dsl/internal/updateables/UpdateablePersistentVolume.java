package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateablePersistentVolume extends PersistentVolumeFluent<UpdateablePersistentVolume> implements Updateable<PersistentVolume> {

  @Override
  public PersistentVolume update() {
    return null;
  }
}
