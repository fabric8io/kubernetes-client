package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageOSPersistentVolumeSourceBuilder extends StorageOSPersistentVolumeSourceFluent<StorageOSPersistentVolumeSourceBuilder> implements VisitableBuilder<StorageOSPersistentVolumeSource,StorageOSPersistentVolumeSourceBuilder>{

  StorageOSPersistentVolumeSourceFluent<?> fluent;

  public StorageOSPersistentVolumeSourceBuilder() {
    this(new StorageOSPersistentVolumeSource());
  }
  
  public StorageOSPersistentVolumeSourceBuilder(StorageOSPersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new StorageOSPersistentVolumeSource());
  }
  
  public StorageOSPersistentVolumeSourceBuilder(StorageOSPersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageOSPersistentVolumeSourceBuilder(StorageOSPersistentVolumeSourceFluent<?> fluent,StorageOSPersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageOSPersistentVolumeSource build() {
    StorageOSPersistentVolumeSource buildable = new StorageOSPersistentVolumeSource(fluent.getFsType(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getVolumeName(), fluent.getVolumeNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}