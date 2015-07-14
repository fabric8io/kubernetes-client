package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateablePersistentVolumeClaim extends PersistentVolumeClaimFluent<UpdateablePersistentVolumeClaim> implements Updateable<PersistentVolumeClaim> {

  @Override
  public PersistentVolumeClaim update() {
    return null;
  }
}
