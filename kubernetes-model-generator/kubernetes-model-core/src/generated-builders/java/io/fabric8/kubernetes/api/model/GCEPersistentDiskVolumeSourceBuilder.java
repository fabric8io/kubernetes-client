package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCEPersistentDiskVolumeSourceBuilder extends GCEPersistentDiskVolumeSourceFluent<GCEPersistentDiskVolumeSourceBuilder> implements VisitableBuilder<GCEPersistentDiskVolumeSource,GCEPersistentDiskVolumeSourceBuilder>{

  GCEPersistentDiskVolumeSourceFluent<?> fluent;

  public GCEPersistentDiskVolumeSourceBuilder() {
    this(new GCEPersistentDiskVolumeSource());
  }
  
  public GCEPersistentDiskVolumeSourceBuilder(GCEPersistentDiskVolumeSourceFluent<?> fluent) {
    this(fluent, new GCEPersistentDiskVolumeSource());
  }
  
  public GCEPersistentDiskVolumeSourceBuilder(GCEPersistentDiskVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCEPersistentDiskVolumeSourceBuilder(GCEPersistentDiskVolumeSourceFluent<?> fluent,GCEPersistentDiskVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCEPersistentDiskVolumeSource build() {
    GCEPersistentDiskVolumeSource buildable = new GCEPersistentDiskVolumeSource(fluent.getFsType(), fluent.getPartition(), fluent.getPdName(), fluent.getReadOnly());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}