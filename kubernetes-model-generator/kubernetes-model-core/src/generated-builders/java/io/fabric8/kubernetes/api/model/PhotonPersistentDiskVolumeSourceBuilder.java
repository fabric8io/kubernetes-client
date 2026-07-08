package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhotonPersistentDiskVolumeSourceBuilder extends PhotonPersistentDiskVolumeSourceFluent<PhotonPersistentDiskVolumeSourceBuilder> implements VisitableBuilder<PhotonPersistentDiskVolumeSource,PhotonPersistentDiskVolumeSourceBuilder>{

  PhotonPersistentDiskVolumeSourceFluent<?> fluent;

  public PhotonPersistentDiskVolumeSourceBuilder() {
    this(new PhotonPersistentDiskVolumeSource());
  }
  
  public PhotonPersistentDiskVolumeSourceBuilder(PhotonPersistentDiskVolumeSourceFluent<?> fluent) {
    this(fluent, new PhotonPersistentDiskVolumeSource());
  }
  
  public PhotonPersistentDiskVolumeSourceBuilder(PhotonPersistentDiskVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhotonPersistentDiskVolumeSourceBuilder(PhotonPersistentDiskVolumeSourceFluent<?> fluent,PhotonPersistentDiskVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhotonPersistentDiskVolumeSource build() {
    PhotonPersistentDiskVolumeSource buildable = new PhotonPersistentDiskVolumeSource(fluent.getFsType(), fluent.getPdID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}