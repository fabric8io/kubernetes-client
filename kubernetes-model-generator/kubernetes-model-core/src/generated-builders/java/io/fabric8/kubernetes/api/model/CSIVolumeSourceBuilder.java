package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSIVolumeSourceBuilder extends CSIVolumeSourceFluent<CSIVolumeSourceBuilder> implements VisitableBuilder<CSIVolumeSource,CSIVolumeSourceBuilder>{

  CSIVolumeSourceFluent<?> fluent;

  public CSIVolumeSourceBuilder() {
    this(new CSIVolumeSource());
  }
  
  public CSIVolumeSourceBuilder(CSIVolumeSourceFluent<?> fluent) {
    this(fluent, new CSIVolumeSource());
  }
  
  public CSIVolumeSourceBuilder(CSIVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSIVolumeSourceBuilder(CSIVolumeSourceFluent<?> fluent,CSIVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSIVolumeSource build() {
    CSIVolumeSource buildable = new CSIVolumeSource(fluent.getDriver(), fluent.getFsType(), fluent.buildNodePublishSecretRef(), fluent.getReadOnly(), fluent.getVolumeAttributes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}