package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageOSVolumeSourceBuilder extends StorageOSVolumeSourceFluent<StorageOSVolumeSourceBuilder> implements VisitableBuilder<StorageOSVolumeSource,StorageOSVolumeSourceBuilder>{

  StorageOSVolumeSourceFluent<?> fluent;

  public StorageOSVolumeSourceBuilder() {
    this(new StorageOSVolumeSource());
  }
  
  public StorageOSVolumeSourceBuilder(StorageOSVolumeSourceFluent<?> fluent) {
    this(fluent, new StorageOSVolumeSource());
  }
  
  public StorageOSVolumeSourceBuilder(StorageOSVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageOSVolumeSourceBuilder(StorageOSVolumeSourceFluent<?> fluent,StorageOSVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageOSVolumeSource build() {
    StorageOSVolumeSource buildable = new StorageOSVolumeSource(fluent.getFsType(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getVolumeName(), fluent.getVolumeNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}