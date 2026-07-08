package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureDiskVolumeSourceBuilder extends AzureDiskVolumeSourceFluent<AzureDiskVolumeSourceBuilder> implements VisitableBuilder<AzureDiskVolumeSource,AzureDiskVolumeSourceBuilder>{

  AzureDiskVolumeSourceFluent<?> fluent;

  public AzureDiskVolumeSourceBuilder() {
    this(new AzureDiskVolumeSource());
  }
  
  public AzureDiskVolumeSourceBuilder(AzureDiskVolumeSourceFluent<?> fluent) {
    this(fluent, new AzureDiskVolumeSource());
  }
  
  public AzureDiskVolumeSourceBuilder(AzureDiskVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureDiskVolumeSourceBuilder(AzureDiskVolumeSourceFluent<?> fluent,AzureDiskVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureDiskVolumeSource build() {
    AzureDiskVolumeSource buildable = new AzureDiskVolumeSource(fluent.getCachingMode(), fluent.getDiskName(), fluent.getDiskURI(), fluent.getFsType(), fluent.getKind(), fluent.getReadOnly());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}